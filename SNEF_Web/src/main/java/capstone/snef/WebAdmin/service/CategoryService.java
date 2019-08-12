/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.entity.Categories;
import capstone.snef.WebAdmin.repository.ICategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class CategoryService {
    @Autowired
   private ICategoryRepository cateRepos;
   public List<Categories> getAllCategories(){
       return cateRepos.findAll();
   }
}
