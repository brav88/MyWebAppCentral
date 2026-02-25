/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pck.myapp;

/**
 *
 * @author Personal
 */
public class User {

    private int id;
    private String Name;
    private String LastName;
    private int Email;
    private int Type;

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getType() {
        return Type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
