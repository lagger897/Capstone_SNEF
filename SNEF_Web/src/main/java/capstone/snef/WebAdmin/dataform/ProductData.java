/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class ProductData {
    private Integer productId;
    private String productName;
    private String imageSrc;

    public ProductData(Integer productId, String productName, String imageSrc) {
        this.productId = productId;
        this.productName = productName;
        this.imageSrc = imageSrc;
    }

    public ProductData() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
}
