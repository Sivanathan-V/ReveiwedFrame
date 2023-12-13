package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

public class Mobile_BasePage {


    public static IOSDriver iosDriver;
    public static AppiumDriverLocalService service;
    public static AppiumDriver appiumDriver;
    public static AndroidDriver androidDriver;
    public static WebDriver driver;
    public static DesiredCapabilities capabilities = null;


    public static AppiumDriverLocalService initializeServer(String host, String port) {
        try {
            int parseInt = Integer.parseInt(port);
            service = (new AppiumServiceBuilder().withTimeout(Duration.ofSeconds(300)).withIPAddress(host)
                    .usingPort(parseInt).build());

            service.start();

        } catch (Exception e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            service.stop();
        }

        return service;
    }


    public static DesiredCapabilities capabilities(String iosOrAndroid, String deviceName, String platformName,
                                                   String platformVersion, String automationName, String udid, String appPackage, String appActivity) {

        try {

            capabilities = new DesiredCapabilities();
            if (iosOrAndroid.equalsIgnoreCase("android")) {
                capabilities.setCapability("deviceName", deviceName);
                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability("platformVersion", platformVersion);
                capabilities.setCapability("automationName", automationName);
                capabilities.setCapability("udid", udid);
                capabilities.setCapability("appPackage", appPackage);
                capabilities.setCapability("appActivity", appActivity);
            } else if (iosOrAndroid.equalsIgnoreCase("ios")) {
                capabilities.setCapability("deviceName", deviceName);
                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability("platformVersion", platformVersion);
                capabilities.setCapability("automationName", automationName);
                capabilities.setCapability("udid", udid);
                capabilities.setCapability("appPackage", appPackage);
                capabilities.setCapability("appActivity", appActivity);

            }

            capabilities.setCapability("noReset", true);
            capabilities.setCapability("fullReset", false);
        } catch (Exception e) {


        }
        return capabilities;
    }

    public static WebDriver getDriver(String platform){

        try {


            switch (platform.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
                case "android":
                    String androiURL = service.getUrl().toString();
                    androidDriver = new AndroidDriver(new URI(androiURL).toURL(), capabilities);
                case "ios":
                    String iosURL = service.getUrl().toString();
                    iosDriver = new IOSDriver(new URI(iosURL).toURL(), capabilities);
                default:
                    break;
            }
        } catch (Exception e) {

        }


        return driver;
    }

    public WebDriver launchingMobileApp(String iosOrAndroid, String deviceName, String platformName,
                                        String platformVersion, String automationName, String udid, String appPackage, String appActivity) {

        if (Objects.isNull(driver)) {
            try {

                DesiredCapabilities cap = new DesiredCapabilities();
                if (iosOrAndroid.equalsIgnoreCase("android")) {
                    cap.setCapability("deviceName", deviceName);
                    cap.setCapability("platformName", platformName);
                    cap.setCapability("platformVersion", platformVersion);
                    cap.setCapability("automationName", automationName);
                    cap.setCapability("udid", udid);
                    cap.setCapability("appPackage", appPackage);
                    cap.setCapability("appActivity", appActivity);
                } else if (iosOrAndroid.equalsIgnoreCase("ios")) {
                    cap.setCapability("deviceName", deviceName);
                    cap.setCapability("platformName", platformName);
                    cap.setCapability("platformVersion", platformVersion);
                    cap.setCapability("automationName", automationName);
                    cap.setCapability("udid", udid);
                    cap.setCapability("appPackage", appPackage);
                    cap.setCapability("appActivity", appActivity);

                }

                cap.setCapability("noReset", true);
                cap.setCapability("fullReset", false);
                String url = service.getUrl().toString();
                Logger.getLogger(url);
                if (iosOrAndroid.equalsIgnoreCase("android")) {
                    driver = new AndroidDriver(new URI(url).toURL(), cap);

                } else if (iosOrAndroid.equalsIgnoreCase("ios")) {
                    driver = new IOSDriver(new URI(url).toURL(), cap);

                }

            } catch (Exception e) {
                Logger.getLogger("Unable to launch mobile application: " + e.getMessage());

            }
        }
        return driver;
    }


//    public static String getProjectPath() {
//        String property = System.getProperty("user.dir");
//        return property;
//    }

