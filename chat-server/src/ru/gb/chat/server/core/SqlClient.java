package ru.gb.chat.server.core;

import org.sqlite.SQLiteDataSource;

import java.sql.*;

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
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    synchronized static int getSize() {
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT login FROM users");
            count = rs.getFetchSize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return null;
    }

    synchronized static String getNickname(int id) {
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT nickname FROM users WHERE id = '%d", id));
            return rs.getString("nickname");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    synchronized static String getLogin(int id) {
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT login FROM users WHERE id = '%d'",
                id));
            return rs.getString("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            connection.commit();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
