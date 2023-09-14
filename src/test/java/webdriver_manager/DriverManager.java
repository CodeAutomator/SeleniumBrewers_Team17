package webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	// Browser driver setup automatically.
	public static void launchBrowser() {
		try {

			switch (Constants.BROWSER) {
			case "chrome":
				// System.setProperty("webdriver.chrome.driver", null);
				System.out.println("before chrome launch");
				//WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
				LOGGER.info("Launched " + Constants.BROWSER);
				System.out.println("after chrome launch");
				break;
			case "edge":
				// System.setProperty("webdriver.chrome.driver", null);
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launched " + Constants.BROWSER);
				driver = new EdgeDriver();
				break;
			default:
				// System.setProperty("webdriver.chrome.driver", null);
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launched " + Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
