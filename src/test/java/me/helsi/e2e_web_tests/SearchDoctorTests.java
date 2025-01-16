package me.helsi.e2e_web_tests;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchDoctorTests extends BaseTest {

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
                .searchDoctorBySpeciality(targetDoctorSpeciality);

        //check search results
        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField(targetDoctorSpeciality)
                .checkSpecialityForAllSearchResults(targetDoctorSpeciality, 10);
    }

    @ExtendWith(TextReportExtension.class)
    @Test
    @Order(2)
    public void searchDoctorBySurnameTest() {

        app.mainPage.searchDoctorBySurname(targetDoctorSurname);

        //check search results
        app.doctorSearchResultsPage.isLoaded()
                .checkSearchQueryAtSearchField(targetDoctorSurname)
                .checkSearchQueryInPageTitle(targetDoctorSurname)
                .checkSurnameForAllSearchResults(targetDoctorSurname, 1);
    }
}
