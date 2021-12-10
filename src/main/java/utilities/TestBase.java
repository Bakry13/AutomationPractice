package utilities;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //in case running using testNG parallel testing
    public static ThreadLocal<String> browserType = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public static String URL = "http://automationpractice.com/index.php";
    public static Actions actions;
    ChromeOptions chromeOptions = new ChromeOptions();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    EdgeOptions edgeOptions = new EdgeOptions();
    DesiredCapabilities ieCapabilities = new DesiredCapabilities();
    //===================================Set Drivers Options and capabilities===========================
    //--------------------------------Driver Options------------------------------------
    public void setChromePreferences() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromeOptions.setCapability("prefs", chromePrefs);
        chromeOptions.addArguments("--window-size=1024,768");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
//        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
    }

    public void getChromeDriver() {
        driver.set(new ChromeDriver(chromeOptions));
    }

    //------------------------------------------Firefox options---------------------------------
    public void setFirefoxCapabilities() {
        firefoxOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        firefoxOptions.addArguments("--no-sandbox"); // Bypass OS security model
        firefoxOptions.addArguments("--headless");
        WebDriverManager.firefoxdriver().clearDriverCache();
        WebDriverManager.firefoxdriver().setup();
    }

    public void getFirefoxDriver() {
        driver.set(new FirefoxDriver(firefoxOptions));
    }

    //-----------------------------------IE Capabilities--------------------------------------
    public void setIeCapabilities() {
        ieCapabilities.setCapability("EnableNativeEvents", true);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);
        ieCapabilities.setCapability("ignoreZoomSetting", true);
        ieCapabilities.setCapability("RequireWindowFocus", true);
        WebDriverManager.iedriver().clearDriverCache();
        WebDriverManager.iedriver().arch32().setup();
    }

    public void getIeDriver() {
        driver.set(new InternetExplorerDriver(ieCapabilities));
    }

    //-----------------------------------Edge Capabilities----------------------------------
    public void setEdgeCapabilities() {
        edgeOptions.addArguments("--disable-dev-shm-usage");
        edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        edgeOptions.addArguments("--headless");
        WebDriverManager.edgedriver().clearDriverCache();
        WebDriverManager.edgedriver().setup();
    }

    public void getEdgeDriver() {
        driver.set(new EdgeDriver(edgeOptions));
    }

    //==============================Set BrowserType================================
    @BeforeTest
    @Parameters("browser")
    public void setBrowserType(@Optional("Chrome") String browser) {
        browserType.set(browser);
        launchBrowser();}
    //=================================launch Browser================================
    public void launchBrowser(){
        if (getBrowserType().equalsIgnoreCase("Chrome")) {
            setChromePreferences();
            getChromeDriver();
        } else if (getBrowserType().equalsIgnoreCase("Firefox")) {
            setFirefoxCapabilities();
            getFirefoxDriver();
        } else if (getBrowserType().equalsIgnoreCase("IE")) {
            setIeCapabilities();
            getIeDriver();
        } else if (getBrowserType().equalsIgnoreCase("Edge")) {
            setEdgeCapabilities();
            getEdgeDriver();
        }
        getDriver().manage().window().maximize();
        ConfigUtil.loadTestConfigurations();
        getDriver().manage().deleteAllCookies();
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(5)));
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public String getBrowserType()
    {
        return browserType.get();
    }

    public WebDriverWait getWait()
    {
        return wait.get();
    }
//===================================================================================
    public void openWebsite()
    {
        URL = ConfigUtil.Web_URL;
        getDriver().navigate().to(URL);
    }

   @AfterTest
    public void quitDriver()
    {
        getDriver().quit();
    }
}

