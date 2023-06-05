package backend.Medicines;

import backend.Domain.Medicine;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Medicines.MedicineRequests.CreateMedicineRequest;
import backend.Medicines.MedicineRequests.GetAllMedicineRequest;
import backend.Medicines.Models.MedicineDetails;
import backend.Repositories.MedicineRepository;
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

    public void handle(CreateMedicineRequest request) {
        Medicine medicine = new Medicine(request.getName());
        medicineRepository.save(medicine);
    }
}
