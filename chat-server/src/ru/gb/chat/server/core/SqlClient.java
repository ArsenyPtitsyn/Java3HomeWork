package ru.gb.chat.server.core;

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

    synchronized static String getNickname(int a) {
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM users WHERE id = '%d'", a));
            return rs.getString("nickname");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static String getLogin(int a) {
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM users WHERE id = %d",
                    a));
            return rs.getString("login");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    synchronized static void addUser(String login, String password, String nickname) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users " +
                    "(login, password, nickname) VALUES (?, ?, ?)");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
