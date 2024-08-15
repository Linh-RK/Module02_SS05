package ra.entity;

import ra.common.Common;
import ra.common.DataBase;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId ;
    private String productName ;
    private Float  price ;
    private String description ;
    private Date created ;

    private int categoryId ;
    private int productStatus ;

    public Product() {
    }

    public Product(String productId, String productName, Float price, String description, Date created, int categoryId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.categoryId = categoryId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int index, Category[] arrCategories){
        while (true){
            System.out.println("Enter productId (gồm 4 ký tự bắt đầu là một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh tố, A: các đồ ăn nhanh) :");
            productId = scanner.nextLine();
            if(productId.matches("^[CSA][0-9]{3}$")){
                break;
            }
        }

        while (true){
            System.out.println("Enter product name (có từ 10-50 ký tự, không được trùng lặp) :");
            productName = scanner.nextLine().trim().toLowerCase();
            boolean isCheck = false ;
            for(Product product : arrProduct){
                if(product != null){
                    if(product.productName.equals(productName)){
                        isCheck = true ;
                        break;
                    }
                }else {
                    break;
                }
            }
            if(isCheck){
                System.err.println("Product name exis !");
            }else if(productName.length() < 10 && productName.length() > 50){
                System.err.println("Length product name > 10 & < 50 !");
            }else {
                break;
            }
        }

        while (true){
            try {
                System.out.println("Enter price :");
                price = Float.parseFloat(scanner.nextLine());
                if(price > 0){
                    break;
                }else {
                    System.out.println("Price > 0 !");
                }
            }catch (Exception e){
                System.err.println("Price  invalid !");
            }
        }

        System.out.println("Enter description : ");
        description = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true){
            try {
                System.out.println("Enter date (dd/mm/yyyy):");
                String date = scanner.nextLine();
                created = formatter.parse(date);
                break;
            } catch (ParseException e) {
                System.err.println("Date invalid !");
            }
        }

        while (true){
           Common.displayCategory(DataBase.categories);
            try {
                System.out.println("Enter categoryId  :");
                categoryId = Integer.parseInt(scanner.nextLine());
                boolean isCheck = false ;
                for(Category cate : arrCategories){
                    if(cate.getCategoryId() == categoryId){
                        isCheck = true ;
                        break;
                    }
                }
                if(!isCheck){
                    System.out.println("Not found id category !");
                }else {
                    break;
                }
            }catch (Exception e){
                System.err.println("Enter  id categopry valid !");
            }
        }

        while (true){
            try {
                System.out.println("Enter product status (0: Đang bán – 1: Hết hàng – 2: Không bán) :");
                productStatus = Integer.parseInt(scanner.nextLine());
                if(productStatus >= 0 && productStatus < 4){
                    break;
                }
            }catch (Exception e){
                System.err.println("Enter valid (0: Đang bán – 1: Hết hàng – 2: Không bán)");
            }
        }
    }

    public void updateData(Scanner scanner, Product[] arrProduct, Category[] arrCategories){

        while (true){
            System.out.println("Enter product name (có từ 10-50 ký tự, không được trùng lặp) :");
            String cateName = scanner.nextLine().trim().toLowerCase();
            boolean isCheck = false ;
            for(Product product : arrProduct){
                if(product != null){
                    if(product.productName.equals(cateName)){
                        isCheck = true ;
                        break;
                    }
                }else {
                    break ;
                }
            }
            if(isCheck){
                System.err.println("Product name exis !");
            }else if(productName.length() < 10 && productName.length() > 50){
                System.err.println("Length product name > 10 & < 50 !");
            }else {
                setProductName(cateName);
                break;
            }
        }

        while (true){
            try {
                System.out.println("Enter price :");
                price = Float.parseFloat(scanner.nextLine());
                if(price > 0){
                    break;
                }else {
                    System.out.println("Price > 0 !");
                }
            }catch (Exception e){
                System.err.println("Price  invalid !");
            }
        }

        System.out.println("Enter description : ");
        description = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true){
            try {
                System.out.println("Enter date (dd/mm/yyyy):");
                String date = scanner.nextLine();
                created = formatter.parse(date);
                break;
            } catch (ParseException e) {
                System.err.println("Date invalid !");
            }
        }

        while (true){
            Common.displayCategory(DataBase.categories);
            try {
                System.out.println("Enter categoryId  :");
                categoryId = Integer.parseInt(scanner.nextLine());
                boolean isCheck = false ;
                for(Category cate : arrCategories){
                   if(cate != null){
                       if(cate.getCategoryId() == categoryId){
                           isCheck = true ;
                           break;
                       }
                   }else {
                       break;
                   }
                }
                if(!isCheck){
                    System.out.println("Not found id category !");
                }else {
                    break;
                }
            }catch (Exception e){
                System.err.println("Enter  id categopry valid !");
            }
        }

        while (true){
            try {
                System.out.println("Enter product status (0: Đang bán – 1: Hết hàng – 2: Không bán) :");
                productStatus = Integer.parseInt(scanner.nextLine());
                if(productStatus >= 0 && productStatus < 4){
                    break;
                }
            }catch (Exception e){
                System.err.println("Enter valid (0: Đang bán – 1: Hết hàng – 2: Không bán)");
            }
        }
    }

    public void displayData(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-30s | %-10f | %-30s | %-12s | %-5d | %-3d |\n" ,productId,productName,price,description,created,categoryId,productStatus);
    }

//    public static void main(String[] args) {
//        Product product  =new Product("C123","huongcaoha",5000f,"handsome",new Date("08/08/2024"),1,0);
//        product.displayData();
//    }
}
