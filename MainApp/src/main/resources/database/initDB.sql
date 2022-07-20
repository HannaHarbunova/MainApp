DROP TABLE EMPLOYEES;

CREATE TABLE EMPLOYEES
(
    EMPLOYEE_ID  SERIAL PRIMARY KEY,
    FIRST_NAME  VARCHAR(200) ,
    LAST_NAME VARCHAR(254) ,
    DEPARTMENT_ID INTEGER  ,
    JOB_TITLE VARCHAR(200) ,
    GENDER VARCHAR(10)  ,
    DATE_OF_BIRTH DATE
);
