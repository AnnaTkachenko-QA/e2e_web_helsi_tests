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

    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public MainPage closeCityPicker() {
        $(".wrapper__select-wrapper [class*='CitySelect_closeContainer']").click();
        return this;
    }

    public MainPage closeBanner() {
        $(shadowCss("button[class='close']", "getsitecontrol-widget")).shouldBe(visible).click();
        return this;
    }

    public MainPage openAuthModal() {
        $("[aria-label='відкрити меню']").click();
        $(byText("Увійти в кабінет")).click();
        return this;
    }

    //todo refactor search methods
    public MainPage searchDoctorBySpeciality(String doctorSpeciality) {
        searchModeSelector.shouldHave(text("Записатися до лікаря"));
        searchField.setValue(doctorSpeciality);
        $(".autocomplete__suggestion>span").shouldHave(text(doctorSpeciality)).click();
        return this;
    }

    public MainPage searchDoctorBySurname(String doctorSurname) {
        searchModeSelector.shouldHave(text("Записатися до лікаря"));
        searchField.setValue(doctorSurname);
        $("[class*=Search_search__btn]").click();
        return this;
    }
}
