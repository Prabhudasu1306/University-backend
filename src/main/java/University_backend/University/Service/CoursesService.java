package University_backend.University.Service;

import University_backend.University.Entity.Courses;
import University_backend.University.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;


    public Courses addCourse(Courses course) {
        return coursesRepository.save(course);
    }
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Optional<Courses> getCourseById(Long id) {
        return coursesRepository.findById(id);
    }


    public Courses updateCourse(Long id, Courses updatedCourse) {
        Optional<Courses> existingCourse = coursesRepository.findById(id);
        if (existingCourse.isPresent()) {
            Courses course = existingCourse.get();
            course.setName(updatedCourse.getName());
            course.setDuration(updatedCourse.getDuration());
            return coursesRepository.save(course);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    public void deleteCourse(Long id) {
        coursesRepository.deleteById(id);
    }
}
