package com.currantes.facturasTODO.entities_model.Logeo;



public class RegistrationDto {
    private String username;

    private String lastname;

    private String dni;

    private String password;

    private String phone;

    private String address;

    public RegistrationDto(){
        super();
    }

    public RegistrationDto(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getDni() {
        return this.dni;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String toString(){
        return "Registration info: username: " + this.username + " password: " + this.password;
    }
}
