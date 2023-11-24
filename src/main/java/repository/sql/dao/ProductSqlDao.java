/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.sql.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.sql.domain.ProductSql;

/**
 *
 * @author fraviola
 */
@Repository
public interface ProductSqlDao extends CrudRepository<ProductSql, Integer>{
    
    Optional<ProductSql> findBytypeAndBrand(String productType, String productBrand);
    
}
