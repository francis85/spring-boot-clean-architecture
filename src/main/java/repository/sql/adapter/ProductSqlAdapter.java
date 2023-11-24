/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.sql.adapter;

import core.exception.ResourcesNotFoundException;
import core.product.domain.Product;
import org.modelmapper.ModelMapper;
import repository.sql.ProductSqlRepository;
import repository.sql.dao.ProductSqlDao;

/**
 *
 * @author fraviola
 */
public class ProductSqlAdapter implements ProductSqlRepository {

    private final ProductSqlDao productSqlDao;
    private final ModelMapper modelMapper;

    public ProductSqlAdapter(ProductSqlDao productSqlDao, ModelMapper modelMapper) {
        this.productSqlDao = productSqlDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product findProduct(String type, String brand) {
        return productSqlDao.findBytypeAndBrand(type, brand)
                .map(productSql -> modelMapper.map(productSql, Product.class))
                .orElseThrow(() -> new ResourcesNotFoundException(404, "Product not found"));
    }

}
