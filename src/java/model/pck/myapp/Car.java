package model.pck.myapp;

public class Car {

    private int id;
    private String Brand;
    private String Model;
    private int Type;
    private int FuelType;
    private int Transmission;
    private String CubicCapacity;

    public Car() {

    }

    public Car(String _brand, String _model, int _type, int _fuelType, int _transmission, String _cubicCapacity) {
        this.Brand = _brand;
        this.Model = _model;
        this.Type = _type;
        this.FuelType = _fuelType;
        this.Transmission = _transmission;
        this.CubicCapacity = _cubicCapacity;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getCC() {
        return CubicCapacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public void setCC(String cc) {
        this.CubicCapacity = cc;
    }
}
