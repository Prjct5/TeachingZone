package com.projecttest.projecttest;

import java.sql.*;
import java.util.Objects;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/TeachingZone";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ym";

    public static boolean validateUser(String username, String password) {
        Objects.requireNonNull(username, "Username cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");

        String sql = "SELECT password FROM users WHERE (username = ? OR email = ?) AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username.trim());
            stmt.setString(2, username.trim());
            stmt.setString(3, password.trim());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    // For production: Use password hashing (BCrypt recommended)
                    // return BCrypt.checkpw(password, storedPassword);
                    return storedPassword.equals(password.trim());
                }
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Database error during validation:");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean registerUser(String username, String email, String password) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
