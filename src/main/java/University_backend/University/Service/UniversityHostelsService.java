package University_backend.University.Service;

import University_backend.University.Entity.UniversityHostels;
import University_backend.University.Repository.UniversityHostelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityHostelsService {

    @Autowired
    private UniversityHostelsRepository universityHostelsRepository;

    public UniversityHostelsService(UniversityHostelsRepository universityHostelsRepository) {
        this.universityHostelsRepository = universityHostelsRepository;
    }

    public List<UniversityHostels> getAllHostels() {
        return universityHostelsRepository.findAll();
    }

    public Optional<UniversityHostels> getHostelById(Long id) {
        return universityHostelsRepository.findById(id);
    }

    public UniversityHostels saveHostel(UniversityHostels hostel) {
        return universityHostelsRepository.save(hostel);
    }

    public UniversityHostels updateHostel(Long id, UniversityHostels updatedHostel) {
        return universityHostelsRepository.findById(id)
                .map(hostel -> {
                    hostel.setFloor(updatedHostel.getFloor());
                    hostel.setRoomNo(updatedHostel.getRoomNo());
                    hostel.setBedNo(updatedHostel.getBedNo());
                    return universityHostelsRepository.save(hostel);
                }).orElse(null);
    }

    public void deleteHostel(Long id) {
        universityHostelsRepository.deleteById(id);
    }
}
