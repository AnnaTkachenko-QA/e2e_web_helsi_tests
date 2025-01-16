package me.helsi.e2e_tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static me.helsi.e2e_tests.utils.LogsHandler.getCodeForLoginFromConsoleLogs;

public class AuthModal {
    private final SelenideElement submitBtn = $("button[type='submit']");

    public AuthModal isLoaded() {
        $("[class*='Auth_Title']").shouldBe(visible);
        return this;
    }

    public AuthModal loginUser(String phoneNumber, String password) {
        $("#phone").setValue(phoneNumber);
        submitBtn.click();
        $("#password").shouldBe(visible).setValue(password);
        submitBtn.click();
        $("#code").shouldBe(visible).setValue(getCodeForLoginFromConsoleLogs());
        submitBtn.click();
        return this;
    }
}
