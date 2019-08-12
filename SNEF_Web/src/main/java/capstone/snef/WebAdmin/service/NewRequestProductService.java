/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.Utility.ImageUtility;
import capstone.snef.WebAdmin.dataform.RequestCreateProductData;
import capstone.snef.WebAdmin.entity.Account;
import capstone.snef.WebAdmin.entity.Categories;
import capstone.snef.WebAdmin.entity.NewProductRequest;
import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.repository.IAccountRepository;
import capstone.snef.WebAdmin.repository.ICategoryRepository;
import capstone.snef.WebAdmin.repository.INewProductRequestRepository;
import capstone.snef.WebAdmin.repository.IProductRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class NewRequestProductService {

    @Autowired
    private IProductRepository productRepos;
    @Autowired
    private INewProductRequestRepository requestRepos;
    @Autowired
    private ICategoryRepository cateRepos;
    @Autowired
    private IAccountRepository accRepos;
    @Autowired
    private IStoreRepository storeRepos;

    public boolean requestCreateProduct(RequestCreateProductData data) {
        ImageUtility iUtil = new ImageUtility();
        if (data.getImageSrc().getName() != null && !data.getImageSrc().getName().isEmpty()) {
            String imgSrc = iUtil.uploadImage(data.getImageSrc());
            if (imgSrc != null) {
                Optional<Categories> categoryRs = cateRepos.findById(data.getCategory());
                Product product = new Product(data.getName(), imgSrc, false, categoryRs.get());

                product = productRepos.save(product);
                if (product != null) {
                    Optional<Account> adminRs = accRepos.findById(3);
                    Optional<Store> storeRs = storeRepos.findById(data.getStoreId());
                    requestRepos.save(new NewProductRequest(product, adminRs.get(), storeRs.get(), true));
                    return true;
                }
            }
        }
        return false;
    }
}
