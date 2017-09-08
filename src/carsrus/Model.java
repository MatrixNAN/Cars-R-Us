package carsrus;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                         Class Model                             */
/* =============================================================== */
/* Class Description - the Model aspect of the MVC.  This class    */ 
/*                     acts as the main access point to the data   */
/*                     portion of the overall application.  For    */
/*                     this reason this class is setup as a        */
/*                     singleton.                                  */
/* --------------------------------------------------------------- */
/* method InitializeDB() - creates a single database connection    */
/*                         that all other database classes share   */
/*                         and use in order to send SQL statments  */
/*                         to the database.                        */
/* --------------------------------------------------------------- */
/* database object Cars - is a class interface that allows access  */
/*                        to the Cars database table.              */
/* database object Users - is a class interface that allows access */
/*                         to the Users database table.            */
/*******************************************************************/
/*******************************************************************/

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Model
{
    /*******************************************************************/
    /*                      Create Singleton                           */
    /*******************************************************************/
    public final static Model Instance = new Model();
    
    Statement dbSql;
    Connection dbConnection;
    CarModel cars = new CarModel();
    UserModel users = new UserModel();
    
    public Model()
    {
        InitializeDB();
    }

    /*******************************************************************/
    /*                   Initialize Database Method                    */
    /* =============================================================== */
    /* InitializeDB() - creates a single access point to the CarsRUs   */
    /*                  Database so that multiple database model       */
    /*                  classes can access the database without        */
    /*                  creating multiple database connections.        */
    /*******************************************************************/

    private void InitializeDB() 
    {
        try 
        {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Connect to the ODBC - Access database
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CarsRUs", "root", "password");      
            // conn = DriverManager.getConnection("jdbc:odbc:Cars", "", "" );
            // Create a statement
            dbSql = dbConnection.createStatement();
        }
        catch (Exception ex) 
        {
            System.out.println("Connection failed: " + ex);
        }
    }
}
