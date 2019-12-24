package com.myschool.learn.gms.tests.database;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.myschool.learn.gms.tests.BaseFunctionalTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.*;

public class BaseDatabaseTest extends BaseFunctionalTest {
    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    protected Session session;
    protected String datbaseUsername = "psingh";
    protected String databasePassword = "CYCebN4x";
    protected String sshUsername = "psingh";
    protected String sshPassword = "P@rinder18021991";
    protected int assignedPort;
    protected int requestPort = 3306;
    protected int localhostPort = 3306;
    protected String localhostUrl = "127.0.0.1";
    protected String result;

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

    public String executeQuery(String sqlStatement, String ColumnDetails) throws SQLException {
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            return resultSet.getString(ColumnDetails);
        }
        return sqlStatement;
    }
}