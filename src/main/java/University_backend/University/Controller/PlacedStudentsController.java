package University_backend.University.Controller;

import University_backend.University.Entity.PlacedStudents;
import University_backend.University.Service.PlacedStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placed-students")
@CrossOrigin(origins = "http://localhost:3000")
public class PlacedStudentsController {

    @Autowired
    private PlacedStudentsService service;

    @PostMapping("add")
    public PlacedStudents saveStudent(@RequestBody PlacedStudents student) {
        return service.savePlacedStudent(student);
    }

    @GetMapping("all")
    public List<PlacedStudents> getAllStudents() {
        return service.getAllPlacedStudents();
    }

    @GetMapping("/{id}")
    public PlacedStudents getStudentById(@PathVariable Long id) {
        return service.getPlacedStudentById(id);
    }

    @PutMapping("/{id}")
    public PlacedStudents updateStudent(@PathVariable Long id, @RequestBody PlacedStudents student) {
        return service.updatePlacedStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deletePlacedStudent(id);
    }
}
