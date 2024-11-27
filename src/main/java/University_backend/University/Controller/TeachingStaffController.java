package University_backend.University.Controller;


import University_backend.University.Entity.TeachingStaff;
import University_backend.University.Service.TeachingStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teaching-staff")
@CrossOrigin("*")
public class TeachingStaffController {

    @Autowired
    private TeachingStaffService teachingStaffService;

    @PostMapping("add")
    public ResponseEntity<TeachingStaff> addTeachingStaff(@RequestBody TeachingStaff teachingStaff) {
        TeachingStaff savedStaff = teachingStaffService.addTeachingStaff(teachingStaff);
        return ResponseEntity.ok(savedStaff);
    }

    @GetMapping("all")
    public ResponseEntity<List<TeachingStaff>> getAllTeachingStaff() {
        List<TeachingStaff> staffList = teachingStaffService.getAllTeachingStaff();
        return ResponseEntity.ok(staffList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachingStaff> getTeachingStaffById(@PathVariable Long id) {
        TeachingStaff staff = teachingStaffService.getTeachingStaffById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return ResponseEntity.ok(staff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachingStaff> updateTeachingStaff(
            @PathVariable Long id, @RequestBody TeachingStaff teachingStaffDetails) {
        TeachingStaff updatedStaff = teachingStaffService.updateTeachingStaff(id, teachingStaffDetails);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingStaff(@PathVariable Long id) {
        teachingStaffService.deleteTeachingStaff(id);
        return ResponseEntity.noContent().build();
    }
}
