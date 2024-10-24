package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) {
        // Initialize variables
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();
        double totalAmount = 0.0;

        // Load inventory from CSV file
        loadInventory("products.csv", inventory);


        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Display menu and get user choice until they choose to exit
        while (choice != 3) {
            System.out.println("Welcome to the Online com.pluralsight.Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            // Call the appropriate method based on user choice
            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner, totalAmount);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    inventory.add(new Product(id, name, price));

                }
            }

        } catch (Exception e) {
            System.out.println("File Error");
            e.printStackTrace();
        }

    }


    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        // This method should display a list of products from the inventory,
        // and prompt the user to add items to their cart. The method should
        // prompt the user to enter the ID of the product they want to add to
        // their cart. The method should
        // add the selected product to the cart ArrayList.
        try {
            for (Product product : inventory) {
                System.out.println(inventory);

                System.out.println("Hi would you like to add items to your cart (y/n) ");
                String option = scanner.nextLine().trim().toUpperCase();
                if (option.equalsIgnoreCase("Y")) {
                    System.out.println("Enter product id: ");
                    String productId = scanner.nextLine().toUpperCase();
                    if (product.getID().equals(productId)) {
                        cart.add(product.getID());
                    } else {
                        System.err.println("Notice product ID is incorrect");
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        // This method should display the items in the cart ArrayList, along
        // with the total cost of all items in the cart. The method should
        // prompt the user to remove items from their cart by entering the ID
        // of the product they want to remove. The method should update the cart ArrayList and totalAmount
        // variable accordingly.
        for (Product product : cart) {
            if (cart.isEmpty()) {
                System.out.println("Notice your cart is empty!");
            }else{
                System.out.println("Continue your shopping!");
            }
            System.out.println("Here are your current items:\n ");
            System.out.println("ID: " + product.getID() + " ,Name: " + product.getName() + " , Price: $" + product.getPrice());

            System.out.println("Total cost: $" + totalAmount);
            System.out.println("==============================");
            System.out.println("Do you want to continue payment? (yes/no): ");
            String conformationAnswer = scanner.nextLine();
            if (conformationAnswer.equalsIgnoreCase("yes")) {
                System.out.println("Notice purchase has been confirmed! Your total amount due: $" + totalAmount);

                cart.clear();
            } else {
                System.err.println("Notice! cart has been cancelled Try again?... \n");
            }
        }

    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount,String userDecision) {
        // This method should calculate the total cost of all items in the cart,
        // and display a summary of the purchase to the user. The method should
        // prompt the user to confirm the purchase, and deduct the total cost
        // from their account if they confirm.

        for (Product product : cart) {
            System.out.println("Hi lets tally everything up reads items. ");
            System.out.println("ID: " + product.getID() + " ,Name: " + product.getName() + " , Price: $" + product.getPrice());
        }
        System.out.println("total cost: $" + totalAmount);

        if (userDecision.equalsIgnoreCase("yes")){
            System.out.println("Great your purchase has been confirmed!, your total amount due: $" + totalAmount);

            cart.clear();
            System.out.println("Notice Your cart is now empty! ");
        }else {
            System.out.println("Notice your purchase was nullified!");
        }
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // This method should search the inventory ArrayList for a product with
        // the specified ID, and return the corresponding com.pluralsight.Product object. If
        // no product with the specified ID is found, the method should return
        // null.
        for (Product product : inventory) {
            System.out.println("Enter the product ID: ");
            boolean productIdentity = false;
            if (product.getID().equals(inventory));
            System.out.println(product.getID());
            productIdentity = true;
        }
        return null;
    }
}