
 -////// SELECT REQUEST   ------------------

db.GET_EMPLOYEE_REQUEST  = SELECT * FROM employees;
db.GET_SALARY_REQUEST  = SELECT * FROM employees_salary;

-////// UPDATE REQUEST ----------------
db.UPDATE_SALARY_REQUEST = UPDATE employees_salary SET salary = ? WHERE employee_id = ?;


 -////// ADD REQUEST --------------------
db.ADD_NEW_TABLE_SALARY = CREATE TABLE IF NOT EXISTS public.employees_salary
                          (
                              employee_id smallint NOT NULL,
                              salary numeric(10,2) DEFAULT 50000.00,
                              salary_date date DEFAULT '1999-02-05'::date,
                              CONSTRAINT employees_salary_pkey PRIMARY KEY (employee_id),
                              CONSTRAINT fk_salary_employee FOREIGN KEY (employee_id)
                                  REFERENCES public.employees (employee_id) MATCH SIMPLE
                                  ON UPDATE NO ACTION
                                  ON DELETE NO ACTION
                          )

                          TABLESPACE pg_default;