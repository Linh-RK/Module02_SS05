package ra.enrity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float price;
    private String descriptions;
    private Date created;
    private int categoryId;
    private int productStatus;
    //----------------------
    public Product() {};

    public Product(String productID, String productName, float price, String descriptions, Date created, int categoryId, int productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.descriptions = descriptions;
        this.created = created;
        this.categoryId = categoryId;
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
    public void inputData(Scanner sc, Product[] arrProduct, int currentPro, Category[] arrCategory, int currentCate ) {
        this.productID = inputProductId(sc, arrProduct, currentPro, arrCategory, currentCate);
        this.productName = inputProductName(sc, arrProduct, currentPro, arrCategory, currentCate);
        this.price = inputPrice(sc);
        System.out.println("Enter product description:");
        this.descriptions = sc.nextLine();
        this.created = inputCreated(sc);
        this.categoryId = inputCategoryId(sc, arrProduct, currentPro, arrCategory, currentCate);
        this.productStatus = inputProductStatus(sc);

    }

    public int inputProductStatus(Scanner sc) {
        do {
            System.out.println("Enter product status:");
            System.out.println("1. Available");
            System.out.println("2. Out of Stock");
            System.out.println("3. Unavailable");
            int status = Integer.parseInt(sc.nextLine());
            if (status < 1 || status > 3)
                System.out.println("Please enter product status form 1 to 3");

            else
                return status - 1;
        }while (true);
    }

    public int inputCategoryId(Scanner sc, Product[] arrProduct, int currentPro, Category[] arrCategory, int currentCate) {
        for (int i = 0; i < currentCate; i++) {
            System.out.println("Choose category ID:");
            System.out.printf("[ID: %d | Name: %s]\n", arrCategory[i].getCatalogId(), arrCategory[i].getCatalogName());
        }
        System.out.println("Enter category ID of this product:");
        do {
                int idChoice = Integer.parseInt(sc.nextLine());

            boolean isExist = false;
            for (int i = 0; i < currentCate; i++) {
                if (arrCategory[i].getCatalogId() == idChoice) {
                    isExist = true;
                }
            }
            if (isExist) {
                return idChoice;
            }else
                System.out.println("Invalid category ID");

        } while(true);
    }

    public Date inputCreated(Scanner sc) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Enter product creation date:");
        do{
            System.out.println("Enter product creation date dd/mm/yyyy:");
            String Date = sc.nextLine();
            try{
                return sdf.parse(Date);
            }
            catch(Exception e) {
                System.out.println("Enter product creation date dd/mm/yyyy:");
            }
        }
        while (true);
    }


    private float inputPrice(Scanner sc) {
        System.out.println("Please enter the price of the product: ");
        do{
            String price = sc.nextLine();
            if (price.trim().isEmpty()) {
                System.out.println("Price cannot be empty");
            } else{
            try{
                float priceFloat = Float.parseFloat(price);
                if(priceFloat <= 0){
                    System.out.println("Price must be positive integer !");
                }
                else
                    return priceFloat;

            }
            catch (Exception e) {
                System.err.println("Price must be positive integer !");
            }

            }
        } while(true);
    }

    private String inputProductName(Scanner sc, Product[] arrProduct, int currentPro, Category[] arrCategory, int currentCate) {
        System.out.println("Enter product name: ");
        do {
            String productName = sc.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Data can not be blank !");
            } else {
                if (productName.length() <10 || productName.length() > 50) {
                    System.out.println("Product name can not be shorter than 10 and longer than 50 characters !");
                } else {
                    boolean isExist = false;
                    for(int i = 0; i<currentPro; i++) {
                        if(arrProduct[i].getProductName().equals(productName)) {
                            isExist = true;
                            break;
                        }
                    }
                    if(isExist) {
                        System.out.println(productName + "is already exists!");
                    } else
                        return productName;
                }
            }
        }while(true);

    }

    private String inputProductId(Scanner sc, Product[] arrProduct, int currentPro, Category[] arrCategory, int currentCate ) {
        System.out.println("Enter product ID (Cxxx | Sxxx | Axxx): ");
        do{
            String productID = sc.nextLine();
            if(productID.matches("^[CSA]\\w{3}$")) {
                boolean isExist = false;
                for(int i = 0; i<currentPro; i++) {
                    if(arrProduct[i].getProductID().equals(productID)) {
                        isExist = true;
                        break;
                    }
                }
                if(isExist) {
                    System.out.println("Product ID " + productID + " already exists!");
                } else
                    return productID;
            } else
                System.out.println("Product ID must be Cxxx or Sxxx or Axxx");
        }
        while (true);
    }
}
