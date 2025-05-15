package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;
    static boolean running = true;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.print("Write action (buy, fill, take, remaining, exit): ");
                String action = scanner.next().toLowerCase();

                switch (action) {
                    case "buy"       -> handleBuy(scanner);
                    case "fill"      -> handleFill(scanner);
                    case "take"      -> handleTake();
                    case "remaining" -> printState();
                    case "exit"      -> running = false;
                    default          -> System.out.print("Unknown command: " + action);
                }
            }
        }
    }

    public static void printState() {
        System.out.print("The coffee machine has: ");
        System.out.print(water + " ml of water");
        System.out.print(milk + " ml of milk");
        System.out.print(coffeeBeans + " g of coffee beans");
        System.out.print(disposableCups + " disposable cups");
        System.out.print("$" + money + " of money");
    }

    public static void handleBuy(Scanner scanner) {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next().toLowerCase();

        switch (choice) {
            case "1" -> { // espresso
                if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    disposableCups--;
                    System.out.print("I have enough resources, making you a coffee!");
                } else if (water < 250) {
                    System.out.print("Sorry, not enough water!");
                } else if (coffeeBeans < 16) {
                    System.out.print("Sorry, not enough coffee beans!");
                } else if (disposableCups == 0) {
                    System.out.print("Sorry, not enough disposable cups!");
                }
            }
            case "2" -> { // latte
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    disposableCups--;
                    System.out.print("I have enough resources, making you a coffee!");
                } else if (water < 350) {
                    System.out.print("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.print("Sorry, not enough milk!");
                } else if (coffeeBeans < 20) {
                    System.out.print("Sorry, not enough coffee beans!");
                } else if (disposableCups == 0) {
                    System.out.print("Sorry, not enough disposable cups!");
                }
            }
            case "3" -> { // cappuccino
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    disposableCups--;
                    System.out.print("I have enough resources, making you a coffee!");
                } else if (water < 200) {
                    System.out.print("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.print("Sorry, not enough milk!");
                } else if (coffeeBeans < 12) {
                    System.out.print("Sorry, not enough coffee beans!");
                } else if (disposableCups == 0) {
                    System.out.print("Sorry, not enough disposable cups!");
                }
            }
            case "back" -> {}
            default -> System.out.print("Unknown coffee type");
        }
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
        System.out.print("I gave you $" + money);
        money = 0;
    }
}