/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

import java.util.Date;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class StoreProductData {

    private Integer storeProductId;
    private String imageSrc;
    private String name;
    private Date expiredDate;
    private Integer quantity;
    private double price;
    private String description;
    private String sku;

    public StoreProductData(Integer storeProductId, String imageSrc, String name, Date expiredDate, Integer quantity, double price, String description, String sku) {
        this.storeProductId = storeProductId;
        this.imageSrc = imageSrc;
        this.name = name;
        this.expiredDate = expiredDate;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(Integer storeProductId) {
        this.storeProductId = storeProductId;
    }

}
