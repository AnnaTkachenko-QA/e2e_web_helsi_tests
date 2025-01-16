package me.helsi.e2e_web_tests.common;

import me.helsi.e2e_tests.web.pages.AuthModal;
import me.helsi.e2e_tests.web.pages.DoctorSearchResultsPage;
import me.helsi.e2e_tests.web.pages.EventsPage;
import me.helsi.e2e_tests.web.pages.MainPage;

public class Application {
    public final MainPage mainPage = new MainPage();
    public final AuthModal authModal = new AuthModal();
    public final DoctorSearchResultsPage doctorSearchResultsPage = new DoctorSearchResultsPage();
    public final EventsPage eventsPage = new EventsPage();
}
