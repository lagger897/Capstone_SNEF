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
public class FlashSaleProductData {

    private String image;
    private String name;
    private double discPrice;
    private int totalQuantity;
    private int soldNum;
    private int inStock;
    private Date startDate;
    private Date endDate;
    private Date expireDate;
    private boolean status;

    public FlashSaleProductData() {
    }

    public FlashSaleProductData(String image, String name, double discPrice, int totalQuantity, int soldNum, int inStock, Date startDate, Date endDate, Date expireDate, boolean status) {
        this.image = image;
        this.name = name;
        this.discPrice = discPrice;
        this.totalQuantity = totalQuantity;
        this.soldNum = soldNum;
        this.inStock = inStock;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expireDate = expireDate;
        this.status = status;
    }

    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(double discPrice) {
        this.discPrice = discPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
