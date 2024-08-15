package ra.run;

import jdk.jfr.Category;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    //Sử dụng currentCategory để lưu lại tổng số category đã được nhập
    public static int currentIndexCate = 0;
    //Sử dụng currentProduct để lưu lại tổng số product đã được nhập
    public static int currentProduct = 0;

    //Sử dụng các mảng kiểu static để lưu và cập nhật lại các dữ  liệu  được thay đổi
    public static Categories[] arrCategories = new Categories[100];
    public static Product[] arrProducts = new Product[100];
    public static void main(String[] args) {
    CategoryManagement categoryManagement = new CategoryManagement();
    Scanner scanner = new Scanner(System.in);
    int choice;
    while(true) {
        System.out.println("-----------------------------Menu-----------------------------");
        System.out.println("|        1. Quản lý danh mục sản phẩm                        |");
        System.out.println("|        2. Quản lý sản phẩm                                 |");
        System.out.println("|        3. Thoát                                            |");
        System.out.println("--------------------------------------------------------------");
        choice = Integer.parseInt(scanner.nextLine());
    switch (choice){
        case 1:
        {

        }
        case 2:
        {

        }
        case 3:
        {

        }
        default:
        {
        }
    }
    }
    }
}
