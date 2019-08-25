/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class StoreProductImageData {

    private Integer storeProductId;
    private String imageSrc;
    private MultipartFile imageFileSrc;
    private String name;
    private String expiredDate;
    private Integer quantity;
    private double price;
    private String description;

    public StoreProductImageData() {
    }

    public StoreProductImageData(Integer storeProductId, String imageSrc, MultipartFile imageFileSrc, String name, String expiredDate, Integer quantity, double price, String description) {
        this.storeProductId = storeProductId;
        this.imageSrc = imageSrc;
        this.imageFileSrc = imageFileSrc;
        this.name = name;
        this.expiredDate = expiredDate;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Integer getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(Integer storeProductId) {
        this.storeProductId = storeProductId;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public MultipartFile getImageFileSrc() {
        return imageFileSrc;
    }

    public void setImageFileSrc(MultipartFile imageFileSrc) {
        this.imageFileSrc = imageFileSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
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
    
    
}
