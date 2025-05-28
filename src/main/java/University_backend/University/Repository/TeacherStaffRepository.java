package University_backend.University.Repository;

import University_backend.University.Entity.SubjectResult;
import University_backend.University.Entity.TeachingStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherStaffRepository extends JpaRepository<TeachingStaff,Long> {
    List<TeachingStaff> findByDepartment(String department);

    interface SubjectResultRepository extends JpaRepository<SubjectResult, Long> {
    }
}
