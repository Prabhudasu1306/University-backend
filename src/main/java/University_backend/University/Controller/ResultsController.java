package University_backend.University.Controller;

import University_backend.University.Dto.ResultsDto;
import University_backend.University.Entity.Results;
import University_backend.University.Service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultsController {

    @Autowired
    private ResultsService resultsService;

    @PostMapping
    public ResponseEntity<String> saveResults(@RequestBody Results results) {
        try {
            Results saved = resultsService.saveResults(results);
            return ResponseEntity.ok("Results saved successfully for: " + saved.getHallTicketNumber());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving results: " + e.getMessage());
        }
    }

    @GetMapping("/{hallTicketNumber}/{year}")
    public ResponseEntity<?> getResultsByHallTicketAndYear(
            @PathVariable String hallTicketNumber,
            @PathVariable String year,
            @RequestParam(required = false) String semester) {
        try {
            System.out.println("Fetching result for HallTicket: " + hallTicketNumber + ", Year: " + year + ", Semester: " + (semester != null ? semester : "All"));
            Optional<ResultsDto> optionalResultsDto = resultsService.getResultsByHallTicketAndYearAndSemester(hallTicketNumber, year, semester);

            if (optionalResultsDto.isPresent()) {
                return ResponseEntity.ok(optionalResultsDto.get());
            } else {
                String errorMessage = "No results found for Hall Ticket: " + hallTicketNumber + " and Year: " + year;
                if (semester != null && !semester.trim().isEmpty()) {
                    errorMessage += " for Semester: " + semester;
                }
                return ResponseEntity.status(404)
                        .body(errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print full stack trace for debugging
            return ResponseEntity.status(500).body("Server error: " + e.getMessage());
        }
    }
}