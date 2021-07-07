import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestCases extends Tests {

    public static void login(){
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
    }

    @Test
    public static void loginPass(){
        System.out.println("Login testcase1");
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        //assert title of next page is present
        driver.close();
    }
    @Test
    public static void loginFail(){
        System.out.println("Login testcase1");
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsWrongPass");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        //assert failure msg is present
        driver.close();
    }
	
}
