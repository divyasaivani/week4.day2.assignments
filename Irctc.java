package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //1. Navigate to https://www.irctc.co.in/
		driver.get("https://www.irctc.co.in/");
        //2. Click Ok in the alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		//3. Click on FLIGHTS link
	    driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		//4. Switch to the Flights window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String newWindow = listHandles.get(1);
		driver.switchTo().window(listHandles.get(1));
		//5. Print the Title of the Flights window
		System.out.println(driver.getTitle());
		//6. Close the Flights window alone
		driver.close();
		//7. Print the Train search window title (First window)
		driver.switchTo().window(listHandles.get(0));
		System.out.println(driver.getTitle());

			}

	

	}

	    