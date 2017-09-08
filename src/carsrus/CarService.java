package carsrus;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                       Class CarService                          */
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

import java.util.List;

public interface CarService 
{
    /*******************************************************************/
    /*                       Find All Method                           */
    /* =============================================================== */
    /* findAll() - uses a select statement to return all of the cars   */
    /*             in the CarsRUs database from the Cars table.        */
    /*             Returns a List of Car Objects.                      */
    /*******************************************************************/

    public List<Car> findAll();

    /*******************************************************************/
    /*                         Search Method                           */
    /* =============================================================== */
    /* search() - uses a select statement to return cars based on      */
    /*            their make and model in the CarsRUs database from    */
    /*            the Cars table.                                      */
    /*            Returns a List of Car Objects.                       */
    /*******************************************************************/

    public List<Car> search(String keyword);

    /*******************************************************************/
    /*                         Insert Method                           */
    /* =============================================================== */
    /* insert() - uses a insert statement to create a record in the    */
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void insert(Car car);
    
    /*******************************************************************/
    /*                         Update Method                           */
    /* =============================================================== */
    /* update() - uses a update statement to change a record in the    */
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void update(Car car);

    /*******************************************************************/
    /*                         Delete Method                           */
    /* =============================================================== */
    /* delete() - uses a delete statement to remove a record in the    */
    /*            in the CarsRUs database from the Cars table.         */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void delete(Car car);
}
