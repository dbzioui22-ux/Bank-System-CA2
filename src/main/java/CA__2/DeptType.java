/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author horatio
 */
public enum DeptType {
    IT(1, "IT Development"),
    SALES(2, "Sales"),
    HR(3, "HR"),
    FINANCE(4, "Finance"),
    MARKETING(5, "Marketing"),
    OPS(6, "Operations"),
    CUST_SERVICE(7, "Customer Service"),
    ACCOUNTING(8, "Accounting"),
    TECH_SUPPORT(9, "Technical Support");

    int num;
    String label;

    DeptType(int n, String l) {
        num = n;
        label = l;
    }

    public int getNum() { return num; }
    public String getLabel() { return label; }

    public static DeptType fromValue(int n) {
        for (DeptType d : values()) {
            if (d.num == n) return d;
        }
        return null;
    }
}
