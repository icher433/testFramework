
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public abstract class BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public abstract void isPageOpened();
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        String pageName = this.getClass().getSimpleName();
        this.driver = driver;
        driver.manage().window().maximize();
        LOG.debug("open {}", pageName);
        waitForOpen();

    }

    /**
     * Waiting for page opening
     */
    protected void waitForOpen() {
        LOG.info("{} page loading started", this.getClass().getSimpleName());
        long currentTime = System.currentTimeMillis();
        try {
            isPageOpened();
        } catch (WebDriverException e) {
            IllegalStateException pageNotOpenedException =
                    new IllegalStateException(this.getClass().getSimpleName() + " page was not opened!\n"
                            + e.getMessage(), e.getCause());
            throw pageNotOpenedException;
        }
        LOG.info(String.format("%s page loaded in %.1f s on %s url",
                this.getClass().getSimpleName(),
                (float) (System.currentTimeMillis() - currentTime) / 1000,
                driver.getCurrentUrl()));
    }
}