package ra.mvc.controller;

import lombok.SneakyThrows;
import ra.mvc.model.Student;
import ra.mvc.service.IStudentService;
import ra.mvc.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private static  final IStudentService studentService  = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!= null){
            switch (action){
                case "list":
                    request.setAttribute("students",studentService.findAll());
                    request.getRequestDispatcher("/views/list.jsp").forward(request,response);
                    break;
                case "add":
                    request.getRequestDispatcher("/views/add.jsp").forward(request,response);
                    // điều hướng trang
                    break;
                case "edit":
                    // hiển thị dữ liệu cần sửa
                    break;
                case "delete":
                    // xoa
                    break;
            }
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action!= null){
            switch (action){
                case "add":
                    Student studentRequest = Student.builder()
                            .name(request.getParameter("name"))
                            .address(request.getParameter("address"))
                            .phone(request.getParameter("phone"))
                            .sex(Boolean.valueOf(request.getParameter("sex")))
                            .dob(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")))
                            .build();
                    studentService.save(studentRequest);
                    response.sendRedirect("/student?action=list");
                    break;
                case "update":

                    break;

            }
        }
    }
}
 