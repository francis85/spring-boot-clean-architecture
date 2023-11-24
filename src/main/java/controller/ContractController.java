package controller;

import core.contract.domain.Contract;
import core.contract.domain.input.ContractInput;
import core.contract.domain.output.ContractOutput;
import core.contract.service.ContractService;
import core.product.domain.Product;
import core.product.domain.Template;
import core.product.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;

public class ContractController {

    private final ProductService productService;
    private ContractService contractService;

    public ContractController(ProductService productService, ContractService contractService) {
        this.productService = productService;
        this.contractService = contractService;
    }

    public ContractOutput generateContract(ContractInput input){

        Product product = productService.getProduct(input.getProductId());
        Contract contract = contractService.createContract(product, input.getUserId());
        List<String> templatesNames = contract.getProduct().getTemplates().stream().map(Template::getName).collect(Collectors.toList());

        return new ContractOutput(contract.getId(), templatesNames);
    }
}
