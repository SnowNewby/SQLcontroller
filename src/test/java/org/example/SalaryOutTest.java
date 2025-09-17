package org.example;

import org.junit.jupiter.api.Test;
import sandbox.SalaryOut;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalaryOutTest {

    @Test
    public void testContext() {
        HashMap<Integer, Double> salary = new HashMap<>();
        HashMap<Integer, String> employees = new HashMap<>();

        String testUpdateRequest = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";
        var salaryOut = new SalaryOut(testUpdateRequest, salary, employees);
    }
}
