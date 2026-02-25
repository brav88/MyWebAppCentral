/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars.pck.myapp;

import database.pck.myapp.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.pck.myapp.Catalog;

/**
 *
 * @author Personal
 */
public class CatalogDAO {

    public List<Catalog> getCatalog(String catalog) {
        try {
            List<Catalog> list = new ArrayList<>();
            Database db = new Database();
            Connection conn = db.getConnection();
            
            PreparedStatement pstat
                    = conn.prepareStatement("SELECT * FROM " + catalog);

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Catalog cat = new Catalog();
                cat.setId(rs.getInt("Id"));
                cat.setDescription(rs.getString("description"));
                list.add(cat);
            }

            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
