/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentDBPack;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;
/**
 *
 * @author TUFGAMING
 */
public class StudentDBTest {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        /*String driver = "com.mysql.cj.jdbc.Driver";
        //String url="jdbc:mysql://localhost:3306/employee?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";*/
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student stu1 = new Student(1,"John",3.5);
        Student stu2 = new Student(2,"Marry",3.0);
        StudentTable.insertStudent(dbHandler, stu1);
        StudentTable.insertStudent(dbHandler, stu2);
        //Employee emp = EmployeeTable.findEmployeeById(dbHandler, 1);
        //emp.setName("Jack");
        //emp.setSalary(98765);
        //EmployeeTable.updateEmployee(dbHandler, emp);
        //EmployeeTable.removeEmployee(dbHandler, emp);
        //ArrayList<Employee> employeeList = EmployeeTable.findEmployeeByName(dbHandler, "Marry");
        ArrayList<Student> stuList = StudentTable.findAllStudent(dbHandler);
        if (stuList != null) {
            printAllEmployee(stuList);
        }
        dbHandler.closeConnection();
    }
    
    public static void printAllEmployee(ArrayList<Student> stuList) {
        for(int i = 0; i < stuList.size(); i++) {
            System.out.print(stuList.get(i).getId() + " ");
            System.out.print(stuList.get(i).getName() + " ");
            System.out.println(stuList.get(i).getGpa() + " ");
        }
        
    }
}
