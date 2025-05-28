package University_backend.University.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResultDto {
    private String subjectName;
    private String marksOrGrade;
}