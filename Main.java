import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        LocalDate date = LocalDate.now();

        LocalDate christmas = LocalDate.of(date.getYear(), 12, 25);
        LocalDate blackFriday = LocalDate.of(2025, 11, 28);     // Change this every year
        LocalDate diwali = LocalDate.of(2025, 10, 20);          // Change this every year   

        try (Scanner scanner = new Scanner(System.in)) {
            String[] names = {"Laptop", "Smartphone", "Headphones", "TV", "Watch", "Tablet", "Keyboard", "Monitor", "Mouse", "Speaker"};
            String[] brands = {"Dell", "Samsung", "Sony", "LG", "Apple", "Microsoft", "Logitech", "Samsung", "Razer", "Bose"};
            int[] prices = {800, 500, 150, 1200, 400, 600, 80, 250, 60, 200};

            int balance = 2000;
            int choice;

            int index;

            double discount;
            boolean canBuy;

            int price;
            double total;
    
            ArrayList<Product> products = new ArrayList<>();
    
            for (int i = 0; i < 20; i++) {
                index = random.nextInt(names.length);
                products.add(new Product(names[index], brands[index], prices[index]));
            } 
    
            while (balance > 0 && !products.isEmpty()) {
                canBuy = false;

                System.out.println("Products: ");

                for (int i = 0; i < products.size(); i++) {
                    System.out.println((i + 1) + ". " + products.get(i).toString());

                    if (products.get(i).getPrice() <= balance) {
                        canBuy = true;
                    }
                }

                if (!canBuy) {
                    System.out.println("\nYou do not have enough money to buy anything else");
                    break;
                }

                System.out.println();
    
                do { 
                    System.out.print("Enter Choice or enter 0 for quit (Balance: $" + balance + "): ");
                    choice = scanner.nextInt();
                } while (choice < 0 || (choice - 1) >= products.size());

                if (choice == 0) {
                    break;
                }

                price = products.get(choice - 1).getPrice();
    
                if (price <= balance) {
                    discount = getDiscount(date, christmas, diwali, blackFriday);

                    if (discount > 0) {
                        System.out.println("\nHappy Holidays!");
                    }

                    total = price - (price * discount);
                    balance -= total;

                    products.remove(choice - 1);

                    System.out.println("\nProduct bought successfully with a " + (discount * 100) + "% discount for $" + total + "\n");
                }
    
                else {
                    System.out.println("\nYou don't have enough money to buy it\n");
                }
            }

            if (products.isEmpty()) {
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
