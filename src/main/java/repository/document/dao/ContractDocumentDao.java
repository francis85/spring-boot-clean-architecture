/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.document.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import repository.document.domain.ContractDocument;

/**
 *
 * @author fraviola
 */
@Repository
public interface ContractDocumentDao extends MongoRepository<ContractDocument, String>{
    
    @Override
    ContractDocument save(ContractDocument contractDocument);
}
