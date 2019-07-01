/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.repository.IProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class ProductService {
    
    @Autowired
    private IProductRepository productRepos;
    
    public List<Product> getAllProduct(){
        return productRepos.findAll();
    }
}
