package University_backend.University.Controller;

import University_backend.University.Entity.Student;
import University_backend.University.Service.StudentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody Map<String, Object> data) {
        try {
            // Validate amount
            if (data.get("amount") == null || !(data.get("amount") instanceof Integer) || (int) data.get("amount") <= 0) {
                return ResponseEntity.badRequest().body("Invalid amount provided");
            }

            RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

            int amount = (int) data.get("amount");

            // Generate unique receipt ID
            String receiptId = "order_rcptid_" + System.currentTimeMillis();

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100);  // Amount in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", receiptId);  // Unique receipt ID

            // Create an order with Razorpay
            Order order = client.orders.create(orderRequest);
            return ResponseEntity.ok(order.toString());  // Return order details

        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace for debugging
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new student
    @PostMapping("add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Update a student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        if (studentService.getStudentById(id).isPresent()) {
            student.setId(id);
            return ResponseEntity.ok(studentService.saveStudent(student));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.getStudentById(id).isPresent()) {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get all students
    @GetMapping("all")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        Iterable<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
