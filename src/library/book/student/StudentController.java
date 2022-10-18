package library.book.student;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.entities.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdGmail;
    public TableColumn<Student,Integer> tdTelephone;

    public final static String connectionString = "jdbc:mysql://localhost:3306/jp2";
    public final static String user = "root";
    public final static String pwd = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdGmail.setCellValueFactory(new PropertyValueFactory<Student,String>("gmail"));
        tdTelephone.setCellValueFactory(new PropertyValueFactory<Student,Integer>("telephone"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from student";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gmail = rs.getString("gmail");
                int telephone = rs.getInt("telephone");
                Student s = new Student(id, name, gmail, telephone);
                ls.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudent.setItems(ls);
        }

    }

}
