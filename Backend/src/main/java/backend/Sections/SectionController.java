package backend.Sections;

import backend.Domain.Section;
import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Medicines.MedicineRequests.GetAllMedicineRequest;
import backend.Medicines.Models.MedicineDetails;
import backend.Sections.SectionRequests.GetAllSectionsRequest;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.DeleteUserRequest;
import backend.Users.UserRequests.GetUserDetailsRequest;
import backend.Users.UserRequests.LoginUserRequest;
import backend.Users.UserRequests.RegisterUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
@AllArgsConstructor
public class SectionController extends AbstractController {
    SectionService sectionService;

    @CrossOrigin
    @GetMapping("/getall")
    public List<Section> getAllMedicine(@Valid GetAllSectionsRequest request){
        return sectionService.handle(request);
    }
}
