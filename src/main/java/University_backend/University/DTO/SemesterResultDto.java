package University_backend.University.DTO;

import University_backend.University.DTO.SubjectResultDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterResultDto {
    private String semester;
    private List<SubjectResultDto> subjectResults;
}