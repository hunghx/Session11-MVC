package ra.mvc.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder // tùy biến tạo đối tương
public class Student {
    private Integer id;
    private String name;
    private Boolean sex;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob ;
    private String address;

}
