/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.Utility.ImageUtility;
import capstone.snef.WebAdmin.dataform.RequestCreateProductData;
import capstone.snef.WebAdmin.entity.NewProductRequest;
import capstone.snef.WebAdmin.repository.INewProductRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class NewRequestProductService {

    @Autowired
    private ImageUtility iUtil;
    @Autowired
    private INewProductRequestRepository requestRepos;

    public boolean requestCreateProduct(RequestCreateProductData data) {
        if (data.getImageSrc().getName() != null && !data.getImageSrc().getName().isEmpty()) {
            String imgSrc = iUtil.uploadImage(data.getImageSrc());
            if (imgSrc!=null){
              requestRepos.save(new NewProductRequest());
            }
        }
        return false;
    }
}
