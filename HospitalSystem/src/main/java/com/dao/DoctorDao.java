package com.dao;

import com.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorDao {
    private Connection conn;

    public DoctorDao(Connection conn) {
        this.conn = conn;
    }

    public boolean registerDoctor(Doctor doctor) {
        boolean flag = false;

        try {
            String sql = "INSERT INTO doctor(full_name, dob, qualification, specialist, email, mobno, password) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getDob());
            ps.setString(3, doctor.getQualification());
            ps.setString(4, doctor.getSpecialist());
            ps.setString(5, doctor.getEmail());
            ps.setString(6, doctor.getMobNo());
            ps.setString(7, doctor.getPassword());

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
