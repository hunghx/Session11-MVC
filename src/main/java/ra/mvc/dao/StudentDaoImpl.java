package ra.mvc.dao;

import ra.mvc.model.Student;
import ra.mvc.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Student> list = new ArrayList<>();
        try {
            CallableStatement call = conn.prepareCall("select * from student");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Student student = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .dob(rs.getDate("dob"))
                        .phone(rs.getString("phone"))
                        .sex(rs.getBoolean("sex"))
                        .address(rs.getString("address"))
                        .build();
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Student findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Student student = null;
        try {
            CallableStatement call = conn.prepareCall("select * from student where id = ?");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                student = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .dob(rs.getDate("dob"))
                        .phone(rs.getString("phone"))
                        .sex(rs.getBoolean("sex"))
                        .address(rs.getString("address"))
                        .build();
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void save(Student student) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement call = null;
        try {
           if (student.getId()==null){
               // thêm mới
               call = conn.prepareCall("Insert  into student(name,dob,sex,phone,address) values (?,?,?,?,?)");
           }else {
               // thêm mới
               call = conn.prepareCall("update student set name=?,dob = ?,sex =?,phone= ?,address=?  where  id =?");
               call.setInt(6,student.getId());
           }
            call.setString(1,student.getName());
            call.setDate(2,new java.sql.Date(student.getDob().getTime()));
            call.setBoolean(3,student.getSex());
            call.setString(4,student.getPhone());
            call.setString(5,student.getAddress());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement call = conn.prepareCall("delete  from student where  id = ?");
            call.setInt(1,id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
