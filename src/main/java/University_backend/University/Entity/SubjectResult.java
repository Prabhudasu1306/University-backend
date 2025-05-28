package University_backend.University.Entity;

import University_backend.University.Entity.SemesterResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SubjectResults")
public class SubjectResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subjectName;
    private String marksOrGrade;

    @ManyToOne
    @JoinColumn(name = "semester_result_id")
    private SemesterResult semesterResult;
}
