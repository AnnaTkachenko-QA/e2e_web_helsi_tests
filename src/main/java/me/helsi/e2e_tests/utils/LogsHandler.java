package me.helsi.e2e_tests.utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.atomic.AtomicReference;

public class LogsHandler {

    public static String getCodeForLoginFromConsoleLogs() {
        AtomicReference<String> code = new AtomicReference<>("");
        Selenide.getWebDriverLogs(LogType.BROWSER).forEach(item -> {
            if (item.contains("CODE")) {
                code.set(item);
            }
        });
        return code.get().replaceAll(".*\"(\\d{4})\".*", "$1");
    }
}
