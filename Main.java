import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        LocalDate date = LocalDate.now();

        LocalDate christmas = LocalDate.of(date.getYear(), 12, 25);
        LocalDate diwali = LocalDate.of(date.getYear(), 12, 25);
        LocalDate blackFriday = LocalDate.of(date.getYear(), 12, 25);

        try (Scanner scanner = new Scanner(System.in)) {
            String[] names = {"Laptop", "Smartphone", "Headphones", "TV", "Watch", "Tablet", "Keyboard", "Monitor", "Mouse", "Speaker"};
            String[] brands = {"Dell", "Samsung", "Sony", "LG", "Apple", "Microsoft", "Logitech", "Samsung", "Razer", "Bose"};
            int[] prices = {800, 500, 150, 1200, 400, 600, 80, 250, 60, 200};

            int balance = 10000;
            int choice;

            int index;

            double discount;
    
            ArrayList<Product> products = new ArrayList<>();
    
            for (int i = 0; i < 20; i++) {
                index = random.nextInt(names.length);
                products.add(new Product(names[index], brands[index], prices[index]));
            } 
    
            while (balance > 0 && !products.isEmpty()) {
                System.out.println("Products: ");

                for (int i = 0; i < products.size(); i++) {
                    System.out.println((i + 1) + ". " + products.get(i).toString());
                }

                System.out.println();
    
                do { 
                    System.out.print("Enter Choice (Balance: $" + balance + "): ");
                    choice = scanner.nextInt();
                } while (choice < 1 || (choice - 1) >= products.size());
    
                if (products.get(choice - 1).getPrice() <= balance) {
                    discount = getDiscount(date, christmas, diwali, blackFriday);

                    if (discount > 0) {
                        System.out.println("\nHappy Holidays!");
                    }

                    balance -= ((products.get(choice - 1).getPrice()) - (products.get(choice - 1).getPrice() * discount));
                    products.remove(choice - 1);

                    System.out.println("\nProduct bought successfully with a " + (discount * 100) + "% discount\n");
                }
    
                else {
                    System.out.println("\nYou don't have enough money to buy it\n");
                }
            }

            if (balance <= 0) {
                System.out.println("You spent all of your money!");
            }

            else {
                System.out.println("\nYou bought everything!");
            }

            System.out.println("\nThanks for buying from us!");
        }
    }

    static double getDiscount(LocalDate date, LocalDate christmas, LocalDate diwali, LocalDate blackFriday) {
        if (date.equals(christmas)) {
            return 0.35;
        }

        else if (date.equals(diwali)) {
            return 0.30;
        }

        else if (date.equals(blackFriday)) {
            return 0.45;
        }

        else {
            return 0;
        }
    }
}