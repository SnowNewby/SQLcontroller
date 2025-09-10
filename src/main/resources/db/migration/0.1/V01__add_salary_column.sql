--script for salary table creation

-- Table: public.employees_salary

-- DROP TABLE IF EXISTS public.employees_salary;

CREATE TABLE IF NOT EXISTS public.employees_salary
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

ALTER TABLE IF EXISTS public.employees_salary
    OWNER to postgres;