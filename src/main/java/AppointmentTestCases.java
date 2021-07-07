import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTestCases extends LoginTestCases{
    @Test
    public static void bookAppointmentScenarioOne(){
        System.out.println("Executing test case 1");
        login();
        new Select(driver.findElement(By.xpath("//select[@id='combo_facility']"))).selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//tr//td[contains(text(),\"11\")]")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("test script");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        driver.close();
    }

    @Test
    public static void bookAppointmentScenarioTwo(){
        System.out.println("Executing test case2, expected to fail to check assertion");
        login();
        new Select(driver.findElement(By.xpath("//select[@id='combo_facility']"))).selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//tr//td[contains(text(),\"11\")]")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).click();
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("test script");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        //check heading
        Assert.assertEquals(true,driver.findElement(By.xpath("//h2")).isDisplayed());
        System.out.println("Appointment is confirmed");
        //Check title
        String expectedTitle="CURA Healthcare Service";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        //check facility
        //WebElement facility=driver.findElement(By.xpath("//p[@id='facility']"));
        Assert.assertEquals("Seoul CURA Healthcare Center",driver.findElement(By.xpath("//p[@id='facility']")).getText());
        driver.close();
    }
}
