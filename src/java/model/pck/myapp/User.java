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
    private String Email;
    private String Type;

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getType() {
        return Type;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.Name = _name;
    }

    public void setLastName(String _lastname) {
        this.LastName = _lastname;
    }

    public void setEmail(String _email) {
        this.Email = _email;
    }
    
     public void setType(String _type) {
        this.Type = _type;
    }
}
