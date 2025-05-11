package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;

    public static void main(String[] args) {
        printState();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Write action (buy, fill, take): ");
            String action = scanner.next().toLowerCase();

            switch (action) {
                case "buy"  -> handleBuy(scanner);
                case "fill" -> handleFill(scanner);
                case "take" -> handleTake();
                default     -> System.out.println("Unknown command: " + action);
            }
            printState();
        }
    }

    public static void printState() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void handleBuy(Scanner scanner) {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeType = scanner.nextInt();

        switch (coffeeType) {
            case 1 -> {            // espresso
                water -= 250;
                coffeeBeans -= 16;
                money += 4;
                disposableCups--;
            }
            case 2 -> {            // latte
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                money += 7;
                disposableCups--;
            }
            case 3 -> {            // cappuccino
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                disposableCups--;
            }
            default -> System.out.println("Unknown coffee type");
        }
    }

    public static void handleFill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee you want to add: ");
        coffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add: ");
        disposableCups += scanner.nextInt();
    }

    public static void handleTake() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}