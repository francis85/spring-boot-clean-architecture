/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.document.domain;

import core.product.domain.Product;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author fraviola
 */
@Document(collation = "contract")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDocument {

    @Id
    private String id;
    private String userId;
    private Product product;
}
