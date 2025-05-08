package University_backend.University.Service;

import University_backend.University.Entity.PlacementDrive;
import University_backend.University.Repository.PlacementDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementDriveService {

    @Autowired
    private PlacementDriveRepository repository;

    public PlacementDrive addDrive(PlacementDrive drive) {
        return repository.save(drive);
    }

    public List<PlacementDrive> getAllDrives() {
        return repository.findAll();
    }

    public Optional<PlacementDrive> getDriveById(Long id) {
        return repository.findById(id);
    }

    public PlacementDrive updateDrive(Long id, PlacementDrive updatedDrive) {
        return repository.findById(id).map(drive -> {
            drive.setCompanyName(updatedDrive.getCompanyName());
            drive.setOfferedCTC(updatedDrive.getOfferedCTC());
            drive.setEligible(updatedDrive.getEligible());
            drive.setDate(updatedDrive.getDate());
            return repository.save(drive);
        }).orElse(null);
    }

    public void deleteDrive(Long id) {
        repository.deleteById(id);
    }
}
