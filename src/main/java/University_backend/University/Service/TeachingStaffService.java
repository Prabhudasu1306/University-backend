package University_backend.University.Service;
import University_backend.University.Entity.TeachingStaff;
import University_backend.University.Repository.TeacherStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TeachingStaffService {

    @Autowired
    private TeacherStaffRepository teachingStaffRepository;

    public TeachingStaff addTeachingStaff(TeachingStaff teachingStaff) {
        return teachingStaffRepository.save(teachingStaff);
    }

    public List<TeachingStaff> getAllTeachingStaff() {
        return teachingStaffRepository.findAll();
    }

    public Optional<TeachingStaff> getTeachingStaffById(Long id) {
        return teachingStaffRepository.findById(id);
    }

    public TeachingStaff updateTeachingStaff(Long id, TeachingStaff teachingStaffDetails) {
        TeachingStaff existingStaff = teachingStaffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        existingStaff.setFirstName(teachingStaffDetails.getFirstName());
        existingStaff.setLastName(teachingStaffDetails.getLastName());
        existingStaff.setEmail(teachingStaffDetails.getEmail());
        existingStaff.setPhoneNumber(teachingStaffDetails.getPhoneNumber());
        existingStaff.setDepartment(teachingStaffDetails.getDepartment());
        existingStaff.setSpecialization(teachingStaffDetails.getSpecialization());
        existingStaff.setDesignation(teachingStaffDetails.getDesignation());
        existingStaff.setDateOfJoining(teachingStaffDetails.getDateOfJoining());
        existingStaff.setHighestQualification(teachingStaffDetails.getHighestQualification());
        existingStaff.setExperience(teachingStaffDetails.getExperience());
        existingStaff.setSalary(teachingStaffDetails.getSalary());
        return teachingStaffRepository.save(existingStaff);
    }

    public void deleteTeachingStaff(Long id) {
        teachingStaffRepository.deleteById(id);
    }

    public List<TeachingStaff> getStaffByDepartment(String department) {
        return teachingStaffRepository.findByDepartment(department);
    }
}
