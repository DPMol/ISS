package backend.Medicines;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Medicines.MedicineRequests.GetAllMedicineRequest;
import backend.Medicines.Models.MedicineDetails;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.GetUserDetailsRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@AllArgsConstructor
public class MedicineController extends AbstractController {
    private MedicineService medicineService;

    @GetMapping("/getall")
    public List<MedicineDetails> getAllMedicine(@Valid @RequestBody GetAllMedicineRequest request){
        return medicineService.handle(request);
    }
}
