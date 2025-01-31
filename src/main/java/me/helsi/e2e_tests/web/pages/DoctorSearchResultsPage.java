package me.helsi.e2e_tests.web.pages;


import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

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

    public DoctorSearchResultsPage selectLabelWithPopoverAtFilter(String targetFilter) {
        $(byTagAndText("label/span/div", targetFilter)).click();
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

    public DoctorSearchResultsPage checkAcceptDeclarationLabelOnDoctorCards(String expectedAcceptDeclarationLabel, int expectedSize) {
        $$(byTagAndText("span", expectedAcceptDeclarationLabel)).shouldHave(size(expectedSize));
        return this;
    }

    public DoctorSearchResultsPage scrollPageToFooter() {
//        ElementsCollection doctorCards = $$("[class*='Card_card']").shouldHave(size(10));
//        for (SelenideElement doctorCard : doctorCards){
//            doctorCard.scrollIntoView("{block: \"center\", behavior: \"smooth\"}");
//        }

        $("footer").scrollIntoView("{block: \"center\", behavior: \"smooth\"}");
        return this;
    }

    public DoctorSearchResultsPage checkWorkWithESOZLabelOnDoctorCards(int expectedSize) {
        $$("[class*='CardLabel_card-label--eHealth']").shouldHave(size(expectedSize), Duration.ofSeconds(7));
        return this;
    }

    public DoctorSearchResultsPage checkOnlineConsultationLabelOnDoctorCards(int expectedSize) {
        $$("[class*='CardLabel_card-label--video']").shouldHave(size(expectedSize));
        return this;
    }

    public DoctorSearchResultsPage checkFreeWithDeclarationLabelOnDoctorCards(int expectedSize) {
        $$(byText("Безоплатно")).shouldHave(size(expectedSize), Duration.ofSeconds(6));
        $$(byText("При заключеній декларації з цим лікарем")).shouldHave(size(expectedSize));
        return this;
    }
}
