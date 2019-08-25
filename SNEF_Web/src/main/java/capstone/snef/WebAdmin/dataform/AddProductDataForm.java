/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class AddProductDataForm {
    private Integer storeId;
    private Integer productId;
    private String name;
    private MultipartFile imageSrc;
    private String previewImage;
    private String description;
    private String expiredDate;
    private Integer ammount;
    private double price;

    public AddProductDataForm() {
    }

    public AddProductDataForm(Integer storeId, Integer productId, String name, MultipartFile imageSrc, String previewImage, String description, String expiredDate, Integer ammount, double price) {
        this.storeId = storeId;
        this.productId = productId;
        this.name = name;
        this.imageSrc = imageSrc;
        this.previewImage = previewImage;
        this.description = description;
        this.expiredDate = expiredDate;
        this.ammount = ammount;
        this.price = price;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return getName() + "_" + getDescription() + "_" + getImageSrc() + "_" + getAmmount() + "_" + "_" + getExpiredDate().toString() + "_" + getPrice();
    }

    public MultipartFile getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(MultipartFile imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

}
