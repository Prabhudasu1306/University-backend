package University_backend.University.Controller;

import University_backend.University.Entity.Placement;
import University_backend.University.Service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/placements")
@CrossOrigin(origins = "http://localhost:3000")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping("add")
    public Placement createPlacement(@RequestBody Placement placement) {
        return placementService.addPlacement(placement);
    }

    @GetMapping("all")
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/{id}")
    public Optional<Placement> getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id);
    }

    @PutMapping("update/{id}")
    public Placement updatePlacement(@PathVariable Long id, @RequestBody Placement placement) {
        return placementService.updatePlacement(id, placement);
    }

    @DeleteMapping("/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }
}
