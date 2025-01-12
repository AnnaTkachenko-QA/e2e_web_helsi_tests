package me.helsi.e2e_web_tests;

import me.helsi.e2e_tests.web.pages.AuthModal;
import me.helsi.e2e_tests.web.pages.DoctorSearchResultsPage;
import me.helsi.e2e_tests.web.pages.MainPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPageTests extends BaseWithCustomWebDriverTest {

    private final MainPage mainPage = new MainPage();
    private final AuthModal authModal = new AuthModal();
    private final DoctorSearchResultsPage doctorSearchResultsPage = new DoctorSearchResultsPage();
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
    @Order(1)
    public void searchDoctorBySpecialityTest() {

        mainPage.closeBanner();
        mainPage.searchDoctorBySpeciality(targetDoctorSpeciality);

        //check search results
        doctorSearchResultsPage.isLoaded();
        doctorSearchResultsPage.checkSearchQueryAtSearchField(targetDoctorSpeciality);
        doctorSearchResultsPage.checkSpecialityForAllSearchResults(targetDoctorSpeciality, 10);
    }

    @Test
    @Order(2)
    public void searchDoctorBySurnameTest() {

        mainPage.searchDoctorBySurname(targetDoctorSurname);

        //check search results
        doctorSearchResultsPage.isLoaded();
        doctorSearchResultsPage.checkSearchQueryAtSearchField(targetDoctorSurname);
        doctorSearchResultsPage.checkSearchQueryInPageTitle(targetDoctorSurname);
        doctorSearchResultsPage.checkSurnameForAllSearchResults(targetDoctorSurname, 1);
    }

    @Test
    @Order(3)
    public void loginUser() {
        mainPage.openAuthModal();
        authModal.isLoaded();
        authModal.loginUser(userPhonenumber, password);
        $("[class*='CabinetHeader_container']").shouldBe(visible); //todo
    }
}
