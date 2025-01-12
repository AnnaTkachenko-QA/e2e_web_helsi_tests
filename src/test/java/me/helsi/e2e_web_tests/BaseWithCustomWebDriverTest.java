package me.helsi.e2e_web_tests;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import me.helsi.e2e_tests.utils.CustomWebDriverProvider;

public class BaseWithCustomWebDriverTest {
    public static Dotenv env = Dotenv.load();

    static {
        Configuration.browser = CustomWebDriverProvider.class.getName();
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
