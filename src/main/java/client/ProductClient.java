package client;

import core.product.domain.input.ProductInput;

public interface ProductClient {

    ProductInput getProductInput(String productId);
}
