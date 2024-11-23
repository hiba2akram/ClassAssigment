package com.example.demo1;

public class Candidate{
    private String name;
    private String fatherName;
    private String city;
    private String address;
    private String email;
    private String gender;

    Candidate(String name, String fathername, String city,String address,String email, String gender){
      this.name = name;
      this.fatherName = fathername;
      this.city = city;
        this.address = address;
        this.email = email;
        this.gender = gender;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"+
                " Father Name: " + fatherName + "\n"+
                " City: " + city + "\n"+
                " Address: " + address + "\n"+
                " Email: " + email + "\n" +
                " Gender: " + gender;
    }
}
