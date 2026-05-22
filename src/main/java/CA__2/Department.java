/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

import java.util.ArrayList;

/**
 *
 * @author driss
 */
public class Department {
    String deptName;
    ArrayList<Employee> people;

    public Department(String name) {
        this.deptName = name;
        people = new ArrayList<>();
    }

    public void addPerson(Employee e) { people.add(e); }
    public String getDeptName() { return deptName; }
    public int count() { return people.size(); }

    public String toString() {
        return deptName + " - " + people.size() + " people";
    }
}
