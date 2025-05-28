package University_backend.University.Controller;

import University_backend.University.Entity.UniversityHostels;
import University_backend.University.Service.UniversityHostelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universityHostels")
@CrossOrigin(origins = "http://localhost:3000")
public class UniversityHostelsController {

    @Autowired
    private UniversityHostelsService universityHostelsService;


    @GetMapping("all")
    public List<UniversityHostels> getAllHostels() {
        return universityHostelsService.getAllHostels();
    }

    // Get a hostel by ID
    @GetMapping("/{id}")
    public ResponseEntity<UniversityHostels> getHostelById(@PathVariable Long id) {
        Optional<UniversityHostels> hostel = universityHostelsService.getHostelById(id);
        return hostel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new hostel
    @PostMapping
    public UniversityHostels addHostel(@RequestBody UniversityHostels hostel) {
        return universityHostelsService.saveHostel(hostel);
    }

    // Update hostel by ID
    @PutMapping("/{id}")
    public ResponseEntity<UniversityHostels> updateHostel(@PathVariable Long id, @RequestBody UniversityHostels hostelDetails) {
        UniversityHostels updated = universityHostelsService.updateHostel(id, hostelDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a hostel by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostel(@PathVariable Long id) {
        universityHostelsService.deleteHostel(id);
        return ResponseEntity.noContent().build();
    }
}
