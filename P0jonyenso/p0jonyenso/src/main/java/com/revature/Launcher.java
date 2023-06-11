package main.java.com.revature;

import main.java.com.revature.utils.JavalinAppConfig;
import main.java.com.revature.models.Employee;
import main.java.com.revature.daos.EmployeeDAO;
import main.java.com.revature.daos.RoleDAO;
import main.java.com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        /*This is a try-with-resources block
         A resource (in this case, a DB connection) is opened within the parenthesis
         Another benefit is that the resource will close for us when the block completes
         This is helpful for code cleanup and preventing memory leaks*/
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("Connection Failed :(" );
        }


        //calling DAO methods below---------------

        //instantiate a RoleDAO object so we can use its methods
        RoleDAO rDAO = new RoleDAO();

        //getting a Role object by id
        System.out.println(rDAO.getRoleById(2));

        //try to update the role salary for Manager
        System.out.println(rDAO.updateRoleSalary(500000, "Banking Manager"));
        System.out.println(rDAO.getRoleById(1)); //checking if the Manager salary was updated

        //Instantiate an EmployeeDAO object so we can use its methods
        EmployeeDAO eDAO = new EmployeeDAO();

        //insert a new employee (we need to instantiate it first)
        Employee jcole = new Employee("Jermaine","Cole", "jcole@revature.net", 1);

        //run the insert method
        System.out.println(eDAO.insertEmployee(jcole));

        //get all employees
        ArrayList<Employee> employeeList = eDAO.getAllEmployees();

        //use an enhanced for loop to print out each employee
        for(Employee e : employeeList){
            System.out.println(e);
        }
        // We'll create a JavalinAppConfig object, so we can create our app with the proper configuration
        JavalinAppConfig app = new JavalinAppConfig();

        // We'll start the server and allow it to listen on port 7070
        app.start(7070);
    }

}
