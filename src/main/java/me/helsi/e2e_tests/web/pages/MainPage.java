package me.helsi.e2e_tests.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement searchModeSelector = $(".Select-value-label-text");
    private final SelenideElement searchField = $(".search__field");

    public void open() {
        Selenide.open("/");
    }

    public void closeCityPicker() {
        $(".wrapper__select-wrapper [class*='CitySelect_closeContainer']").click();
    }

    public void closeBanner() {
        $(shadowCss("button[class='close']", "getsitecontrol-widget")).shouldBe(visible).click();
    }

    public void openAuthModal() {
        $("[aria-label='відкрити меню']").click();
        $(byText("Увійти в кабінет")).click();
    }

    public void searchDoctorBySpeciality(String doctorSpeciality) {
        searchModeSelector.shouldHave(text("Записатися до лікаря"));
        searchField.setValue(doctorSpeciality);
        $(".autocomplete__suggestion>span").shouldHave(text(doctorSpeciality)).click();
    }

    public void searchDoctorBySurname(String doctorSurname) {
        searchModeSelector.shouldHave(text("Записатися до лікаря"));
        searchField.setValue(doctorSurname);
        $("[class*=Search_search__btn]").click();
    }
}
