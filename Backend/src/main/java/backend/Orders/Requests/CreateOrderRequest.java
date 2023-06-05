package backend.Orders.Requests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest extends AbstractRequest {
    @NotNull
    private int medicineId;
    @NotBlank
    private String username;
    @NotNull
    @Min(1)
    private int quantity;
}
