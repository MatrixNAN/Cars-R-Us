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
/*                        Class CarModel                           */
/* =============================================================== */
/* Class Description - car object represents a car at a car        */ 
/*                     dealership lot.                             */
/* --------------------------------------------------------------- */
/* method findAll() - returns all of the car objects in the        */
/*                    database.                                    */
/* method search() - returns the car objects based on the model    */
/*                   and the make in the database.                 */
/* method insert() - creates a database record of a car object in  */
/*                   the database.                                 */
/* method update() - changes a database record of a car object in  */
/*                   the database.                                 */
/* method delete() - deletes a database record of a car object in  */
/*                   the database.                                 */
/*******************************************************************/
/*******************************************************************/

public class CarModel implements CarService
{

    /*******************************************************************/
    /*                       Find All Method                           */
    /* =============================================================== */
    /* findAll() - uses a select statement to return all of the cars   */
    /*             in the CarsRUs database from the Cars table.        */
    /*             Returns a List of Car Objects.                      */
    /*******************************************************************/

    public List<Car> findAll()
    {
        List<Car> result = new ArrayList<Car>();

        // Build a SQL SELECT statement
        String query = "SELECT * FROM Cars";

        try 
        {
            // Execute query
            ResultSet queryResults = Model.Instance.dbSql.executeQuery(query);

            while( queryResults.next() ) 
            {
                Car car = new Car( queryResults.getInt(1),
                                   queryResults.getString(2),
                                   queryResults.getString(3),
                                   queryResults.getString(4),
                                   queryResults.getString(5),
                                   queryResults.getString(7),
                                   queryResults.getString(6),
                                   queryResults.getString(8)
                                 );
                result.add(car);	
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
    /* search() - uses a select statement to return cars based on      */
    /*            their make and model in the CarsRUs database from    */
    /*            the Cars table.                                      */
    /*            Returns a List of Car Objects.                       */
    /*******************************************************************/

    public List<Car> search(String keyword)
    {
        List<Car> result = new ArrayList<Car>();

        // Build a SQL SELECT statement
        String query = "SELECT * FROM Cars WHERE Make = "
          + "'" + keyword.trim() + "' OR Model = " + "'" + keyword.trim() + "'";

        try 
        {
            // Execute query
            System.out.println(query);
            ResultSet queryResults = Model.Instance.dbSql.executeQuery(query);

            while( queryResults.next() ) 
            {
                Car car = new Car( queryResults.getInt(1),
                                   queryResults.getString(2),
                                   queryResults.getString(3),
                                   queryResults.getString(4),
                                   queryResults.getString(5),
                                   queryResults.getString(7),
                                   queryResults.getString(6),
                                   queryResults.getString(8)
                                 );
                result.add(car);	
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
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void insert(Car car) 
    {
        // Build a SQL INSERT statement
        String insertSql =
          "INSERT INTO Cars(VinNumber, TrimLevel, Model, Make, " +
          " PreviewImage, Description, Price) VALUES('" +
          car.getVinNumber() + "','" +
          car.getTrimLevel() + "','" +
          car.getModel() + "','" +
          car.getMake() + "','" +
          car.getDescription() + "','" +
          car.getPreview() + "','" +
          car.getPrice() + "');";

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
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void update(Car car) 
    {
        // Build a SQL UPDATE statement
        String updateStmt = "UPDATE Cars " +
          "SET VinNumber = '" + car.getVinNumber() + "'," +
          "TrimLevel = '" + car.getTrimLevel() + "'," +
          "Model = '" + car.getModel() + "'," +
          "Make = '" + car.getMake() + "'," +
          "PreviewImage = '" + car.getPreview() + "'," +
          "Description = '" + car.getDescription() + "'," +
          "Price = '" + car.getPrice() + "' " +
          "WHERE ID = '" + car.getId() + "'";

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
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void delete(Car car) 
    {
        // Build a SQL DELETE statement
        String updateStmt = "DELETE FROM Cars " +
          "WHERE ID = " + car.getId();

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