    public static Properties getPropertyFile() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream("./src/main/resources/MobileConfig.properties"));
        } catch (Exception e) {
            System.err.println("Unable to read the propertyFile: " + e.getMessage());
        }

        return properties;

    }

    public static String getPropertyFileValue(Properties properties, String key) {

        return (String) properties.get(key);


    }

    public void mobileEnter(String platform) {
        try {
            if (platform.trim().equalsIgnoreCase("android")) {
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            }
            if (platform.trim().equalsIgnoreCase("ios")) {
                ((IOSDriver) driver).executeScript("mobile: pressButton", "return");
            }

        } catch (Exception e) {
            System.err.println("Unable to perform mobile enter: " + e.getMessage());
        }

    }

    public void click(WebElement element) {
        if (androidDriver != null | iosDriver != null | driver != null) {
            elementVisibility(element);
            element.click();
        }

    }

    public void sendKeys(WebElement element, String data) {
        if (androidDriver != null | iosDriver != null | driver != null) {
            elementVisibility(element);
            element.sendKeys(data);
        }
    }

    public void implicitWait(int seconds) {
        if (androidDriver != null) {
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } else if (iosDriver != null) {
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } else if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        }

    }

    public WebElement elementVisibility(WebElement element) {

        WebDriverWait w = null;
        if (androidDriver != null) {
            w = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        } else if (iosDriver != null) {
            w = new WebDriverWait(iosDriver, Duration.ofSeconds(30));
        } else if (driver != null) {
            w = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return w.until(ExpectedConditions.visibilityOf(element));

    }

//    public void elementsVisibility(List<WebElement> element) {
//        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
//        w.until(ExpectedConditions.visibilityOfAllElements(element));
//
//    }

    public boolean isNotEndOfPage(String previousPageSource) {
        boolean b = false;
        if (androidDriver != null) {
            b = !previousPageSource.equals(androidDriver.getPageSource());
            return b;
        } else if (iosDriver != null) {
            b = !previousPageSource.equals(iosDriver.getPageSource());
            return b;
        } else if (driver != null) {
            b = !previousPageSource.equals(driver.getPageSource());

        }
        return b;

    }

    public boolean isElementEnabled(By by) {
        List<WebElement> elements = null;
        if (androidDriver != null) {
            elements = androidDriver.findElements(by);
        } else if (iosDriver != null) {
            elements = iosDriver.findElements(by);
        } else if (driver != null) {
            elements = driver.findElements(by);
        }

        return elements.isEmpty();

    }

    public void scrollDownUntilElementFound(By by) {
        try {
            if (androidDriver != null) {

            } else if (iosDriver != null) {

            } else if (driver != null) {

            }
            String previousPageSource = "";
            while (isElementEnabled(by) && isNotEndOfPage(previousPageSource)) {
                previousPageSource = driver.getPageSource();
                scrollDownSequence();
                Thread.sleep(8000);
            }
        } catch (Exception e) {
            System.err.println("Unable to perform scroll: " + e.getMessage());
        }

    }


    public void scrollDownSequence() {
        try {
            Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int endX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endY = (int) (size.getWidth() * 0.50);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 0)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())).addAction(finger
                            .createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
            ((RemoteWebDriver) driver).perform(Collections.singletonList(sequence));
        } catch (Exception e) {
            System.err.println("Unable to perform Scroll: " + e.getMessage());

        }

    }
//    public void scrollUpSequence() {
//        try {
//            Dimension size = driver.manage().window().getSize();
//            int startX = size.getWidth() / 2;
//            int endX = size.getWidth() / 2;
//            int startY = size.getHeight() / 2;
//            int endY = (int) (size.getWidth() * 0.50);
//            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            Sequence sequence = new Sequence(finger, 0)
//                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), endX, endY))
//                    .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())).addAction(finger
//                            .createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), startX, startY))
//                    .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
//            ((RemoteWebDriver) driver).perform(Collections.singletonList(sequence));
//        } catch (Exception e) {
//            System.err.println("Unable to perform Scroll: " + e.getMessage());
//
//        }
//
//    }


    public void desiredScrollSequence(int count) {
        int times = 0;
        try {
            while (count >= times) {
                scrollDownSequence();
                times++;
                Thread.sleep(6000);
            }

        } catch (Exception e) {
            System.err.println("Unable to perform scroll: " + e.getMessage());
        }

    }

