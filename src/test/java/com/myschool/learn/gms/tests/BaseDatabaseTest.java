package com.myschool.learn.gms.tests;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.*;

public class BaseDatabaseTest extends BaseTest {
    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    protected Session session;
    protected String datbaseUsername = "psingh_pre";
    protected String databasePassword = "Rf2WPd2h";
    protected String sshUsername = "psingh";
    protected String sshPassword = "P@rinder18021991";
    protected int assignedPort;
    protected int requestPort = 3306;
    protected int localhostPort = 3306;
    protected String localhostUrl = "127.0.0.1";

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        try {
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            java.util.Properties configuration = new java.util.Properties();
            configuration.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(sshUsername, config.getProperty("ssh.tunnel.host"), 22);
            session.setPassword(sshPassword);
            session.setConfig(configuration);
            session.connect();
            System.out.println("Connected");
            assignedPort = session.setPortForwardingL(localhostPort, localhostUrl, requestPort);
            System.out.println("localhost:" + assignedPort + " -> " + localhostPort + ":" + requestPort);
            System.out.println("Port Forwarded");

            //mysql database connectivity
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(config.getProperty("database.host.url"), datbaseUsername, databasePassword);
            System.out.println("Database connection established");
            System.out.println("DONE");
            connection.setAutoCommit(false);

            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException | JSchException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void enterSqlQuery(String sqlStatement) throws SQLException {
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStatement);
    }

    public void queryExecution(String ColumnDetails) throws SQLException {
        while (resultSet.next()) {
            String surveyId = resultSet.getString("job_tasks");
            System.out.println(surveyId);

        }
    }

}
