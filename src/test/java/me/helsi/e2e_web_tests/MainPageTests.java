package me.helsi.e2e_web_tests;

import me.helsi.e2e_tests.web.pages.AuthModal;
import me.helsi.e2e_tests.web.pages.DoctorSearchResultsPage;
import me.helsi.e2e_tests.web.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MainPageTests extends BaseTest {

    private static final MainPage mainPage = new MainPage();
    private static final AuthModal authModal = new AuthModal();
    private static final DoctorSearchResultsPage doctorSearchResultsPage = new DoctorSearchResultsPage();
    static String userPhonenumber = env.get("USER_PHONENUMBER");
    static String password = env.get("PASSWORD");
    String targetDoctorSpeciality = "Сімейний лікар";
    String targetDoctorSurname = "Ткаченко";

    @BeforeEach
    void openMainPage() {
        mainPage.open();
        mainPage.closeCityPicker();
    }

    @Test
    public void searchDoctorBySpecialityTest() {

        mainPage.closeBanner();
        mainPage.searchDoctorBySpeciality(targetDoctorSpeciality);

        //check search results
        doctorSearchResultsPage.isLoaded();
        doctorSearchResultsPage.checkSearchQueryAtSearchField(targetDoctorSpeciality);
        doctorSearchResultsPage.checkSpecialityForAllSearchResults(targetDoctorSpeciality, 10);
    }

    @Test
    public void searchDoctorBySurnameTest() {

        mainPage.searchDoctorBySurname(targetDoctorSurname);

        //check search results
        doctorSearchResultsPage.isLoaded();
        doctorSearchResultsPage.checkSearchQueryAtSearchField(targetDoctorSurname);
        doctorSearchResultsPage.checkSearchQueryInPageTitle(targetDoctorSurname);
        doctorSearchResultsPage.checkSurnameForAllSearchResults(targetDoctorSurname, 1);
    }

    @Test
    public void loginUser() {
        mainPage.openAuthModal();
        authModal.isLoaded();
        authModal.loginUser(userPhonenumber, password);
        //todo check user is authorised
    }
}
