package University_backend.University.Service;

import University_backend.University.Entity.Staff;
import University_backend.University.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));

        existingStaff.setFirstName(updatedStaff.getFirstName());
        existingStaff.setLastName(updatedStaff.getLastName());
        existingStaff.setQualification(updatedStaff.getQualification());
        existingStaff.setExperience(updatedStaff.getExperience());
        existingStaff.setSubject(updatedStaff.getSubject());

        return staffRepository.save(existingStaff);
    }

    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }

    public void deleteAllStaff() {
        staffRepository.deleteAll();
    }
}
