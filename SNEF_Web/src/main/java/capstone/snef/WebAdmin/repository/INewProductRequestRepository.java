/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.NewProductRequest;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface INewProductRequestRepository extends CrudRepository<NewProductRequest, Integer> {

    @Override
    public long count();

    @Override
    public <S extends NewProductRequest> S save(S s);

    @Override
    public List<NewProductRequest> findAllById(Iterable<Integer> itrbl);

    @Override
    public List<NewProductRequest> findAll();

}
