

package miniProject.miniProject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
	
	public static WebDriver driver;

	public void driverSetup(int choice)
	{
		switch(choice) {
		case 1:
			driver= new ChromeDriver();
			break;
		case 2:
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("program closed");
			System.exit(0);
			break;
		default:
			System.out.println("Correct option not selected....!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void closeBrowser()
	{
		driver.quit();
	}
}
