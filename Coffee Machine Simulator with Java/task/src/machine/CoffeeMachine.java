package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk  = 540;
    static int coffeeBeans = 120;
    static int disposableCups  = 9;
    static int money = 550;
    static int coffeesMade = 0;

    static boolean running = true;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.print("Write action (buy, fill, take, clean, remaining, exit): ");
                String action = scanner.next().toLowerCase();

                switch (action) {
                    case "buy"       -> handleBuy(scanner);
                    case "fill"      -> handleFill(scanner);
                    case "take"      -> handleTake();
                    case "clean"     -> handleCleaning();
                    case "remaining" -> printState();
                    case "exit"      -> running = false;
                    default          -> System.out.println("Unknown command: " + action);
                }
            }
        }
    }

    public static void printState() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    public static void handleBuy(Scanner scanner) {
        if (coffeesMade >= 10) { System.out.println("I need cleaning!"); return; }

        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next().toLowerCase();

        Recipe recipe = null;
        switch (choice) {
            case "1": recipe = Recipe.ESPRESSO;   break;
            case "2": recipe = Recipe.LATTE;      break;
            case "3": recipe = Recipe.CAPPUCCINO; break;
            case "back": { return; }
            default: System.out.println("Unknown coffee type");
        }

        if (recipe == null) { return; }
        if (water < recipe.water) { System.out.println("Sorry, not enough water!"); return; }
        if (milk < recipe.milk) { System.out.println("Sorry, not enough milk!"); return; }
        if (coffeeBeans < recipe.beans) { System.out.println("Sorry, not enough coffee beans!"); return; }
        if (disposableCups < 1) { System.out.println("Sorry, not enough disposable cups!"); return; }

        System.out.println("I have enough resources, making you a coffee!");
        water          -= recipe.water;
        milk           -= recipe.milk;
        coffeeBeans    -= recipe.beans;
        disposableCups -= 1;
        money          += recipe.price;
        coffeesMade    ++;
    }

    public static void handleFill(Scanner scanner) {
        System.out.print("Write how many ml of water you want to add: ");
        water += scanner.nextInt();

        System.out.print("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();

        System.out.print("Write how many grams of coffee you want to add: ");
        coffeeBeans += scanner.nextInt();

        System.out.print("Write how many disposable cups you want to add: ");
        disposableCups += scanner.nextInt();
    }

    public static void handleTake() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void handleCleaning() {
        System.out.println("I have been cleaned!");
        coffeesMade = 0;
    }
}