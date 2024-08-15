package ra.run;

import ra.common.Common;
import ra.common.DataBase;
import ra.entity.Product;

import java.util.Scanner;

public class ManagementProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("---------------------------PRODUCT MANAGEMENT---------------------------");
            System.out.println("|                 1. Nhập thông tin các sản phẩm                                       |");
            System.out.println("|                 2. Hiển thị thông tin các sản phẩm                                    |");
            System.out.println("|                 3. Sắp xếp các sản phẩm theo giá                                    |");
            System.out.println("|                 4. Cập nhật thông tin sản phẩm theo mã sản phẩm             |");
            System.out.println("|                 5. Xóa sản phẩm theo mã sản phẩm                                  |");
            System.out.println("|                 6. Tìm kiếm các sản phẩm theo tên sản phẩm                    |");
            System.out.println("|                 7. Tìm kiếm sản phẩm trong khoảng giá a – b                     |");
            System.out.println("|                 8. Thoát                                                                           |");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Enter choise");
            int choise = 0 ;
            choise = Common.getInputInt(choise);
            switch (choise){
                case 1 :{
                    System.out.println("Enter quantity product want add : ");
                    int quantity = 0 ;
                    quantity = Common.getInputInt(quantity);
                    for(int i = 1 ; i <= quantity ; i++){
                        System.out.println("Enter product number : " +  i);
                        Product product = new Product();
                        product.inputData(scanner ,DataBase.products,DataBase.currentIndexProduct,DataBase.categories);
                        DataBase.currentIndexProduct++ ;
                        DataBase.products[DataBase.currentIndexProduct] = product ;
                    }
                    System.out.println("Add " +quantity + " product successfully !");
                    Common.displayProduct(DataBase.products);
                    break;
                }
                case  2 : {
                    Common.displayProduct(DataBase.products);
                    break;
                }
                case 3 : {
                        for(int i = 0 ; i < DataBase.currentIndexProduct ; ){
                             if(DataBase.products[i].getPrice() > DataBase.products[i+1].getPrice()){
                                 Product tmp = DataBase.products[i];
                                 DataBase.products[i] = DataBase.products[i+1];
                                 DataBase.products[i+1] = tmp ;
                                 if(i > 0){
                                     i-- ;
                                 }
                             }else {
                                 i++ ;
                             }
                        }
                    System.out.println("Successfully sorted products in ascending order !");
                        Common.displayProduct(DataBase.products);
                        break;
                }
                case 4 : {
                    System.out.println("Enter id product to update :");
                        String idProduct = scanner.nextLine().trim();
                        int indexProduct = -1 ;
                        for(int i = 0 ; i <= DataBase.currentIndexProduct ; i++){
                           if(DataBase.products[i] != null){
                               if(DataBase.products[i].getProductId().equals(idProduct)){
                                   indexProduct = i ;
                                   break;
                               }
                           }else {
                               break;
                           }
                        }
                        if(indexProduct == -1){
                            System.out.println("Not found id product !");
                        }else {
                            DataBase.products[indexProduct].updateData(scanner,DataBase.products,DataBase.categories);
                            System.out.println("Update product successfully !");
                            Common.displayProduct(DataBase.products);
                        }
                        break;
                }
                case 5 : {
                    System.out.println("Enter id product to delete :");
                    String idProduct = scanner.nextLine().trim();
                    int indexProduct = -1 ;
                    for(int i = 0 ; i <= DataBase.currentIndexProduct ; i++){
                        if(DataBase.products[i] != null){
                            if(DataBase.products[i].getProductId().equals(idProduct)){
                                indexProduct = i ;
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                    if(indexProduct == -1){
                        System.out.println("Not found id product !");
                    }else {
                        for(int i = indexProduct ; i < DataBase.currentIndexProduct ; i++){
                            DataBase.products[i] = DataBase.products[i+1];
                        }
                        DataBase.products[DataBase.currentIndexProduct] = null ;
                        DataBase.currentIndexProduct-- ;
                        System.out.println("Delete product successfully !");
                    }
                        break;
                }
                case 6 : {
                    System.out.println("Enter name product to search :");
                    String search = scanner.nextLine().trim();
                    Product[] listProduct = new Product[100];
                    int indexSearch = -1 ;
                    for(Product product : DataBase.products){
                        if(product == null){
                            break;
                        }else {
                            if(product.getProductName().matches(".*"+search+".*")){
                                indexSearch++;
                                listProduct[indexSearch] = product ;
                            }
                        }
                    }
                    if(indexSearch == -1){
                        System.out.println("Not found product !");
                    }else {
                        Common.displayProduct(listProduct);
                    }
                    break;
                }
                case 7 : {
                    System.out.println("Enter min price :");
                    Float minPrice = 0f ;
                   minPrice = Common.getInputFloat(minPrice);

                    System.out.println("Enter max price :");
                    Float maxPrice = 0f ;
                    maxPrice = Common.getInputFloat(maxPrice);

                    Product[] listProduct = new Product[100];
                    int indexSearch = -1 ;
                    for(Product product : DataBase.products){
                        if(product == null){
                            break;
                        }else {
                            if(product.getPrice() >= minPrice && product.getPrice() <= maxPrice){
                                indexSearch++;
                                listProduct[indexSearch] = product ;
                            }
                        }
                    }
                    if(indexSearch == -1){
                        System.out.println("Not found product !");
                    }else {
                        Common.displayProduct(listProduct);
                    }
                    break;

                }
                case 8 : {
                        return;
                }
                default: {
                    System.out.println("Please enter  number from 1 to 8 !");
                }
            }
        }
    }
}
