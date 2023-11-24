/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.document.adapter;

import core.contract.domain.Contract;
import org.modelmapper.ModelMapper;
import repository.document.ContractDocumentRepository;
import repository.document.dao.ContractDocumentDao;
import repository.document.domain.ContractDocument;

/**
 *
 * @author fraviola
 */
public class ContractDocumentAdapter implements ContractDocumentRepository {

    private final ContractDocumentDao contractDocumentDao;
    private final ModelMapper modelMapper;

    public ContractDocumentAdapter(ContractDocumentDao contractDocumentDao, ModelMapper modelMapper) {
        this.contractDocumentDao = contractDocumentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Contract saveContract(Contract contract) {
        ContractDocument contractDocument = modelMapper.map(contract, ContractDocument.class);
        return modelMapper.map(contractDocumentDao.save(contractDocument), Contract.class);
    }

}
