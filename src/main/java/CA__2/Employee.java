/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author horatio
 */
public class Employee {
    String firstName;
    String lastName;
    String dept;
    String title;
    String company;

    public Employee(String firstName, String lastName, String dept, String title, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.title = title;
        this.company = company;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDept() { return dept; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }

    public String toString() {
        return firstName + " " + lastName + " - " + title + " (" + dept + ")";
    }
}
