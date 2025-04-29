package University_backend.University.Controller;

import University_backend.University.Entity.Staff;
import University_backend.University.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.addStaff(staff));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.updateStaff(id, staff));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaffById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
        return ResponseEntity.ok("Staff deleted successfully.");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStaff() {
        staffService.deleteAllStaff();
        return ResponseEntity.ok("All staff records deleted successfully.");
    }
}
