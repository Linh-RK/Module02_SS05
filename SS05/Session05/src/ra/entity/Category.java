package ra.entity;

import java.util.Scanner;

public class Category {
    private Integer categoryId ;
    private String categoryName ;
    private String depcription ;
    private Boolean categoryStatus ;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String depcription, Boolean categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.depcription = depcription;
        this.categoryStatus = categoryStatus;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDepcription() {
        return depcription;
    }

    public void setDepcription(String depcription) {
        this.depcription = depcription;
    }

    public Boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public void inputData(Scanner scanner ,Category[] categories ,int index){
        categoryId = index + 2 ;
        while (true){
            boolean isCheck = true ;
            System.out.println("Enter category name :");
                categoryName = scanner.nextLine().trim().toLowerCase();
                for(Category cate : categories){
                   if(cate != null){
                       if(cate.categoryName.equals(categoryName)){
                           isCheck = false ;
                           break;
                       }
                   }
                }
                if(!isCheck){
                    System.err.println("Category name exist !");
                }else if (categoryName.length() > 50){
                    System.err.println("Length category name > 50 character !");
                }else {
                    break;
                }
        }

        System.out.println("Enter description :");
        depcription = scanner.nextLine();

        while (true){
            try {
                System.out.println("Enter status category (true -> action , false -> inaction ) :");
                categoryStatus = Boolean.parseBoolean(scanner.nextLine());
                break;
            }catch (Exception e){
                System.err.println("Enter  status :(true -> action , false -> inaction )");
            }
        }
    }

    public void updateData(Scanner scanner ,Category[] categories ,int index){

        while (true){
            boolean isCheck = false ;
            System.out.println("Enter category name :");
           String categoryName = scanner.nextLine().trim().toLowerCase();
            for(Category cate : categories){
               if(cate != null){
                   if(cate.getCategoryName().equals(categoryName)){
                       isCheck = true ;
                       break;
                   }
               }else {
                   break;
               }
            }
            if(isCheck){
                System.err.println("Category name exist !");
            }else if (categoryName.length() > 50){
                System.err.println("Length category name > 50 character !");
            }else {
                setCategoryName(categoryName);
                break;
            }


        }

        System.out.println("Enter description :");
        depcription = scanner.nextLine();

        while (true){
            try {
                System.out.println("Enter status category (true -> action , false -> inaction ) :");
                categoryStatus = Boolean.parseBoolean(scanner.nextLine());
                break;
            }catch (Exception e){
                System.err.println("Enter  status :(true -> action , false -> inaction )");
            }
        }
    }

    public void displayData(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5d | %-50s | %-50s | %-10s |",categoryId,categoryName,depcription,categoryStatus);
        System.out.println();
    }

//    public static void main(String[] args) {
//        Category category1 = new Category(1,"Bim Bim","ngon vl",true);
//        Category category2 = new Category(2,"Kẹo mut","ngon vl",true);
//        category1.displayData();
//        category2.displayData();
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
//
//    }

}
