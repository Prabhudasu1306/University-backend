package University_backend.University.Dto;

import University_backend.University.DTO.SemesterResultDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultsDto {
    private String name;
    private String hallTicketNumber;
    private String year;
    private List<SemesterResultDto> semesterResults;
}