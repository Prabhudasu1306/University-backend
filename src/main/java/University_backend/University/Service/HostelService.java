package University_backend.University.Service;

import University_backend.University.Entity.Hostel;
import University_backend.University.Repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    public Hostel addHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    public Optional<Hostel> getHostelById(Long id) {
        return hostelRepository.findById(id);
    }

    public Hostel updateHostel(Long id, Hostel updatedHostel) {
        return hostelRepository.findById(id).map(hostel -> {
            hostel.setFirstName(updatedHostel.getFirstName());
            hostel.setLastName(updatedHostel.getLastName());
            hostel.setBranch(updatedHostel.getBranch());
            hostel.setRoomNo(updatedHostel.getRoomNo());
            hostel.setAddress(updatedHostel.getAddress());
            return hostelRepository.save(hostel);
        }).orElse(null);
    }

    public void deleteHostel(Long id) {
        hostelRepository.deleteById(id);
    }
}
