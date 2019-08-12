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
public class RequestCreateProductData {
    private Integer storeId;
    private String name;
    private MultipartFile imageSrc;
    private Integer category;

    public RequestCreateProductData() {
    }

    public RequestCreateProductData(Integer storeId, String name, MultipartFile imageSrc, Integer category) {
        this.storeId = storeId;
        this.name = name;
        this.imageSrc = imageSrc;
        this.category = category;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(MultipartFile imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    
           
}
