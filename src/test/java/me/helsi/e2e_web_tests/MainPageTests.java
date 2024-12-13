package me.helsi.e2e_web_tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageTests {
    @Test
    public void searchDoctorBySpecialityTest() {
        open("https://helsi.me/");

        //close city picker
        $(".wrapper__select-wrapper>.city-select-container").shouldBe(visible).click();

        //close banner
        $(shadowCss("button[class='close']","getsitecontrol-widget")).click();

        //search
        $(".Select-value-label-text").shouldHave(text("Записатися до лікаря"));
        $(".search__field").setValue("Сімейний лікар");
        $(".autocomplete__suggestion>span").shouldHave(text("Сімейний лікар")).click();

        //check search results
        webdriver().shouldHave(url("https://helsi.me/doctors/kyiv/simeinyi-likar"));
        $("[value=\"Сімейний лікар\"]").shouldBe(visible);
        $$(byXpath("//a[contains(text(),'Сімейний лікар')]")).shouldHave(size(10));//want to check that such elements are 10 on the page (?)
    }

    @Test
    public void searchDoctorBySurnameTest() {
        open("https://helsi.me/");

        //close city picker
        $(".wrapper__select-wrapper>.city-select-container").shouldBe(visible).click();

        //close banner
        //$(shadowCss("button[class='close']","getsitecontrol-widget")).click();

        //search
        $(".Select-value-label-text").shouldHave(text("Записатися до лікаря"));
        $(".search__field").setValue("ткаченко");
        $("[class*=Search_search__btn]").click();

        //check search results
        webdriver().shouldHave(url("https://helsi.me/doctors/kyiv?search=%D1%82%D0%BA%D0%B0%D1%87%D0%B5%D0%BD%D0%BA%D0%BE"));
        $(byXpath("//span[contains(text(),'ткаченко')]")).shouldBe(visible); //what css selector can be used here?
        $$(byXpath("//a[contains(text(),'Ткаченко')]")).shouldHave(size(10));
    }
}
