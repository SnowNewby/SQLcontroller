package org.example.model.dao;

import java.math.BigDecimal;


public class SalariesEntity {
    private Integer id;
    private BigDecimal value;

    public SalariesEntity() {
    }

    public SalariesEntity(Integer id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
            this.value = value;

    }


    @Override
    public String toString() {
        return "\n" + "id= " + id +
                " -- value= " + value + "\t";
    }

}
