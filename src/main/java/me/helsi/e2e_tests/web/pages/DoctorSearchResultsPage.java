package me.helsi.e2e_tests.web.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DoctorSearchResultsPage {

    public void isLoaded() {
        $("[class*='FindPage_titleBlock']").shouldBe(visible);
    }

    public void checkSearchQueryAtSearchField(String searchQuery) {
        $(byValue(searchQuery)).shouldBe(visible);
    }

    public void checkSearchQueryInPageTitle(String searchQuery) {
        $(withTagAndText("span", searchQuery)).shouldBe(visible);
    }

    //todo join 2 methods checkSpecialityForAllSearchResults + checkSurnameForAllSearchResults
    public void checkSpecialityForAllSearchResults(String doctorSpeciality, int expectedSearchResultsSize) {
        $$(withTagAndText("a", doctorSpeciality)).shouldHave(size(expectedSearchResultsSize));
    }

    public void checkSurnameForAllSearchResults(String targetDoctorName, int expectedSearchResultsSize) {
        $$(withTagAndText("a", targetDoctorName)).shouldHave(size(expectedSearchResultsSize));
    }
}
