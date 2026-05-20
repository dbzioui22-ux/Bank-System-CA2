/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author horatio
 */
public enum ManagerType {
    SENIOR(1, "Senior Manager"),
    MANAGER(2, "Manager"),
    ASSISTANT(3, "Assistant Manager"),
    TEAM_LEAD(4, "Team Lead"),
    HEAD(5, "Head Manager");

    int num;
    String label;

    ManagerType(int num, String label) {
        this.num = num;
        this.label = label;
    }

    public int getNum() { return num; }
    public String getLabel() { return label; }

    public static ManagerType fromValue(int n) {
        for (ManagerType m : values()) {
            if (m.num == n) return m;
        }
        return null;
    }
}
