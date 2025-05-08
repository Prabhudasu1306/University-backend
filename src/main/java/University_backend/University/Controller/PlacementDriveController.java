package University_backend.University.Controller;

import University_backend.University.Entity.PlacementDrive;
import University_backend.University.Service.PlacementDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/placement-drives")
@CrossOrigin(origins = "http://localhost:3000")
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService service;

    @PostMapping("add")
    public PlacementDrive createDrive(@RequestBody PlacementDrive drive) {
        return service.addDrive(drive);
    }

    @GetMapping("all")
    public List<PlacementDrive> getAllDrives() {
        return service.getAllDrives();
    }

    @GetMapping("/{id}")
    public Optional<PlacementDrive> getDriveById(@PathVariable Long id) {
        return service.getDriveById(id);
    }

    @PutMapping("update/{id}")
    public PlacementDrive updateDrive(@PathVariable Long id, @RequestBody PlacementDrive drive) {
        return service.updateDrive(id, drive);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDrive(@PathVariable Long id) {
        service.deleteDrive(id);
    }
}
