package backend.Orders.Requests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllOrdersRequest extends AbstractRequest {
    @NotBlank
    private int sectionId;
}
