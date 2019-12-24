package com.myschool.learn.gms.tests.database.formcenter;

import com.myschool.learn.gms.tests.database.BaseDatabaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Sample extends BaseDatabaseTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void testSurveyUrl() throws SQLException {
        this.executeQuery("Select * from survey_entry where material_id=56181 order by survey_entry.survey_entry_id desc limit 1;", "origin_site");
    }
}