//    public void tab() {
//        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
//        Point tapPoint = new Point(772, 2249);
//        Sequence tap = new Sequence(FINGER, 1);
//        tap.addAction(
//                FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//        tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), tapPoint.x,
//                tapPoint.y));
//        tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        ((RemoteWebDriver) driver).perform(Arrays.asList(tap));
//    }

    public byte[] takesScreenshot() {
        byte[] screenShot = null;
        try {
            if (androidDriver != null) {
                TakesScreenshot tc = (TakesScreenshot) androidDriver;
                screenShot = tc.getScreenshotAs(OutputType.BYTES);
            } else if (iosDriver != null) {
                TakesScreenshot tc = (TakesScreenshot) iosDriver;
                screenShot = tc.getScreenshotAs(OutputType.BYTES);
            } else if (driver != null) {
                TakesScreenshot tc = (TakesScreenshot) driver;
                screenShot = tc.getScreenshotAs(OutputType.BYTES);
            }


        } catch (Exception e) {
            Logger.getLogger("Unable to take screenshot: " + e.getMessage());
        }
        return screenShot;

    }

    public String getTimeStamp() {
        String timeStamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            timeStamp = dateFormat.format(new Date());

        } catch (Exception e) {


        }
        return timeStamp;
    }

    public File localScreenshot(String name) {
        File screenShot = null;
        try {
            if (androidDriver != null) {
                TakesScreenshot tc = (TakesScreenshot) androidDriver;
                screenShot = tc.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShot, new File("./src/test/resources/Screenshots/" + name + "_" + getTimeStamp() + ".png"));

            } else if (iosDriver != null) {
                TakesScreenshot tc = (TakesScreenshot) iosDriver;
                screenShot = tc.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShot, new File("./src/test/resources/Screenshots/" + name + "_" + getTimeStamp() + ".png"));

            } else if (driver != null) {
                TakesScreenshot tc = (TakesScreenshot) driver;
                screenShot = tc.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShot, new File("./src/test/resources/Screenshots/" + name + "_" + getTimeStamp() + ".png"));

            }

        } catch (Exception e) {
            System.err.println("Unable to take screenshot: " + e.getMessage());
        }
        return screenShot;


    }

    public byte[] screenCapture(String filepath, String fileName) {
        byte[] takesScreenshot = null;

        takesScreenshot = takesScreenshot();
        File desFile = new File(filepath);
        if (!desFile.exists()) {
            desFile.mkdirs();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = dateFormat.format(new Date());
        String screenshotPath = desFile.getPath() + File.separator + fileName + "_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(desFile, new File(screenshotPath));

            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (Exception e) {
            System.err.println("Unable save the screenshot: " + e.getMessage());
        }
        return takesScreenshot;
    }

    public String getText(WebElement element) {
        elementVisibility(element);
        String text = null;
        try {
            text = element.getText();
        } catch (Exception e) {
            System.err.println("Unable to fetch the text: " + e.getMessage());
        }

        return text;
    }

    public void datePickerS(String expMonth, String expYear, String expDate) {
        try {
            while (true) {
                String monthYear = driver.findElement(By.xpath("")).getText();

                String[] arr = monthYear.split(" ");
                String mon = arr[0];
                String yr = arr[1];
                if (mon.trim().equalsIgnoreCase(expMonth) && yr.trim().equalsIgnoreCase(expYear)) {
                    break;
                } else {
                    driver.findElement(By.xpath("")).click();
                }

            }

        } catch (Exception e) {
            System.err.println("Unable to get the month and year: " + e.getMessage());
        }
        try {
            List<WebElement> allDates = driver.findElements(By.xpath(""));
            for (WebElement ele : allDates) {
                String dt = ele.getText();
                if (dt.trim().equals(expDate)) {
                    ele.click();
                    break;

                }

            }

        } catch (Exception e) {
            System.err.println("Unable to get the date: " + e.getMessage());

        }

    }


    public static void mobileTearDown() {
        try {
            if (driver != null) {
                ((AndroidDriver)driver).closeApp();
                ((AndroidDriver)driver).close();
            }
            if (iosDriver != null) {
                ((IOSDriver)driver).closeApp();
                ((IOSDriver)driver).close();
            }
        } catch (Exception e) {
            Logger.getLogger("Error while performing mobile tear down activities. " + e.getMessage());
        }
    }

    public void adbCommandToCloseApp(String adbCommand, String appPackage) {
        // String stop = "adb shell am force-stop"+" "+getPropertyFileValue("appPackage");
        //String emu = "adb devices";
        try {
            Process exec = Runtime.getRuntime().exec(adbCommand + " " + appPackage);
            BufferedReader buff = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            System.out.println(buff.readLine());
            exec.waitFor();
            // Thread.sleep(Duration.ofSeconds(6));
        } catch (Exception e) {

        }

    }

}
