package University_backend.University.Service;

import University_backend.University.Entity.PlacedStudents;
import University_backend.University.Repository.PlacedStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacedStudentsService {

    @Autowired
    private PlacedStudentsRepository repository;

    public PlacedStudents savePlacedStudent(PlacedStudents student) {
        return repository.save(student);
    }

    public List<PlacedStudents> getAllPlacedStudents() {
        return repository.findAll();
    }

    public PlacedStudents getPlacedStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PlacedStudents updatePlacedStudent(Long id, PlacedStudents student) {
        Optional<PlacedStudents> existing = repository.findById(id);
        if (existing.isPresent()) {
            PlacedStudents updated = existing.get();
            updated.setName(student.getName());
            updated.setCompany(student.getCompany());
            updated.setCtc(student.getCtc());
            updated.setPlacedYear(student.getPlacedYear());
            updated.setBranch(student.getBranch());
            return repository.save(updated);
        }
        return null;
    }

    public void deletePlacedStudent(Long id) {
        repository.deleteById(id);
    }
}
