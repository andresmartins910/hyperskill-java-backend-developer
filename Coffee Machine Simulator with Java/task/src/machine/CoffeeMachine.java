package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP  = 50;
        final int BEANS_PER_CUP = 15;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Write how many ml of water the coffee machine has: ");
            int water = scanner.nextInt();

            System.out.print("Write how many ml of milk the coffee machine has: ");
            int milk = scanner.nextInt();

            System.out.print("Write how many grams of coffee beans the coffee machine has: ");
            int beans = scanner.nextInt();

            System.out.print("Write how many cups of coffee you will need: ");
            int cups = scanner.nextInt();

            int cupsByWater  = water  / WATER_PER_CUP;
            int cupsByMilk   = milk   / MILK_PER_CUP;
            int cupsByBeans  = beans  / BEANS_PER_CUP;
            int cupsPossible = Math.min(cupsByWater, Math.min(cupsByMilk, cupsByBeans));

            if (cupsPossible > cups) {
                System.out.println("Yes, I can make that amount of coffee (and even " +
                        (cupsPossible - cups) + " more than that)");
            } else if (cupsPossible < cups) {
                System.out.println("No, I can make only " + cupsPossible + " cup(s) of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        }
    }
}