package com.myschool.learn.gms.tests.database.formcenter;

import com.myschool.learn.gms.tests.BaseDatabaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SubmitSurveyDatabaseTest extends BaseDatabaseTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void testSurveyEntryId() throws SQLException {

        this.enterSqlQuery("select * from job_monitor where job_monitor.scheduled_job_id=4 limit 10;");
        this.queryExecution("job_tasks");


    }
}