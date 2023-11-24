/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author fraviola
 */
@Data
@AllArgsConstructor
public class ResourcesNotFoundException extends RuntimeException {

    private Integer code;

    public ResourcesNotFoundException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
