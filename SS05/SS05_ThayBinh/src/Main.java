import ra.enrity.Category;
import ra.enrity.Product;

import java.util.Scanner;

public class Main {
    public static Category[] arrCategory = new Category[100];
    public static Product[] arrProduct = new Product[100];
    public static int currentCate = 0;
    public static int currentPro = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            Main main = new Main();
            System.out.println("------------------------Menu------------------------");
            System.out.println("         1. Category Management                     ");
            System.out.println("         2. Product Management                      ");
            System.out.println("         3.Exit                                     ");
            System.out.println("----------------------------------------------------");
            System.out.println("                    Enter your choice:              ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:{
                    main.menuCategory(scanner);
                    break;
                }
                case 2:{
                    main.menuProduct(scanner);
                    break;
                }
                case 3:{
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        while (true);
    }
    public void menuCategory(Scanner scanner) {
        System.out.println("----------------------Menu----------------------");
        System.out.println("             1. Insert Category                 ");
        System.out.println("             2. Display Category                ");
        System.out.println("             3. Update Category                 ");
        System.out.println("             4. Delete Category                 ");
        System.out.println("             5. Update Category Status          ");
        System.out.println("             6. Exist                           ");
        System.out.println("------------------------------------------------");
        System.out.println("                 Enter your choice:             ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice) {
            case 1:{
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
            case 5:{
                break;
            }
            case 6:{

                break;
            }
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    public void menuProduct(Scanner scanner) {

    }

}

