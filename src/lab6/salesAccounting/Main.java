package lab6.salesAccounting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SalesAccounting state = new SalesAccounting();
        Scanner in = new Scanner(System.in);
        scope: for (;;) {
            System.out.println("\n");
            System.out.println("Chose what you want: " +
                    "\ninp - to input," +
                    "\nmp - to print most popular" +
                    "\nmoney - to print your money" +
                    "\nlist - to show products" +
                    "\nq - to exit");
            String command = in.nextLine();
            switch (command) {
                case "inp":
                {
                    System.out.println("Enter your product" +
                            "\nname price (count):");
                    String str = in.nextLine();
                    Product product = Product.parseProduct(str);
                    if (product != null) {
                        state.inputProduct(product);
                    } else {
                        System.out.println("Incorrect input!!!");
                    }
                    break;
                }
                case "mp":
                {
                    Product product = state.mostPopular();
                    System.out.println("Most popular:");
                    product.display();
                    break;
                }
                case "money":
                {
                    System.out.println("Your money:");
                    System.out.println(state.getMoney());
                    break;
                }
                case "list":
                {
                    state.displayProducts();
                    break;
                }
                case "q":
                {
                    break scope;
                }
                default: break;
            }
        }
    }
}
