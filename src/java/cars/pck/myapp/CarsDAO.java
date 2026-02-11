/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cars.pck.myapp;

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
            ResultSet rs = db.ExecuteQuery("SELECT * FROM Cars;");

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

    public void insertCar(Car car) {
        Database db = new Database();
        db.ExecuteUpdate("INSERT INTO Cars (brand, model, type, fuelType, transmission, cubicCapacity, created) VALUES ('" + 
                          car.getBrand() + "', '" + car.getModel()+ "', 7, 2, 2, " + car.getCC() + ", LOCALTIME());");
    }
}
