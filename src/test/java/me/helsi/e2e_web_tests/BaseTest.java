package me.helsi.e2e_web_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import me.helsi.e2e_web_tests.common.Application;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
public class BaseTest {
    public static Dotenv env = Dotenv.load();

    protected static Application app = new Application();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
