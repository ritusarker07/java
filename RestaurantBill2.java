//  2nd Lab - Resturant Bill

import java.util.Scanner;

public class RestaurantBill2{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display menu
        System.out.println("========== RESTAURANT MENU ==========");
        System.out.println("1. Burger   - 250.00");
        System.out.println("2. Pizza    - 500.00");
        System.out.println("3. Pasta    - 300.00");
        System.out.println("4. Coffee   - 150.00");
        System.out.println("=====================================");

        // Take quantities as input
        System.out.print("Enter quantity of Burger: ");
        int burgerQty = sc.nextInt();

        System.out.print("Enter quantity of Pizza: ");
        int pizzaQty = sc.nextInt();

        System.out.print("Enter quantity of Pasta: ");
        int pastaQty = sc.nextInt();

        System.out.print("Enter quantity of Coffee: ");
        int coffeeQty = sc.nextInt();

        // Calculate individual costs
        double burgerCost = burgerQty * 250.00;
        double pizzaCost = pizzaQty * 500.00;
        double pastaCost = pastaQty * 300.00;
        double coffeeCost = coffeeQty * 150.00;

        // Calculate subtotal
        double subtotal = burgerCost + pizzaCost + pastaCost + coffeeCost;

        // Calculate tax (10%)
        double tax = subtotal * 0.10;

        // Calculate final bill
        double totalBill = subtotal + tax;

        // Display restaurant bill
        System.out.println("\n========== RESTAURANT BILL ==========");
        System.out.printf("%-15s %-10s %-10s%n", "Item", "Quantity", "Amount");
        System.out.println("-------------------------------------");

        System.out.printf("%-15s %-10d %.2f%n",
                "Burger", burgerQty, burgerCost);
        System.out.printf("%-15s %-10d %.2f%n",
                "Pizza", pizzaQty, pizzaCost);
        System.out.printf("%-15s %-10d %.2f%n",
                "Pasta", pastaQty, pastaCost);
        System.out.printf("%-15s %-10d %.2f%n",
                "Coffee", coffeeQty, coffeeCost);

        System.out.println("-------------------------------------");
        System.out.printf("%-25s %.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-25s %.2f%n", "Tax (10%):", tax);
        System.out.printf("%-25s %.2f%n", "Total Bill:", totalBill);
        System.out.println("=====================================");

        sc.close();
    }
}