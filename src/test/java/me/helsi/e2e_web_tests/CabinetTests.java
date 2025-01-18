package me.helsi.e2e_web_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabinetTests extends BaseWithCustomWebDriverTest {

    static String userPhonenumber = env.get("USER_PHONENUMBER");
    static String password = env.get("PASSWORD");

    @BeforeEach
    void openMainPage() {
        app.mainPage.open()
                .closeCityPicker();
    }

    @Test
    public void loginUser() {
        app.mainPage.closeBanner()
                .openAuthModal();
        app.authModal.isLoaded()
                .loginUser(userPhonenumber, password);
        app.eventsPage.isLoaded();
    }
}
