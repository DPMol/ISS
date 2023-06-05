package backend.Medicines;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Medicines.MedicineRequests.CreateMedicineRequest;
import backend.Medicines.MedicineRequests.GetAllMedicineRequest;
import backend.Medicines.Models.MedicineDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@AllArgsConstructor
public class MedicineController extends AbstractController {
    private MedicineService medicineService;

    @CrossOrigin
    @GetMapping("/getall")
    public List<MedicineDetails> getAllMedicine(@Valid GetAllMedicineRequest request){
        return medicineService.handle(request);
    }

    @CrossOrigin
    @PostMapping("/create")
    public void createMedicine(@Valid @RequestBody CreateMedicineRequest request){
        medicineService.handle(request);
    }
}
