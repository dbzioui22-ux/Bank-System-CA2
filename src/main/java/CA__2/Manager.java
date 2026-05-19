/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author horatio
 */
public class Manager extends Employee {
    int numReports;

    public Manager(String fn, String ln, String dept, String title, String comp) {
        super(fn, ln, dept, title, comp);
        this.numReports = 0;
    }

    public int getNumReports() { return numReports; }
    public void setNumReports(int n) { numReports = n; }
}
