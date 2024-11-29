package University_backend.University.Service;

import University_backend.University.Entity.NonTeaching;
import University_backend.University.Repository.NonTeachingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NonTeachingService {

    private final NonTeachingRepository nonTeachingRepository;

    @Autowired
    public NonTeachingService(NonTeachingRepository nonTeachingRepository) {
        this.nonTeachingRepository = nonTeachingRepository;
    }

    public List<NonTeaching> getAllNonTeachingStaff() {
        return nonTeachingRepository.findAll();
    }


    public NonTeaching saveNonTeaching(NonTeaching nonTeaching) {
        return nonTeachingRepository.save(nonTeaching);
    }


    public Optional<NonTeaching> getNonTeachingById(Long id) {
        return nonTeachingRepository.findById(id);
    }

    public void deleteNonTeaching(Long id) {
        nonTeachingRepository.deleteById(id);
    }

    public NonTeaching updateNonTeaching(Long id, NonTeaching nonTeachingDetails) {
        Optional<NonTeaching> existingNonTeaching = nonTeachingRepository.findById(id);

        if (existingNonTeaching.isPresent()) {
            NonTeaching nonTeaching = existingNonTeaching.get();
            nonTeaching.setName(nonTeachingDetails.getName());
            nonTeaching.setDesignation(nonTeachingDetails.getDesignation());
            nonTeaching.setDepartment(nonTeachingDetails.getDepartment());
            nonTeaching.setSalary(nonTeachingDetails.getSalary());
            nonTeaching.setContactNumber(nonTeachingDetails.getContactNumber());
            nonTeaching.setExperience(nonTeachingDetails.getExperience());

            return nonTeachingRepository.save(nonTeaching);
        } else {

            return null;
        }
    }
}
