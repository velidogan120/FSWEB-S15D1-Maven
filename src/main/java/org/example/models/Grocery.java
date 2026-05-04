package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Grocery Menu ---");
            System.out.println("0 - Exit");
            System.out.println("1 - Add items");
            System.out.println("2 - Remove items");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Program stopped.");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter items to add (comma separated allowed): ");
                String input = scanner.nextLine();
                addItems(input);
                printSorted();
            }

            if (choice == 2) {
                System.out.print("Enter items to remove (comma separated allowed): ");
                String input = scanner.nextLine();
                removeItems(input);
                printSorted();
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String cleanItem = item.trim();

            if (!checkItemIsInList(cleanItem)) {
                groceryList.add(cleanItem);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String cleanItem = item.trim();

            if (checkItemIsInList(cleanItem)) {
                groceryList.remove(cleanItem);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        System.out.println("\n--- Grocery List ---");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}