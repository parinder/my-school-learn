package com.myschool.learn.gms.tests.smoke;

import com.myschool.learn.gms.pages.profiles.ProfilesPage;
import com.myschool.learn.gms.pages.profiles.profile.OverviewTabPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;
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
