package miniProject.miniProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class miniProject  extends Driver{
    public static void main(String[] args) throws InterruptedException{
        // Set the path to the EdgeDriver executable
        //System.setProperty("webdriver.edge.driver", "/path/to/msedgedriver.exe");
    	Scanner sc=new Scanner(System.in);
    	System.out.println("choose a browser:\n1.Chrome browser\n2.Edge browser\n");
    	
    	int choice =sc.nextInt();
    	Thread.sleep(5000);
    	
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
    	
        // Initialize the Edge driver
    	// WebDriver driver = new EdgeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Go to Snapdeal
        driver.get("https://www.snapdeal.com/");

        // Enter "Bluetooth headphone" in search textbox
        WebElement searchBox = driver.findElement(By.name("keyword"));
        searchBox.sendKeys("Bluetooth headphone");

        // Click search button
        WebElement searchButton = driver.findElement(By.className("searchTextSpan"));
        searchButton.click();
        
        driver.findElement(By.className("sort-label")).click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//ul[@class='sort-value']//li[contains(@class,'sort-active')]")).click();
        //driver.findElement(By.linkText("Popularity")).click();
        driver.findElement(By.xpath("//ul[@class='sort-value']//li[@data-index='1']")).click();
        //driver.findElement(By.xpath("//input[@class='input-filter']")).click();
        driver.findElement(By.name("fromVal")).click();
        driver.findElement(By.name("fromVal")).clear();
        driver.findElement(By.name("fromVal")).sendKeys("700");
        Thread.sleep(3000);
        driver.findElement(By.name("toVal")).click();
        driver.findElement(By.name("toVal")).clear();
        driver.findElement(By.name("toVal")).sendKeys("1400");
        Thread.sleep(3000);
        driver.findElement(By.className("price-go-arrow")).click();
        Thread.sleep(10000);
        //driver.quit();
        
        
        // Wait for the page to load completely
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        // Select price range between 700 to 1400
       // WebElement priceRange = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '700-1400')]")));
        //priceRange.click();
        //WebElement priceRange = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='700-1400']")));
       // priceRange.click();
        
        //List<WebElement> products = driver.findElements(By.xpath("//div[@id='products']"));
		//System.out.println("No of products: "+products.size());
        

        // Get and print the first 5 Bluetooth headphones name and price
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("product-tuple-listing")));

        for (int i = 0; i < 5; i++) {
            WebElement product = products.get(i);
            String title = product.findElement(By.className("product-title")).getText();
            String price = product.findElement(By.className("lfloat")).getText();
            System.out.println(title + ": " + price);
        }

        // Close the browser
        driver.quit();
    }
}

