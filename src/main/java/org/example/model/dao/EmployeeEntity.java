package org.example.model.dao;



/// todo хочу реализовать как полноценную сущность через Hibernate

public class EmployeeEntity {
    private Integer id;
    private String title;
    private String last_name;
    private String first_name;
    private String title_of_courtesy;
    private String address;
    private String postal_code;
    private String country;




    // Constructor
    public EmployeeEntity() {

    }

    public EmployeeEntity(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public EmployeeEntity(Integer id, String last_name, String first_name, String title_of_courtesy) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.title_of_courtesy = title_of_courtesy;
    }


    //Setters
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_surname(String first_surname) {
        this.first_name = first_surname;
    }

    public void setTitle_of_courtesy(String title_of_courtesy) {
        this.title_of_courtesy = title_of_courtesy;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //Getters
    public String getFirst_name() {
        return first_name;
    }

    public String getTitle_of_courtesy() {
        return title_of_courtesy;
    }

    public String getLast_name() {
        return last_name;
    }

    public Integer getId() {
            return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry() {
        return country;
    }

    //toString
    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", title_of_courtesy='" + title_of_courtesy + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
