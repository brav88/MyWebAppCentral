/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth.pck.myapp;

import database.pck.myapp.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.pck.myapp.User;

/**
 *
 * @author Personal
 */
public class UsersDAO {

    public User getAuthLogin(String email, String password) {
        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat
                    = conn.prepareStatement("SELECT * FROM Users WHERE email = ? AND password = ?;");

            pstat.setString(1, email);
            pstat.setString(2, password);

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));               
                user.setType(rs.getString("type"));               
                return user;
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
