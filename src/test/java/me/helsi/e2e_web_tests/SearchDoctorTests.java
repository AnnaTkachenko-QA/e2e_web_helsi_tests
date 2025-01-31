package me.helsi.e2e_web_tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchDoctorTests extends BaseTest {

    String targetSearchMode = "Записатися до лікаря";
    String targetDoctorSpeciality = "Сімейний лікар";
    String targetDoctorSurname = "Ткаченко";

    @BeforeEach
    void openMainPage() {
        app.mainPage.open()
                .closeCityPicker();
    }

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

    @Test
    @Order(4)
    public void filterDoctorSearchResultsByAcceptDeclarationParameterTest() {
        app.mainPage.selectSearchMode(targetSearchMode)
                .clickSearchBtn();

        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField("")
                .selectLabelAtFilter("Лікар приймає декларації")
                .checkFiltrationChip("Лікар приймає декларації")
                .scrollPageToFooter()
                .checkAcceptDeclarationLabelOnDoctorCards("Приймає декларації",10);
    }

    @Test
    @Order(5)
    public void filterDoctorSearchResultsByWorkWithESOZParameterTest() {
        app.mainPage.selectSearchMode(targetSearchMode)
                .clickSearchBtn();

        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField("")
                .selectLabelWithPopoverAtFilter("Лікар працює з eHealth (ЕСОЗ)")
                .checkFiltrationChip("Лікар працює з eHealth (ЕСОЗ)")
                .scrollPageToFooter()
                .checkWorkWithESOZLabelOnDoctorCards(10);
    }

    @Test
    @Order(6)
    public void filterDoctorSearchResultsByOnlineConsultationParameterTest() {
        app.mainPage.selectSearchMode(targetSearchMode)
                .clickSearchBtn();

        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField("")
                .selectLabelWithPopoverAtFilter("Онлайн консультація")
                .checkFiltrationChip("Онлайн консультація")
                .scrollPageToFooter()
                .checkOnlineConsultationLabelOnDoctorCards(10);
    }

    @Test
    @Order(7)
    public void filterDoctorSearchResultsByFreeAppointmentWithDeclarationTest(){
        app.mainPage.selectSearchMode(targetSearchMode)
                .clickSearchBtn();

        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField("")
                .selectLabelAtFilter("При заключеній декларації")
                .checkFiltrationChip("При заключеній декларації")
                .scrollPageToFooter()
                .checkFreeWithDeclarationLabelOnDoctorCards(10);
    }
}
