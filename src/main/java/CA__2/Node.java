/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

/**
 *
 * @author driss
 */
public class Node {
    Employee data;
    Node left;
    Node right;

    public Node(Employee e) {
        data = e;
        left = null;
        right = null;
    }
}
