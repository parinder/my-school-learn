package com.gms.smoke;

import com.gms.pages.profiles.ProfilesPage;
import com.gms.pages.profiles.profile.OverviewTabPage;
import com.gms.tests.BaseFunctionalTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseSmokeTest extends BaseFunctionalTest{
    protected ProfilesPage profilesPage;
    protected OverviewTabPage overviewTabPage;

    @BeforeClass
    public void setup() throws IOException {
            super.setup();
            this.profilesPage = new ProfilesPage(this.driver, config);
            this.overviewTabPage = new OverviewTabPage(this.driver, config);
            this.login(this.defaultUsername, this.defaultPassword);            
    }

    public void goToProfile(String email) {
            this.profilesPage.get();
            this.profilesPage.waitForPageLoad();
            this.profilesPage.enterProfileSearchEmail(email);
            this.profilesPage.clickProfileSearchButton();
    }
}
