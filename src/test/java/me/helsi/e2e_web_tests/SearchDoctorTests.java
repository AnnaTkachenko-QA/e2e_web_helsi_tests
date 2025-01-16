package me.helsi.e2e_web_tests;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchDoctorTests extends BaseTest {

    String targetSearchMode= "Записатися до лікаря";
    String targetDoctorSpeciality = "Сімейний лікар";
    String targetDoctorSurname = "Ткаченко";

    @BeforeEach
    void openMainPage() {
        app.mainPage.open()
                .closeCityPicker();
    }

    @ExtendWith(TextReportExtension.class)
    @Test
    @Order(1)
    public void searchDoctorBySpecialityTest() {

        app.mainPage.closeBanner()
                .selectSearchMode(targetSearchMode)
                .setValueAtSearchField(targetDoctorSpeciality)
                .selectDoctorSpecialityFromAutocomplite(targetDoctorSpeciality);

        //check search results
        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField(targetDoctorSpeciality)
                .checkSpecialityForAllSearchResults(targetDoctorSpeciality, 10);
    }

    @ExtendWith(TextReportExtension.class)
    @Test
    @Order(2)
    public void searchDoctorBySurnameTest() {

        app.mainPage.selectSearchMode(targetSearchMode)
                .setValueAtSearchField(targetDoctorSurname)
                .clickSearchBtn();

        //check search results
        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField(targetDoctorSurname)
                .checkSearchQueryInPageTitle(targetDoctorSurname)
                .checkSurnameForAllSearchResults(targetDoctorSurname, 1);
    }

    @Test
    @Order(3)
    public void filterDoctorSearchResultsByOrganisationTypeTest() {
        app.mainPage.selectSearchMode(targetSearchMode)
                .clickSearchBtn();

        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField("")
                .selectLabelAtFilter("Приватні")
                .checkFiltrationChip("Приватні")
                .checkOrganisationTypeLabelOnDoctorCards("Приватна клініка", 10)
                .removeFilterChip()
                .selectLabelAtFilter("Державні")
                .checkFiltrationChip("Державні")
                .checkOrganisationTypeLabelOnDoctorCards("Державна клініка", 10);
    }
}
