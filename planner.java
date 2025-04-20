import java.util.*;
public class planner {
    static Scanner sc = new Scanner(System.in);
    static List<String> destinations = Arrays.asList("Goa", "Manali", "Jaipur", "Kerala", "Ladakh");
    static Map<String, Integer> expenses = new HashMap<>();
    static List<String> itinerary = new ArrayList<>();
    static int totalBudget = 0;

    public static void main(String[] args) {
        printDivider();
        printCentered("Welcome to the Travel Planner!");
        printDivider();

        boolean running = true;
        while (running) {
            boolean validActionChosen = false;

            while (!validActionChosen) {
                System.out.println("\nChoose an option:");
                System.out.println("1. View Destinations");
                System.out.println("2. Plan Itinerary");
                System.out.println("3. Set/View Budget");
                System.out.println("4. Add Expense");
                System.out.println("5. View Summary");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                String input = sc.nextLine();

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        showDestinations();
                        validActionChosen = true;
                        break;
                    case 2:
                        planItinerary();
                        validActionChosen = true;
                        break;
                    case 3:
                        manageBudget();
                        validActionChosen = true;
                        break;
                    case 4:
                        addExpense();
                        validActionChosen = true;
                        break;
                    case 5:
                        viewSummary();
                        validActionChosen = true;
                        break;
                    case 6:
                        printCentered("Thank you for using Travel Planner!");
                        running = false;
                        validActionChosen = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            // Ask to continue unless user exited
            if (running) {
                while (true) {
                    System.out.print("\nDo you want to continue? (yes/no): ");
                    String cont = sc.nextLine().trim().toLowerCase();
                    if (cont.equals("yes")) {
                        break;
                    } else if (cont.equals("no")) {
                        printCentered("Thank you for using Travel Planner!");
                        running = false;
                        break;
                    } else {
                        System.out.println("Please enter only 'yes' or 'no'.");
                    }
                }
            }
        }
    }

    static void showDestinations() {
        printDivider();
        printCentered("Available Destinations");
        printDivider();
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i));
        }
    }

    static void planItinerary() {
    printDivider();
    printCentered("Plan Your Itinerary");
    printDivider();

    itinerary.clear();
    int days = 0;
    while (true) {
        System.out.print("Enter number of travel days(in nums): ");
        try {
            days = Integer.parseInt(sc.nextLine());
            if (days <= 0) {
                System.out.println("Please enter a positive number.");
            } else {
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    for (int i = 1; i <= days; i++) {
        System.out.print("Enter activity for Day " + i + ": ");
        String activity = sc.nextLine();
        itinerary.add("Day " + i + ": " + activity);
        System.out.println("Added: " + activity);
    }
}


    static void manageBudget() {
    printDivider();
    printCentered("Set or View Budget");
    printDivider();

    while (true) {
        System.out.print("Enter your total travel budget (in rupees): ");
        try {
            totalBudget = Integer.parseInt(sc.nextLine());
            if (totalBudget <= 0) {
                System.out.println("Please enter a positive amount.");
                continue;
            }
            System.out.println("Budget set to " + totalBudget);
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}


    static void addExpense() {
    printDivider();
    printCentered("Add an Expense");
    printDivider();

    System.out.print("Enter expense description (e.g., Hotel, Food, Taxi): ");
    String desc = sc.nextLine();

    int amount = 0;
    while (true) {
        System.out.print("Enter amount (in rupees): ");
        try {
            amount = Integer.parseInt(sc.nextLine());
            if (amount <= 0) {
                System.out.println("Please enter a positive amount.");
                continue;
            }
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    expenses.put(desc, amount);
    System.out.println("Expense added.");
}


    static void viewSummary() {
        printDivider();
        printCentered("Travel Summary");
        printDivider();

        int totalSpent = expenses.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total Budget: " + totalBudget);
        System.out.println("Total Spent: " + totalSpent);
        System.out.println("Remaining: " + (totalBudget - totalSpent));

        System.out.println("\nExpenses(in rupees):");
        for (String key : expenses.keySet()) {
            System.out.println("- " + key + ": " + expenses.get(key));
        }

        System.out.println("\nItinerary:");
        for (String day : itinerary) {
            System.out.println(day);
        }
    }

    // Utility methods
    public static void printCentered(String message) {
        int width = 80;
        int padding = (width - message.length()) / 2;
        for (int i = 0; i < padding; i++) System.out.print(" ");
        System.out.println(message);
    }

    public static void printDivider() {
        System.out.println("=".repeat(80));
    }
}
