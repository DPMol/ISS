package backend.Sections;

import backend.Domain.Section;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Repositories.SectionRepository;
import backend.Sections.SectionRequests.GetAllSectionsRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService extends AbstractService {
    private SectionRepository sectionRepository;

    public List<Section> handle(GetAllSectionsRequest request) {
        return sectionRepository.findAll();
    }
}
