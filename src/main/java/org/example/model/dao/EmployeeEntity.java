package org.example.model.dao;


public class EmployeeEntity {
    private Integer id;
    private String title;

    public EmployeeEntity() {

    }

    public EmployeeEntity(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
            return id;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "\n" + "id= " + id +
                " -- title= '" + title + "'"  + "\t";
    }
}
