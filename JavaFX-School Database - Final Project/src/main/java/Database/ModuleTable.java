package Database;

import Application.Class_Group;
import Application.Module;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModuleTable extends Database {
    private Connection myConn;
    public ModuleTable() {
        super();
        myConn = super.makeConnection();

    }
    public void Insert(String moduleCode, String moduleName) {
        try {
            // Get connection

            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "INSERT INTO modules(moduleCode, moduleName) VALUES('" + moduleCode + "','"+moduleName+"');";

            myStmt.executeUpdate(sql);

            System.out.println("Insert completed");
        }
        catch (Exception e) {
            System.out.println("ERROR in ModuleTable in Insert method\n" + e);
        }
    }

    public void Delete(String moduleCode) {
        try{
            Statement myStmt = myConn.createStatement();

            // Execute SQL Query
            String sql = "DELETE FROM modules WHERE moduleCode='" + moduleCode + "'";

            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("Rows affected " + rowsAffected);
        }
        catch (Exception e) {
            System.out.println("ERROR in ModuleTable in Delete method\n" + e);
        }

    }

    public void Display() {
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from modules");
            System.out.println("Module Code " + "Module Name");
            while (myRes.next()) {
                System.out.println(myRes.getString("moduleCode") + " " + myRes.getString("moduleName"));
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in ModuleTable in Display method\n" + e);
        }
    }
    public ArrayList<Module> returnList() {
        ArrayList<Module> modules = new ArrayList<>();
        try {
            Statement myStat = myConn.createStatement();

            ResultSet myRes = myStat.executeQuery("select * from modules");
            while (myRes.next()) {
                Module m = new Module();
                m.setModuleCode(myRes.getString("moduleCode"));
                m.setName(myRes.getString("moduleName"));
                modules.add(m);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in ModuleTable in ReturnList method\n" + e);
        }
        return modules;
    }
}
