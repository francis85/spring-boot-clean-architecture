/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.web;

import controller.ContractController;
import core.contract.domain.input.ContractInput;
import core.contract.domain.output.ContractOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author fraviola
 */
@RestController
@RequestMapping("/")
public class SpringController {
    
    @Autowired
    private ContractController contractController;

    @PostMapping(path = "/contract")
    public ResponseEntity<ContractOutput> generateContract(@RequestBody ContractInput contractInput) {
        ContractOutput contractOutput = contractController.generateContract(contractInput);
        return new ResponseEntity<>(contractOutput, HttpStatus.CREATED);
    }

    @GetMapping(path = "/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
    
}
