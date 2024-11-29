package University_backend.University.Controller;

import University_backend.University.Entity.NonTeaching;
import University_backend.University.Service.NonTeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/NonTeaching")
public class NonTeachingController {

    private final NonTeachingService nonTeachingService;

    @Autowired
    public NonTeachingController(NonTeachingService nonTeachingService) {
        this.nonTeachingService = nonTeachingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<NonTeaching>> getAllNonTeaching() {
        List<NonTeaching> nonTeachingList = nonTeachingService.getAllNonTeachingStaff();
        return new ResponseEntity<>(nonTeachingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NonTeaching> getNonTeachingById(@PathVariable Long id) {
        Optional<NonTeaching> nonTeaching = nonTeachingService.getNonTeachingById(id);
        return nonTeaching.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/add")
    public ResponseEntity<NonTeaching> addNonTeaching(@RequestBody NonTeaching nonTeaching) {
        NonTeaching savedNonTeaching = nonTeachingService.saveNonTeaching(nonTeaching);
        return new ResponseEntity<>(savedNonTeaching, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NonTeaching> updateNonTeaching(@PathVariable Long id, @RequestBody NonTeaching nonTeachingDetails) {
        Optional<NonTeaching> existingNonTeaching = nonTeachingService.getNonTeachingById(id);

        if (existingNonTeaching.isPresent()) {
            NonTeaching nonTeaching = existingNonTeaching.get();
            nonTeaching.setName(nonTeachingDetails.getName());
            nonTeaching.setDesignation(nonTeachingDetails.getDesignation());
            nonTeaching.setDepartment(nonTeachingDetails.getDepartment());
            nonTeaching.setSalary(nonTeachingDetails.getSalary());
            nonTeaching.setContactNumber(nonTeachingDetails.getContactNumber());
            nonTeaching.setExperience(nonTeachingDetails.getExperience());

            NonTeaching updatedNonTeaching = nonTeachingService.saveNonTeaching(nonTeaching);
            return new ResponseEntity<>(updatedNonTeaching, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNonTeaching(@PathVariable Long id) {
        nonTeachingService.deleteNonTeaching(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
