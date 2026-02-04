/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck.myapp;
import database.pck.myapp.Database;

/**
 *
 * @author Personal
 */
public class Cars {

    private String Brand;
    private String Model;
    private int Type;
    private int FuelType;
    private int Transmission;
    private String CubicCapacity;

    public Cars(String _brand, String _model, int _type, int _fuelType, int _transmission, String _cubicCapacity) {
        this.Brand = _brand;
        this.Model = _model;
        this.Type = _type;
        this.FuelType = _fuelType;
        this.Transmission = _transmission;
        this.CubicCapacity = _cubicCapacity;        
    }       
}
