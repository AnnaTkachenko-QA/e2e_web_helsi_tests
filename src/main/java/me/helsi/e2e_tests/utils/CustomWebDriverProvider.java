package me.helsi.e2e_tests.utils;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public class CustomWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(org.openqa.selenium.Capabilities capabilities) {
        // ChromeOptions для кастомізації браузера
        ChromeOptions options = new ChromeOptions();

        // Додаємо loggingPrefs для збору логів браузера
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL); // Увімкнути всі рівні логів
        options.setCapability("goog:loggingPrefs", logs);

        // Повертаємо кастомізований WebDriver
        return new ChromeDriver(options);
    }
}
