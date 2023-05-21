package backend.Medicines.Models;

import backend.Domain.Medicine;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MedicineDetails {
    private int id;
    private String name;

    public static MedicineDetails FromMedicine(Medicine medicine){
        return new MedicineDetails(medicine.getId(), medicine.getName());
    }

    public static List<MedicineDetails> FromMedicine(List<Medicine> medicineList){
        return medicineList.stream().map(MedicineDetails::FromMedicine).toList();
    }
}
