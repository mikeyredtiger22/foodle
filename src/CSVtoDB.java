/**
 * Created by Michael P-F on 05-Feb-16.
 *
 * Takes .cvs file(s) and converts to my sql database
 * saves to jamies 'connection'
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSVtoDB{

    private static final String createFoodTable = "create table Food ( "
            + "thing VARCHAR(100) , name VARCHAR(100), price VARCHAR(100), " //  id INT PRIMARY KEY
            + "   location VARCHAR(100))";

    public static Connection getConnection() throws Exception {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost/foodle";
        String username = "foodle";
        String password = "foodle";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(createFoodTable);

            //_____________________________________________________________________________

            stmt.executeUpdate("insert into Food"+
                    "1,2,3,4");

            stmt.executeUpdate("insert into Food"+
                    "Jamies, gilfriend, loves, jamie");


            //_____________________________

            /*
            stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(100, 'A')");
            stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(200, 'B')");
            System.out.println("CreateEmployeeTableMySQL: main(): table created.");
            */
        } catch (ClassNotFoundException e) {
            System.out.println("error: failed to load MySQL driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("error: failed to create a connection object.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("other error:");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addFood(String id, String food, String price, String location){

    }


}