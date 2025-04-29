package University_backend.University.Service;

import University_backend.University.Entity.School;
import University_backend.University.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    // Create or Update a school
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    // Get all schools
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    // Get a school by ID
    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    // Delete a school by ID
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
