package University_backend.University.Controller;

import University_backend.University.Entity.Hostel;
import University_backend.University.Service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hostels")
@CrossOrigin(origins = "http://localhost:3000")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("add")
    public Hostel createHostel(@RequestBody Hostel hostel) {
        return hostelService.addHostel(hostel);
    }

    @GetMapping("all")
    public List<Hostel> getAllHostels() {
        return hostelService.getAllHostels();
    }

    @GetMapping("/{id}")
    public Optional<Hostel> getHostelById(@PathVariable Long id) {
        return hostelService.getHostelById(id);
    }

    @PutMapping("update/{id}")
    public Hostel updateHostel(@PathVariable Long id, @RequestBody Hostel hostel) {
        return hostelService.updateHostel(id, hostel);
    }

    @DeleteMapping("delete/{id}")
    public void deleteHostel(@PathVariable Long id) {
        hostelService.deleteHostel(id);
    }
}
