package ra.entity;

import java.util.Scanner;

import static java.lang.System.err;

public class Categories {

        private int catalogId;
        private String categoryName;
        private String descriptions;
        private Boolean categoryStatus;

        public Categories() {
        }
        public Categories(int catalogId, String categoryName, String descriptions, Boolean categoryStatus) {
            this.catalogId = catalogId;
            this.categoryName = categoryName;
            this.descriptions = descriptions;
            this.categoryStatus = categoryStatus;
        }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int currentIndexCate){
        catalogId = inputCateId(scanner, arrCategories,currentIndexCate);
        categoryName = inputCateName(scanner, arrCategories, currentIndexCate);
        descriptions = inputDescription(scanner);
        categoryStatus = inputCateStatus(scanner);
        }

    private Boolean inputCateStatus(Scanner scanner) {
        System.out.println("Enter category status: true (is active) or false (is inactive): ");
        while (true){
            try {
                return Boolean.parseBoolean(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Category status must be true or false");
            }
        }
    }

    private String inputDescription(Scanner scanner) {
        System.out.println("Enter description: ");
        return scanner.nextLine();
    }

    private String inputCateName(Scanner scanner, Categories[] arrCategories, int currentIndexCate) {
        System.out.println("Enter Category Name: ");
        boolean isExist = false;
        String cateName;

        while(true){
            do{
                cateName = scanner.nextLine().trim().toLowerCase();
            }while(cateName == null);
            if(cateName.length() > 50){
                System.out.println("Category name must be less than 50 characters!");
            } else if (isExistCateName(scanner, arrCategories)){
                System.out.println("Category name already exists!");
            }
//            else
//                return cateName;
        }
    }

    private boolean isExistCateName(Scanner scanner, Categories[] arrCategories) {
            for(Categories cate : arrCategories){
                if(cate!= null && cate.getCategoryName().equalsIgnoreCase(categoryName)){
                    return true;
                }
            }
        return false;
    }

    private int inputCateId(Scanner scanner, Categories[] arrCategories, int currentIndexCate) {
            if(currentIndexCate == -1 ){
                return 1;
            } else
                return arrCategories[currentIndexCate].catalogId + 1;
    }

    public void displayData(Categories[] arrCategories, int currentIndexCate) {
            if(currentIndexCate == -1 ){
                System.out.println("Category is blank !");
            } else {
                for(int i = 0; i < currentIndexCate; i++){
                    System.out.printf("%-76s\n","----------------------------------------------------------------------------");
                    System.out.printf("|%-5d|%-30s|%-30s|%-7s|\n",catalogId,categoryName,descriptions,categoryStatus?"active":"inactive");
                }
                System.out.printf("%-76s\n","----------------------------------------------------------------------------");
                }
            }
}



