package University_backend.University.Service;

import University_backend.University.Entity.Enrollment;
import University_backend.University.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        Enrollment existing = enrollmentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedEnrollment.getName());
            existing.setCourse(updatedEnrollment.getCourse());
            existing.setDuration(updatedEnrollment.getDuration());
            existing.setFee(updatedEnrollment.getFee());
            return enrollmentRepository.save(existing);
        }
        return null;
    }
}
