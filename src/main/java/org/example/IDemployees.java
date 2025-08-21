package org.example;

public class IDemployees {
    final private Integer ID;
    final private Float Salary;

    public IDemployees(int ID, float Salary) {
        this.ID = ID;
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "ID:" + ID + "-"
                + "Salary:" + Salary + "\n";
    }
}
