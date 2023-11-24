/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.contract.service;

import core.contract.domain.Contract;
import core.product.domain.Product;
import java.util.UUID;
import repository.document.ContractDocumentRepository;

/**
 *
 * @author fraviola
 */
public class ContractService {

    private ContractDocumentRepository contractDocumentRepository;

    public ContractService(ContractDocumentRepository contractDocumentRepository) {
        this.contractDocumentRepository = contractDocumentRepository;
    }

    public Contract createContract(Product product, String userId) {
        Contract contract = new Contract(UUID.randomUUID().toString().replace("-", ""), userId, product);

        return contractDocumentRepository.saveContract(contract);
    }

}
