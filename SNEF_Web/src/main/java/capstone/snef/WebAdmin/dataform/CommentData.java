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
public class CommentData {
    private Integer orderId;
    private String customer;
    private String comment;
    private Double ratingPoint;
    private Date orderDate;

    public CommentData() {
    }

    public CommentData(Integer orderId, String customer, String comment, Double ratingPoint, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.comment = comment;
        this.ratingPoint = ratingPoint;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(Double ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    

}
