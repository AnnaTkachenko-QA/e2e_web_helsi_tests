package me.helsi.e2e_tests.web.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DoctorSearchResultsPage {

    public DoctorSearchResultsPage isLoaded() {
        $("[class*='FindPage_titleBlock']").shouldBe(visible);
        $("[class*='DatumBanner_container']").shouldBe(visible);
        $("[class*='Breadcrumbs_Breadcrumbs']").shouldBe(visible);
        return this;
    }

    public DoctorSearchResultsPage checkSearchQueryAtSearchField(String searchQuery) {
        $(byValue(searchQuery)).shouldBe(visible);
        return this;
    }

    public DoctorSearchResultsPage checkSearchQueryInPageTitle(String searchQuery) {
        $(withTagAndText("span", searchQuery)).shouldBe(visible);
        return this;
    }

    //todo join 2 methods checkSpecialityForAllSearchResults + checkSurnameForAllSearchResults
    public DoctorSearchResultsPage checkSpecialityForAllSearchResults(String doctorSpeciality, int expectedSearchResultsSize) {
        $$(withTagAndText("a", doctorSpeciality)).shouldHave(size(expectedSearchResultsSize));
        return this;
    }

    public DoctorSearchResultsPage checkSurnameForAllSearchResults(String targetDoctorName, int expectedSearchResultsSize) {
        $$(withTagAndText("a", targetDoctorName)).shouldHave(size(expectedSearchResultsSize));
        return this;
    }

    public DoctorSearchResultsPage selectLabelAtFilter(String targetFilter) {
        $(byTagAndText("label/span", targetFilter)).click();
        return this;
    }

    public DoctorSearchResultsPage checkFiltrationChip(String expectedFiltrationChip) {
        $("[class*='FilterChips_chip']").shouldHave(text(expectedFiltrationChip));
        return this;
    }

    public DoctorSearchResultsPage checkOrganisationTypeLabelOnDoctorCards(String expectedOrganisationTypeLabel, int expectedSize) {
        $$(byTagAndText("a", expectedOrganisationTypeLabel)).shouldHave(size(expectedSize));
        return this;
    }

    public DoctorSearchResultsPage removeFilterChip() {
        $("[class*='FilterChips_removeIcon']").click();
        return this;
    }
}
