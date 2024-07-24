package seleniumjava;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task22 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement demoform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));
		demoform.sendKeys("ashima");
		WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("last_name")));
		lastname.sendKeys("asha");
		WebElement countrydropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("country_id")));
		countrydropdown.click();
		Select country = new Select(countrydropdown);
		country.selectByVisibleText("India +91");
		WebElement whatsappNumber= driver.findElement(By.name("whatsapp"));
		whatsappNumber.sendKeys("9090909902");
		// Thread.sleep(3000);
		WebElement businessname = driver.findElement(By.xpath("//input[@name='business_name']"));

		businessname.sendKeys("asha");

		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='email form-control']")));
		email.sendKeys("mouricesera1@gmail.com");

		// number 1
		WebElement number1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='numb1']")));
		String num1 = number1.getText();

		int n1 = Integer.parseInt(num1);

		// number2
		WebElement number2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='numb2']")));
		String num2 = number2.getText();
		int n2 = Integer.parseInt(num2);

		// calculate sum of two numbers
		int sum = n1 + n2;

		String sum1 = Integer.toString(sum);

		WebElement captchabox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
		captchabox.sendKeys(sum1);
		WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='demo']")));
		submitButton.click();
		

		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Thank you!')]")));

		if (successMessage.isDisplayed()) {
			System.out.println("Form submitted successfully.");
		} else {
			System.out.println("Form submission failed.");
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\screenshots\\ThankYouPage.png");
		FileUtils.copyFile(src, tgt);

		driver.close();
	}

}
