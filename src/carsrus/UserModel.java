package carsrus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                       Class UserModel                           */
/* =============================================================== */
/* Class Description - user object represents a user account for   */ 
/*                     logging into the program.                   */
/* --------------------------------------------------------------- */
/* method findAll() - returns all of the user objects in the       */
/*                    database.                                    */
/* method search() - returns the user objects based on the model   */
/*                   and the make in the database.                 */
/* method insert() - creates a database record of a user object in */
/*                   the database.                                 */
/* method update() - changes a database record of a user object in */
/*                   the database.                                 */
/* method delete() - deletes a database record of a user object in */
/*                   the database.                                 */
/*******************************************************************/
/*******************************************************************/

public class UserModel implements UserService
{    
    /*******************************************************************/
    /*                       Find All Method                           */
    /* =============================================================== */
    /* findAll() - uses a select statement to return all of the users  */
    /*             based their username in the CarsRUs database from   */
    /*             the Users table.                                    */
    /*             Returns a List of User Objects.                     */
    /*******************************************************************/

    public List<User> findAll()
    {
        List<User> result = new ArrayList<User>();

        // Build a SQL SELECT statement
        String query = "SELECT * FROM Users";

        try 
        {
            // Execute query
            ResultSet queryResults = Model.Instance.dbSql.executeQuery(query);

            while( queryResults.next() ) 
            {
                User user = new User( queryResults.getInt(1),
                                                   queryResults.getString(2),
                                                   queryResults.getString(3),
                                                   queryResults.getInt(4)
                                                 );
                result.add(user);	
            }
        }
        catch(SQLException ex) 
        {
            System.out.println("Select failed: " + ex);
        }
        return result;
    }
	
    /*******************************************************************/
    /*                         Search Method                           */
    /* =============================================================== */
    /* search() - uses a select statement to return users based on     */
    /*            their username in the CarsRUs database from the      */
    /*            Users table.                                         */
    /*            Returns a List of User Objects.                      */
    /*******************************************************************/

    public User search(String keyword)
    {
        User result = new User(0,"","",1);

        // Build a SQL SELECT statement
        String query = "SELECT * FROM Users WHERE Username = "
          + "'" + keyword.trim() +"'";

        try 
        {
            // Execute query
            System.out.println(query);
            ResultSet queryResults = Model.Instance.dbSql.executeQuery(query);

            while( queryResults.next() ) 
            {
                result = new User( queryResults.getInt(1),
                                   queryResults.getString(2),
                                   queryResults.getString(3),
                                   queryResults.getInt(4)
                                 );
                //result.add(user);	
            }
        }
        catch(SQLException ex) 
        {
            System.out.println("Select failed: " + ex);
        }

        return result;
    }
        
    /*******************************************************************/
    /*                         Insert Method                           */
    /* =============================================================== */
    /* insert() - uses a insert statement to create a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void insert(User user) 
    {
        // Build a SQL INSERT statement
        String insertSql =
          "INSERT INTO Users(Username, Password, PermissionLevel" +
          ") VALUES('" +
          user.getUsername() + "','" +
          user.getPassword() + "','" +
          user.getPermissionLevel() + "');";

        try 
        {
            System.out.println(insertSql);
            Model.Instance.dbSql.executeUpdate(insertSql);
        }
        catch (SQLException ex) 
        {
            System.out.println("Insertion failed: " + ex);
        }
    }

    /*******************************************************************/
    /*                         Update Method                           */
    /* =============================================================== */
    /* update() - uses a update statement to change a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void update(User user) 
    {
        // Build a SQL UPDATE statement
        String updateStmt = "UPDATE Users " +
          "SET Username = '" + user.getUsername() + "'," +
          "Password = '" + user.getPassword() + "' " +
          "PermissionLevel = '" + user.getPermissionLevel() + "' " +
          "WHERE ID = '" + user.getId() + "'";

        try 
        {
            System.out.println(updateStmt);
            Model.Instance.dbSql.executeUpdate(updateStmt);
            System.out.println("Record updated");
        }
        catch(SQLException ex) 
        {
            System.out.println("Update failed: " + ex);
        }
    }    

    /*******************************************************************/
    /*                         Delete Method                           */
    /* =============================================================== */
    /* delete() - uses a delete statement to remove a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void delete(User user) 
    {
        // Build a SQL UPDATE statement
        String updateStmt = "DELETE Users " +
          "WHERE ID = '" + user.getId() + "'";

        try 
        {
            System.out.println(updateStmt);
            Model.Instance.dbSql.executeUpdate(updateStmt);
            System.out.println("Record updated");
        }
        catch(SQLException ex) 
        {
            System.out.println("Update failed: " + ex);
        }
    }        
}
