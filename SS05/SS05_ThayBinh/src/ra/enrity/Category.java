package ra.enrity;

import java.util.Scanner;

public class Category {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private Boolean catalogStatus;

    public Category() {
    }

    public Category(int catalogId, String catalogName, String descriptions, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Category[] arrCategory, int currentCate){
      this.catalogId = idAutoIncrement(arrCategory,currentCate);
      this.catalogName = inputCatalogName(scanner,arrCategory,currentCate);
      System.out.println("Enter descriptions for " + this.catalogName);
      this.descriptions = scanner.nextLine();
      this.catalogStatus = inputCatalogStatus(scanner);
  }

    public Boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Enter true or false");
        do{
            String status = scanner.nextLine();
            if(status.trim().isEmpty()){
                System.out.println("Must be input data");
            } else {
                if(status.equalsIgnoreCase("true")||status.equalsIgnoreCase("false")){
                    return Boolean.parseBoolean(status);
                }
                else
                    System.out.println("Please enter true or false");
            }
        }
        while (true);
    }

    public String inputCatalogName(Scanner scanner,Category[] arrCategory, int currentCate) {
        System.out.println("Please enter the name of the category");
        do {
            String catalogName = scanner.nextLine();
            if(catalogName.trim().isEmpty())
                System.out.println("Must be input data");

            else {

                if(catalogName.length() > 50)
                    System.out.println("Category name must be less than 50 characters");

                else {
                    boolean isExit = false;
                    for (int i = 0; i < currentCate; i++) {
                        if (arrCategory[i].getCatalogName().equalsIgnoreCase(catalogName)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit)
                        System.out.println("Category name already exists");
                    else
                        return catalogName;
                }
            }
        }while(true);
    }

    public int idAutoIncrement(Category[] arrCategory, int currentCate) {
        int maxId = 0;
        for (int i = 0; i < currentCate; i++) {
            if (arrCategory[i].getCatalogId() > maxId){
                maxId = arrCategory[i].getCatalogId();
            }
        }
        return maxId+1;
    }
    public void displayData() {
        System.out.printf("[ ID: %d | Name: %s | Description: %s | Status: %s ]\n",
                this.catalogId,
                this.catalogName,
                this.descriptions,
                this.catalogStatus ? "Active" : "Inactive");
    }


}
