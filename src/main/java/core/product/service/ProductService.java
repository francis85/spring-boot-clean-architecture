package core.product.service;

import client.ProductClient;
import core.product.domain.Product;
import core.product.domain.input.ProductInput;
import repository.sql.ProductSqlRepository;

public class ProductService {

    private final ProductClient productClient;
    private final ProductSqlRepository  productSqlRepository;

    public ProductService(ProductClient productClient, ProductSqlRepository productSqlRepository) {
        this.productClient = productClient;
        this.productSqlRepository = productSqlRepository;
    }

    public Product getProduct(String productId) {
        final ProductInput productIn = new ProductInput("LOANS", "MANGO"); //productClient.getProductIn(productId);
        return productSqlRepository.findProduct(productIn.getType(), productIn.getBrand());
    }
}
