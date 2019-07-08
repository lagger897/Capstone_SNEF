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
public class AddProductDataForm {
    private Integer storeId;
    private Integer productId;
    private String name;
    private String imageSrc;
    private String description;
    private Date expiredDate;
    private Integer ammount;
    private double price;
    private double discount;
    private double discPrice;

    public AddProductDataForm() {
    }

    public AddProductDataForm(Integer storeId, Integer productId, String name, String imageSrc, String description, Date expiredDate, Integer ammount, double price, double discount, double discPrice) {
        this.storeId = storeId;
        this.productId = productId;
        this.name = name;
        this.imageSrc = imageSrc;
        this.description = description;
        this.expiredDate = expiredDate;
        this.ammount = ammount;
        this.price = price;
        this.discount = discount;
        this.discPrice = discPrice;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(double discPrice) {
        this.discPrice = discPrice;
    }


    @Override
    public String toString() {
//        return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return getName() + "_" + getDescription() + "_" + getImageSrc() + "_" + getAmmount() + "_" + getDiscount() + "_" + getDiscPrice() + "_" + getExpiredDate().toString() + "_" + getPrice();
    }

}
