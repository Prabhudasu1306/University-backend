package University_backend.University.Controller;

import University_backend.University.Entity.Drive;
import University_backend.University.Service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drives")
@CrossOrigin(origins = "http://localhost:3000")
public class DriveController {

    @Autowired
    private DriveService driveService;


    @PostMapping("/add")
    public Drive saveDrive(@RequestBody Drive drive) {
        return driveService.saveDriver(drive);
    }


    @GetMapping("/all")
    public List<Drive> getAllDrives() {
        return driveService.getAllDrivers();
    }


    @GetMapping("/{id}")
    public Drive getDriveById(@PathVariable Long id) {
        return driveService.getDriveById(id);
    }


    @PutMapping("/{id}")
    public Drive updateDrive(@PathVariable Long id, @RequestBody Drive drive) {
        return driveService.updateDriver(id, drive);
    }


    @DeleteMapping("/{id}")
    public String deleteDrive(@PathVariable Long id) {
        driveService.deleteDriver(id);
        return "Drive with ID " + id + " has been deleted.";
    }
}
