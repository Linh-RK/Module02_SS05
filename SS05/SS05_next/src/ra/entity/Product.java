package ra.entity;

import java.util.Date;

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
}
