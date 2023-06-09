package backend.Orders.Requests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrdersRequest extends AbstractRequest {
    @NotNull
    private int sectionId;
}
