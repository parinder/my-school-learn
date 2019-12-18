package com.myschool.learn.gms.tests.database.formcenter;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.*;

public class SubmitSurveyDatabaseTest {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/zdirect?useUnicode=true&characterEncoding=UTF-8";
        int lport = 3306;
        String rhost = "127.0.0.1";
        int rport = 3306;
        String userDB = "psingh_pre";
        String passwordDB = "Rf2WPd2h";
        String sshHost = "10.80.82.29";
        String sshUsername = "psingh";
        String sshPassword = "P@rinder18021991";
        Session session = null;

        try {
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(sshUsername, sshHost, 22);
            session.setPassword(sshPassword);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            System.out.println("Port Forwarded");

            //mysql database connectivity
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, userDB, passwordDB);
            System.out.println("Database connection established");
            System.out.println("DONE");
            connection.setAutoCommit(false);

            String query = "select * from job_monitor where job_monitor.scheduled_job_id=4 limit 10;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int surveyId = resultSet.getInt("job_tasks");
                System.out.println(surveyId);
            }

            if (connection != null) {
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException | JSchException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
