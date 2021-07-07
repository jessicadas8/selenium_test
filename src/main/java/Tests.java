import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


public class Tests {

    /**
     * method to return a chrome driver instance
     * @return
     */

    //@BeforeTest
    public static WebDriver openChromeDriver(){

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\jessica das\\OneDrive\\Desktop\\chromdriver\\chromedriver_win32 (5)\\chromedriver.exe");
        return  new ChromeDriver();
    }

    //@Test(priority=0)  bye
    public static WebDriver login(){
        WebDriver driver = openChromeDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        return driver;
    }
    @Test
    public static void bookAppointment(){
        WebDriver driver = login();
        new Select(driver.findElement(By.xpath("//select[@id='combo_facility']"))).selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//tr//td[contains(text(),\"11\")]")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("test script");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        driver.quit();
    }

    @Test
    public static void bookSecondAppointment(){
        //2nd page
        WebDriver driver = login();
        new Select(driver.findElement(By.xpath("//select[@id='combo_facility']"))).selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//tr//td[contains(text(),\"11\")]")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("test script");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        //check heading
        Assert.assertEquals(true,driver.findElement(By.xpath("//h2")).isDisplayed()); //ok? yes
        System.out.println("Appointment is confirmed");
        //Check title
        String expectedTitle="CURA Healthcare Service fail";//ye fail kara rahe ho?yes
        Assert.assertEquals(driver.getTitle(),expectedTitle);

        //check facility
        //WebElement facility=driver.findElement(By.xpath("//p[@id='facility']"));
        Assert.assertEquals("Seoul CURA Healthcare Center",driver.findElement(By.xpath("//p[@id='facility']")).getText());
        System.out.println("Facility is executed");
        driver.quit();
    }

    public static void main(String[] args) {

    }

}
