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

    public MainPage selectSearchMode(String targetSearchMode){
        searchModeSelector.click();
        $(byText(targetSearchMode)).click();
        searchModeSelector.shouldHave(text(targetSearchMode));
        return this;
    }

    public MainPage selectDoctorSpecialityFromAutocomplite(String doctorSpeciality) {
        $(".autocomplete__suggestion>span").shouldHave(text(doctorSpeciality)).click();
        return this;
    }

    public MainPage setValueAtSearchField (String searchValue) {
        searchField.setValue(searchValue);
        return this;
    }

    public MainPage clickSearchBtn() {
        $("[class*=Search_search__btn]").click();
        return this;
    }
}
