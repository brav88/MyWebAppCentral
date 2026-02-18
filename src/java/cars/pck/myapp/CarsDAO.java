/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars.pck.myapp;

import java.sql.*;
import database.pck.myapp.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.pck.myapp.Car;

public class CarsDAO {

    public List<Car> getAllCars() {
        try {
            List<Car> list = new ArrayList<>();
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat
                    = conn.prepareStatement("SELECT * FROM Cars;");

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("carId"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setCC(rs.getString("cubicCapacity"));
                list.add(car);
            }

            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Car getCarById(int carId) {
        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat
                    = conn.prepareStatement("SELECT * FROM Cars WHERE carId = ?;");

            pstat.setInt(1, carId);

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("carId"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setCC(rs.getString("cubicCapacity"));
                return car;
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void insertCar(Car car) {
        Database db = new Database();

        Connection conn = db.getConnection();

        try {
            PreparedStatement pstat
                    = conn.prepareStatement("INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created) VALUES (?, ?, ?, ?, ?, ?, LOCALTIME());");

            pstat.setString(1, car.getBrand());
            pstat.setString(2, car.getModel());
            pstat.setInt(3, 7);
            pstat.setInt(4, 2);
            pstat.setInt(5, 2);
            pstat.setString(6, car.getCC());

            pstat.executeUpdate();

        } catch (SQLException ex) {
            System.getLogger(database.pck.myapp.Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void updateCar(Car car) {
        Database db = new Database();
        Connection conn = db.getConnection();

        try {
            PreparedStatement pstat
            = conn.prepareStatement("UPDATE Cars SET brand = ?, model = ?, cubicCapacity = ? WHERE carId = ?;");

            pstat.setString(1, car.getBrand());
            pstat.setString(2, car.getModel());           
            pstat.setString(3, car.getCC());
            pstat.setInt(4, car.getId());

            pstat.executeUpdate();

        } catch (SQLException ex) {
            System.getLogger(database.pck.myapp.Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void deleteCar(int carId) {
        Database db = new Database();
        Connection conn = db.getConnection();

        try {
            PreparedStatement pstat
            = conn.prepareStatement("DELETE FROM Cars WHERE carId = ?;");
           
            pstat.setInt(1, carId);

            pstat.executeUpdate();

        } catch (SQLException ex) {
            System.getLogger(database.pck.myapp.Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
