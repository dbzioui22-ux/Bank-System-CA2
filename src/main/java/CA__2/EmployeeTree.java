/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

import java.util.LinkedList;

/**
 *
 * @author driss
 */
public class EmployeeTree {
    Node root;
    int count;

    public EmployeeTree() {
        root = null;
        count = 0;
    }

    // adds employee to tree level by level (left first then right)
    public void add(Employee emp) {
        Node n = new Node(emp);
        count++;

        if (root == null) {
            root = n;
            return;
        }

        // use a queue to find next empty spot
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            Node current = queue.removeFirst();

            if (current.left == null) {
                current.left = n;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = n;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // prints tree level by level
    public void printTree() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int lvl = 0;

        while (queue.size() > 0) {
            int levelSize = queue.size();
            System.out.println("Level " + lvl + ":");

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.removeFirst();
                System.out.println("  " + curr.data);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            lvl++;
        }
    }

    // gets height
    public int height() {
        return getH(root);
    }

    int getH(Node n) {
        if (n == null) return 0;
        int leftH = getH(n.left);
        int rightH = getH(n.right);
        if (leftH > rightH) {
            return leftH + 1;
        } else {
            return rightH + 1;
        }
    }

    public int size() { return count; }
}
