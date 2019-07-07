/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IProductRepository extends CrudRepository<Product, Integer> {

    @Override
    public List<Product> findAll();

    public List<Product> findAllByProductName(String productName);
    
    @Query(value="SELECT * FROM Product p WHERE p.ProductName LIKE %?1%",nativeQuery = true)
    public List<Product> searchAllByProductName(String productName);

    @Override
    public Optional<Product> findById(Integer id);
    
    
}
