package client;

import core.product.domain.input.ProductInput;
import core.product.domain.output.ProductOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import util.JsonParser;

@Slf4j
public class ProductClientImpl implements ProductClient {

    private String riskUrl;
    private RestTemplate restTemplate;

    public ProductClientImpl(String riskUrl, RestTemplate restTemplate) {
        this.riskUrl = riskUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductInput getProductInput(String productId) {

        try {
            String json = JsonParser.toJson(new ProductOutput(productId));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity entity = new HttpEntity(json, headers);
            return restTemplate.postForObject(riskUrl, entity, ProductInput.class);
        } catch (Exception ex) {
            log.error("Error to json -> {}", ex);
        }
        return null;
    }
}
