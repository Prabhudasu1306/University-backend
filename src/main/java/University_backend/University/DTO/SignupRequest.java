package University_backend.University.DTO;

import lombok.Data;

@Data
public class SignupRequest {

    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role; // ADMIN or STUDENT
    private String collegeCode; // Only for Admin

    // Getter for username. Assuming username is the email
    public String getUsername() {
        return this.email; // Returning email as username
    }
}
