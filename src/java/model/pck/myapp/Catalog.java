/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck.myapp;

/**
 *
 * @author Personal
 */
public class Catalog {

    private int Id;
    private String Description;
   
    public Catalog() {

    }

    public Catalog(int _id, String _description) {
        this.Id = _id;
        this.Description = _description;       
    }

    public int getId() {
        return Id;
    }
    
     public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setDescription(String description) {
        this.Description = description;
    }    
}
