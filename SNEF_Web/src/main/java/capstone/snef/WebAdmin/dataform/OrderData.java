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
public class OrderData {

    private Integer orderId;
    private Date dateOrder;
    private String confirmationCode;
    private boolean status;
    private float ratingPoint;
    private String firstname;
    private String lastname;

    public OrderData() {
    }

    public OrderData(Integer orderId, Date dateOrder, String confirmationCode, boolean status, float ratingPoint, String firstname, String lastname) {
        this.orderId = orderId;
        this.dateOrder = dateOrder;
        this.confirmationCode = confirmationCode;
        this.status = status;
        this.ratingPoint = ratingPoint;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(float ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}
