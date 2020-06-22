package ru.gb.chat.server.core;

import java.sql.*;
import java.util.ArrayList;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat-db.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
    }

    synchronized static int getSize() {
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                count++;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return count;
    }

    synchronized static String getNickname(String login, String password) {
        try {
            ResultSet rs = statement.executeQuery(
                    String.format("select nickname from users where login = '%s' and password = '%s'",
                            login, password));
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
        return null;
    }

    synchronized static ArrayList<String> getNicknames() {
        ArrayList<String> nicknames = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT nickname FROM users"));
            while (rs.next()) {
                nicknames.add(rs.getString("nickname"));
            }
            return nicknames;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static ArrayList<String> getLogins() {
        ArrayList<String> logins = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT login FROM users"));
            while (rs.next()) {
                logins.add(rs.getString("login"));
            }
            return logins;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static void addUser(String login, String password, String nickname) {
        try {
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO users " +
                    "(login, password, nickname) VALUES (?, ?, ?)");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.executeUpdate();
            ps.clearBatch();

            connection.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
