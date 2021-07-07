import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class Tests {

    /**
     * method to return a chrome driver instance
     * @return
     */

    public static WebDriver driver;

    public static void selectDriver(){
        System.out.println("Running on "+System.getenv("BROWSER"));
        if(System.getenv("BROWSER").equalsIgnoreCase("CHROME"))
        {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(System.getenv("BROWSER").equalsIgnoreCase("FIREFOX")){
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @BeforeMethod
    public static void openDriver(){
        System.out.println("Executes before each @Test & spins up a new browser");
        selectDriver();
    }



    @AfterTest
    public static void closeBrowser(){
        System.out.println("Executes once after all tests are complete");
        driver.quit();
    }

}
