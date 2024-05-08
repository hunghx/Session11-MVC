package ra.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.mvc.model.Student;
import ra.mvc.service.IStudentService;

@Controller
@RequestMapping({"","/student"})
public class StudentControllerMvc {
    @Autowired
    private IStudentService studentService;
    @GetMapping({"","/list"}) // đuờng dẫn mapping
    public String list(Model model){ // model là người vận chuyển dữ liệu
        // hiển thị danh sách
        model.addAttribute("students",studentService.findAll());
        return "list"; // trả về view name
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    @GetMapping("/edit")
    public String edit(){ // model là người vận chuyển dữ liệu
        return "edit";
    }
    @GetMapping("/delete")
    public String delete(){
        return "list";
    }
    @PostMapping("/add") // xử lí form thêm mới
    public String doAdd(@ModelAttribute Student student){ // mspping theo tên thuộc tính
        studentService.save(student);
        return "redirect:/student/list";
    }
    @PostMapping("/update") // xử lí form thêm mới
    public String doUpdate(@ModelAttribute Student student){ // mspping theo tên thuộc tính
        studentService.save(student);
        return "redirect:/student/list";
    }
}
