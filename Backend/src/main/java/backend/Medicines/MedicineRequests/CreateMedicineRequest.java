package backend.Medicines.MedicineRequests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMedicineRequest extends AbstractRequest {
    @NotBlank
    private String name;
}
