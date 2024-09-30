package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public boolean register(User u) {
        boolean flag = false;

        try {
            String sql = "INSERT INTO user_dtls(full_name, email, password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public User login(String email, String password) {
        User user = null;

        try {
            String sql = "SELECT * FROM user_dtls WHERE email = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean checkOldPassword(int userId, String oldPassword) {
        boolean flag = false;

        try{
            String sql = "SELECT * FROM user_dtls WHERE id = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public boolean changePassword(int userId, String newPassword) {
        boolean flag = false;

        try {
            String sql = "UPDATE user_dtls SET password = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
