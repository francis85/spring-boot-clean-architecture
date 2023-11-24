package core.contract.domain.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ContractInput {

    private String userId;
    private String productId;
}
