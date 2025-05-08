package University_backend.University.Service;

import University_backend.University.Entity.Placement;
import University_backend.University.Repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public Placement addPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    public Optional<Placement> getPlacementById(Long id) {
        return placementRepository.findById(id);
    }

    public Placement updatePlacement(Long id, Placement updatedPlacement) {
        return placementRepository.findById(id).map(placement -> {
            placement.setFirstName(updatedPlacement.getFirstName());
            placement.setLastName(updatedPlacement.getLastName());
            placement.setEmail(updatedPlacement.getEmail());
            placement.setCompany(updatedPlacement.getCompany());
            placement.setDate(updatedPlacement.getDate());
            return placementRepository.save(placement);
        }).orElse(null);
    }

    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}
