package carsrus;

import java.util.List;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                      Class UserService                          */
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

public interface UserService 
{
    /*******************************************************************/
    /*                       Find All Method                           */
    /* =============================================================== */
    /* findAll() - uses a select statement to return all of the users  */
    /*             based their username in the CarsRUs database from   */
    /*             the Users table.                                    */
    /*             Returns a List of User Objects.                     */
    /*******************************************************************/

    public List<User> findAll();

    /*******************************************************************/
    /*                         Search Method                           */
    /* =============================================================== */
    /* search() - uses a select statement to return users based on     */
    /*            their username in the CarsRUs database from the      */
    /*            Users table.                                         */
    /*            Returns a List of User Objects.                      */
    /*******************************************************************/

    public User search(String keyword);

    /*******************************************************************/
    /*                         Insert Method                           */
    /* =============================================================== */
    /* insert() - uses a insert statement to create a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void insert(User user);
    
    /*******************************************************************/
    /*                         Update Method                           */
    /* =============================================================== */
    /* update() - uses a update statement to change a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void update(User user);

    /*******************************************************************/
    /*                         Delete Method                           */
    /* =============================================================== */
    /* delete() - uses a delete statement to remove a record in the    */
    /*            in the CarsRUs database from the Users table.        */
    /*            Returns nothing.                                     */
    /*******************************************************************/

    public void delete(User user);    
}
