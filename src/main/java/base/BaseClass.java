package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.dockerjava.api.model.Driver;

import common.CommonActs;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.LandingPage;

public class BaseClass {
	public WebDriver driver;
	public LandingPage landingPage;
	
	
	@BeforeMethod
public void setUp() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.expedia.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	initClasses();
}
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
	private void initClasses() {
		CommonActs commonActs=new CommonActs();
		LandingPage landningPage = new LandingPage(driver);
	}
	
}
