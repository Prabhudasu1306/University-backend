package University_backend.University.Service;

import University_backend.University.DTO.SemesterResultDto;
import University_backend.University.DTO.SubjectResultDto;
import University_backend.University.Dto.ResultsDto;

import University_backend.University.Entity.Results;
import University_backend.University.Entity.SemesterResult;
import University_backend.University.Entity.SubjectResult;
import University_backend.University.Repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultsService {

    @Autowired
    private ResultsRepository resultsRepository;

    public Results saveResults(Results results) {
        // Ensure bidirectional relationships are set before saving
        if (results.getSemesterResults() != null) {
            results.getSemesterResults().forEach(sem -> {
                sem.setResults(results); // Set parent Results
                if (sem.getSubjectResults() != null) {
                    sem.getSubjectResults().forEach(sub -> sub.setSemesterResult(sem)); // Set parent SemesterResult
                }
            });
        }
        return resultsRepository.save(results);
    }

    public Optional<ResultsDto> getResultsByHallTicketAndYearAndSemester(String hallTicketNumber, String year, String semester) {
        // Use the corrected repository method name
        Optional<Results> optionalResults = resultsRepository.findByHallTicketNumberAndYear(hallTicketNumber, year);

        if (optionalResults.isPresent()) {
            Results resultsEntity = optionalResults.get();
            List<SemesterResult> filteredSemesterResults;

            if (semester != null && !semester.trim().isEmpty()) {
                // Filter by semester if provided
                filteredSemesterResults = resultsEntity.getSemesterResults().stream()
                        .filter(sem -> sem.getSemester().equalsIgnoreCase(semester.trim()))
                        .collect(Collectors.toList());
            } else {
                // If no semester is provided, return all semesters
                filteredSemesterResults = resultsEntity.getSemesterResults();
            }

            // If no semester results found after filtering, return empty
            if (filteredSemesterResults.isEmpty()) {
                return Optional.empty();
            }

            // Map entities to DTOs
            List<SemesterResultDto> semesterResultDtos = filteredSemesterResults.stream()
                    .map(this::convertToSemesterResultDto)
                    .collect(Collectors.toList());

            ResultsDto resultsDto = new ResultsDto(
                    resultsEntity.getName(),
                    resultsEntity.getHallTicketNumber(),
                    resultsEntity.getYear(), // Include year from entity
                    semesterResultDtos
            );
            return Optional.of(resultsDto);

        }
        return Optional.empty(); // No Results entity found
    }

    // Helper methods to convert entities to DTOs
    private SemesterResultDto convertToSemesterResultDto(SemesterResult semesterResult) {
        List<SubjectResultDto> subjectResultDtos = semesterResult.getSubjectResults().stream()
                .map(this::convertToSubjectResultDto)
                .collect(Collectors.toList());
        return new SemesterResultDto(semesterResult.getSemester(), subjectResultDtos);
    }

    private SubjectResultDto convertToSubjectResultDto(SubjectResult subjectResult) {
        return new SubjectResultDto(subjectResult.getSubjectName(), subjectResult.getMarksOrGrade());
    }
}