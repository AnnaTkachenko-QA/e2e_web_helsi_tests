package me.helsi.e2e_tests.web.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DoctorSearchResultsPage {

    public void isLoaded() {
        $("[class*='FindPage_titleBlock']").shouldBe(visible);
    }

    public void checkSearchQueryAtSearchField(String searchQuery) {
        $("[value='" + searchQuery + "']").shouldBe(visible);
    }

    public void checkSearchQueryInPageTitle(String searchQuery) {
        $(byXpath("//span[contains(text(),'" + searchQuery + "')]")).shouldBe(visible); //what css selector can be used here?
    }

    //todo join 2 methods checkSpecialityForAllSearchResults + checkSurnameForAllSearchResults
    public void checkSpecialityForAllSearchResults(String doctorSpeciality, int expectedSearchResultsSize) {
        $$(byXpath("//a[contains(text(),'" + doctorSpeciality + "')]")).shouldHave(size(expectedSearchResultsSize));
    }

    public void checkSurnameForAllSearchResults(String targetDoctorName, int expectedSearchResultsSize) {
        $$(byXpath("//a[contains(text(),'" + targetDoctorName + "')]")).shouldHave(size(expectedSearchResultsSize));
    }
}
