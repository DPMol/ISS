package backend.Medicines;

import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Medicines.MedicineRequests.GetAllMedicineRequest;
import backend.Medicines.Models.MedicineDetails;
import backend.Repositories.MedicineRepository;
import backend.Users.Models.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineService extends AbstractService {
    private MedicineRepository medicineRepository;

    public List<MedicineDetails> handle(GetAllMedicineRequest request) {
        return MedicineDetails.FromMedicine(medicineRepository.findAll());
    }
}
