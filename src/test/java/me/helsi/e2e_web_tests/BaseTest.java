package me.helsi.e2e_web_tests;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import me.helsi.e2e_web_tests.common.Application;

public class BaseTest {
    public static Dotenv env = Dotenv.load();

    protected static Application app = new Application();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
