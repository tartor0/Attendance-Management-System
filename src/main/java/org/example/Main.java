package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class AttendanceSystem {
    private ArrayList<String> students;
    private HashMap<String, ArrayList<String>> attendance;
    private Scanner scanner;

    public AttendanceSystem() {
        students = new ArrayList<>();
        attendance = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (!name.isEmpty() && !students.contains(name)) {
            students.add(name);
            attendance.put(name, new ArrayList<>());
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student already exists or invalid name.");
        }
    }

    public void markAttendance() {
        if (students.isEmpty()) {
            System.out.println("No students found. Add students first.");
            return;
        }

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        for (String student : students) {
            System.out.print("Is " + student + " present? (y/n): ");
            String response = scanner.nextLine();

            if (response.equals("y")) {
                attendance.get(student).add(date);
            }
        }
        System.out.println("Attendance marked for " + date);
    }

    public void viewAttendance() {
        if (students.isEmpty()) {
            System.out.println(" No students found.");
            return;
        }

        System.out.println("\n Attendance Records:");
        for (String student : students) {
            System.out.println(student + " → " + attendance.get(student));
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Attendance Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    markAttendance();
                    break;
                case "3":
                    viewAttendance();
                    break;
                case "4":
                    System.out.println(" Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AttendanceSystem system = new AttendanceSystem();
        system.menu();
    }
}
