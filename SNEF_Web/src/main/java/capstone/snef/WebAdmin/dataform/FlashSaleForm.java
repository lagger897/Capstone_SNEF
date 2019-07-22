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
public class FlashSaleForm {

    private Integer storeProductId;
    private Date startDate;
    private Date endDate;
    private Integer quantity;
    private Integer discount;

    public FlashSaleForm() {
    }

    public FlashSaleForm(Integer storeProductId, Date startDate, Date endDate, Integer quantity, Integer discount) {
        this.storeProductId = storeProductId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Integer getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(Integer storeProductId) {
        this.storeProductId = storeProductId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
