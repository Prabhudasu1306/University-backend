package University_backend.University.Controller;

import University_backend.University.Entity.Courses;
import University_backend.University.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
    @PostMapping("/add")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
        Courses savedCourse = coursesService.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = coursesService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        return coursesService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable Long id, @RequestBody Courses updatedCourse) {
        try {
            Courses course = coursesService.updateCourse(id, updatedCourse);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
