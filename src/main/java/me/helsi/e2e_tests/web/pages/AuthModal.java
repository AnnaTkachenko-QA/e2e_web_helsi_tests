package me.helsi.e2e_tests.web.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthModal {
    public void isLoaded() {
        $("[class*='Auth_Title']").shouldBe(visible);
    }

    public void loginUser(String phoneNumber, String password) {
        $("[id='phone']").setValue(phoneNumber);
        $("button[type='submit']").click();
        $("[id='password']").shouldBe(visible).setValue(password);
        $("button[type='submit']").click();
        $("[id='code']").shouldBe(visible).setValue(""); //todo copy code from logs?
        $("button[type='submit']").click();
    }
}
