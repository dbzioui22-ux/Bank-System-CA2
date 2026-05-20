/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author horatio
 */
public enum MenuOption {
    SORT(1, "Sort Applicants List"),
    SEARCH(2, "Search for a Person"),
    ADD_RECORD(3, "Add New Employee Record"),
    BINARY_TREE(4, "Create Employee Hierarchy (Binary Tree)"),
    EXIT(5, "Exit");

    private int num;
    private String text;

    MenuOption(int num, String text) {
        this.num = num;
        this.text = text;
    }

    public int getNum() { return num; }
    public String getText() { return text; }

    public static MenuOption fromValue(int n) {
        for (MenuOption m : values()) {
            if (m.num == n) return m;
        }
        return null;
    }
}
