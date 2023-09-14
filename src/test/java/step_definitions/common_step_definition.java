package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import utilities.common_utils;
import webdriver_manager.DriverManager;

public class common_step_definition {

	// launch browser

	public static WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(common_step_definition.class);

	@Before
	public void beforeScenario() {
		try {

			LOGGER.info("Instantiation the commonutils");
			common_utils objCommounUtils = new common_utils();
			objCommounUtils.loadproperties();

			LOGGER.info("Launch Browser");
			if (DriverManager.getDriver() == null) {
				DriverManager.launchBrowser();
				objCommounUtils.initWebElements();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void afterScenario() {
		 //DriverManager.getDriver().quit();
	}

}
