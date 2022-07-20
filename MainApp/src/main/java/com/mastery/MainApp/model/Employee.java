package com.mastery.MainApp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private String jobTitle;
//    private Gender gender;
    private String gender;
    private LocalDate dateOfBirth;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(),
                employee.getEmployeeId()) && Objects.equals(getFirstName(),
                employee.getFirstName()) && Objects.equals(getLastName(),
                employee.getLastName()) && Objects.equals(getDepartmentId(),
                employee.getDepartmentId()) && Objects.equals(getJobTitle(),
                employee.getJobTitle()) && Objects.equals(getGender(), employee.getGender()) && Objects.equals(getDateOfBirth(),
                employee.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFirstName(), getLastName(),
                getDepartmentId(), getJobTitle(), getGender(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", jobTitle='" + jobTitle + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

}
