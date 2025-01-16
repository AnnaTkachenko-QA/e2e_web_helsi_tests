package me.helsi.e2e_tests.web.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EventsPage {
    public EventsPage isLoaded() {
        $("[class*='CabinetHeader_container']").shouldBe(visible);
        return this;
    }
}
