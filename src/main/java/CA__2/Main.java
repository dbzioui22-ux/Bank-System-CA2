/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA__2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author driss
 */
public class Main {

    // storing all the names and employees
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Employee> added = new ArrayList<>(); // ones user added
    static Scanner input = new Scanner(System.in);
    static boolean sorted = false;

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("  BANK ORGANISATION SYSTEM");
        System.out.println("================================");
        System.out.println();

        // ask for file
        System.out.print("Please enter the filename to read: ");
        String fileName = input.nextLine();
        loadFile(fileName);

        // keep showing menu until exit
        boolean go = true;
        while (go) {
            printMenu();
            int pick = readNumber(1, 5);
            MenuOption option = MenuOption.fromValue(pick);

            if (option == null) {
                System.out.println("try again");
                continue;
            }

            if (option == MenuOption.SORT) {
                sortList();
            } else if (option == MenuOption.SEARCH) {
                searchList();
            } else if (option == MenuOption.ADD_RECORD) {
                addEmployee();
            } else if (option == MenuOption.BINARY_TREE) {
                makeTree();
            } else if (option == MenuOption.EXIT) {
                go = false;
                System.out.println("bye");
            }
        }
    }

    // loads the csv file
    static void loadFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                if (line.trim().equals("")) continue;
                String[] bits = line.split(",");
                if (bits.length >= 8) {
                    String fn = bits[0].trim();
                    String ln = bits[1].trim();
                    String dep = bits[5].trim();
                    String title = bits[7].trim();
                    String comp = "";
                    if (bits.length > 8) comp = bits[8].trim();

                    // make the right type
                    Employee emp;
                    if (title.equals("Senior Manager") || title.equals("Head Manager")) {
                        emp = new SeniorManager(fn, ln, dep, title, comp);
                    } else if (title.equals("Assistant Manager")) {
                        emp = new AssistantManager(fn, ln, dep, title, comp);
                    } else if (title.equals("Team Lead")) {
                        emp = new TeamLead(fn, ln, dep, title, comp);
                    } else if (title.equals("Manager")) {
                        emp = new Manager(fn, ln, dep, title, comp);
                    } else {
                        emp = new Employee(fn, ln, dep, title, comp);
                    }
                    employees.add(emp);
                    names.add(fn + " " + ln);
                }
            }
            br.close();
            System.out.println("File read successfully! (" + names.size() + " records loaded)");
            System.out.println();
        } catch (IOException ex) {
            System.out.println("Cant find file: " + ex.getMessage());
            System.out.println("Put it in the project folder");
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("================================");
        System.out.println("Do You wish to SORT or SEARCH:");
        System.out.println("================================");
        for (MenuOption m : MenuOption.values()) {
            System.out.println(" " + m.getNum() + ". " + m.getText());
        }
        System.out.print("Enter choice: ");
    }

    // option 1 - sort
    static void sortList() {
        System.out.println();
        System.out.println("SORT selected");
        System.out.println();
        if (names.size() == 0) {
            System.out.println("nothing to sort!");
            return;
        }

        names = MergeSort.sort(names);
        sorted = true;

        // show first 20
        System.out.println("First 20 names sorted:");
        int count = 20;
        if (names.size() < 20) count = names.size();
        for (int i = 0; i < count; i++) {
            System.out.println(" " + (i + 1) + ") " + names.get(i));
        }
        System.out.println();
        System.out.println("total names: " + names.size());
    }

    // option 2 - search
    static void searchList() {
        System.out.println();
        System.out.println("SEARCH selected");
        System.out.println();
        if (names.size() == 0) {
            System.out.println("no data!");
            return;
        }

        // gotta sort first for binary search
        if (sorted == false) {
            System.out.println("sorting first...");
            names = MergeSort.sort(names);
            sorted = true;
        }

        System.out.print("Enter name to search: ");
        String target = input.nextLine();
        if (target.equals("")) {
            System.out.println("cant be empty");
            return;
        }

        int pos = BinarySearch.search(names, target);
        if (pos >= 0) {
            System.out.println("Found! position " + (pos + 1));
            // show details
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getFullName().equalsIgnoreCase(target)) {
                    System.out.println("  Manager Type: " + employees.get(i).getTitle());
                    System.out.println("  Department: " + employees.get(i).getDept());
                    break;
                }
            }
        } else {
            System.out.println("\"" + target + "\" not found");
        }
    }

    // option 3 - add new person
    static void addEmployee() {
        System.out.println();
        System.out.println("-- ADD RECORD --");
        System.out.println();

        System.out.print("Enter employee name: ");
        String n = input.nextLine();
        if (n.equals("")) {
            System.out.println("name cant be empty!");
            return;
        }
        String[] np = n.split(" ");
        String first = np[0];
        String last = "";
        if (np.length > 1) last = np[np.length - 1];

        // manager choice
        System.out.println();
        System.out.println("Select Management type:");
        for (ManagerType mt : ManagerType.values()) {
            System.out.println(" " + mt.getNum() + ". " + mt.getLabel());
        }
        System.out.print("choice: ");
        int mc = readNumber(1, 5);
        ManagerType mgrPick = ManagerType.fromValue(mc);

        // department choice
        System.out.println();
        System.out.println("Select Department:");
        for (DeptType dt : DeptType.values()) {
            System.out.println(" " + dt.getNum() + ". " + dt.getLabel());
        }
        System.out.print("choice: ");
        int dc = readNumber(1, 9);
        DeptType deptPick = DeptType.fromValue(dc);

        // make the right type based on what they picked
        Employee newGuy;
        if (mc == 1 || mc == 5) {
            newGuy = new SeniorManager(first, last, deptPick.getLabel(), mgrPick.getLabel(), "");
        } else if (mc == 2) {
            newGuy = new Manager(first, last, deptPick.getLabel(), mgrPick.getLabel(), "");
        } else if (mc == 3) {
            newGuy = new AssistantManager(first, last, deptPick.getLabel(), mgrPick.getLabel(), "");
        } else {
            newGuy = new TeamLead(first, last, deptPick.getLabel(), mgrPick.getLabel(), "");
        }
        employees.add(newGuy);
        added.add(newGuy);
        names.add(first + " " + last);
        sorted = false;

        System.out.println();
        System.out.println("\"" + first + " " + last + "\" added as " + mgrPick.getLabel() + " to " + deptPick.getLabel());

        System.out.println();
        System.out.println("Records added this session:");
        for (int i = 0; i < added.size(); i++) {
            System.out.println(" " + (i + 1) + ") " + added.get(i));
        }
    }

    // option 4 - binary tree
    static void makeTree() {
        System.out.println();
        System.out.println("-- BINARY TREE --");
        System.out.println();
        if (employees.size() == 0) {
            System.out.println("no data!");
            return;
        }

        // put employees into their departments
        HRDepartment hr = new HRDepartment();
        ITDepartment it = new ITDepartment();
        SalesDepartment sales = new SalesDepartment();

        for (int i = 0; i < employees.size(); i++) {
            String d = employees.get(i).getDept();
            if (d.equals("HR")) {
                hr.addPerson(employees.get(i));
            } else if (d.equals("IT Development")) {
                it.addPerson(employees.get(i));
            } else if (d.equals("Sales")) {
                sales.addPerson(employees.get(i));
            }
        }
        System.out.println("Departments: " + hr + ", " + it + ", " + sales);
        System.out.println();

        EmployeeTree tree = new EmployeeTree();
        for (int i = 0; i < employees.size(); i++) {
            tree.add(employees.get(i));
        }

        System.out.println("Inserted " + employees.size() + " employees");
        System.out.println();
        tree.printTree();
        System.out.println();
        System.out.println("Height: " + tree.height());
        System.out.println("Nodes: " + tree.size());
    }

    // reads a number and checks its valid
    static int readNumber(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(input.nextLine().trim());
                if (n >= min && n <= max) return n;
                System.out.print("must be " + min + "-" + max + ": ");
            } catch (Exception ex) {
                System.out.print("invalid, try again: ");
            }
        }
    }
}
