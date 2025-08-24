package org.example;

/*Метод для ArrayList, который не понадобился
так как перешел на HashMap.
 */

public class Employee{
    final private Integer id;
    final private Double value;

    public Employee(Integer id, String value) {
        this.id = id;
        this.value = Double.parseDouble(value);
    }

    public  Employee(Integer id, Double value) {
        this.id = id;
        this.value = value;
    }


}
