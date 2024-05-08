package ra.mvc.model;

import lombok.*;

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
    private Date dob ;
    private String address;

}
