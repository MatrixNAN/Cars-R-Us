package carsrus;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                         Class User                              */
/* =============================================================== */
/* Class Description - user to login account object.               */
/* --------------------------------------------------------------- */
/* property id - will hold the id number from a database record.   */
/* property username - holds the username from a database record.  */
/* property password - holds the password from a database record.  */
/* property permissionLevel - holds the premission level from a    */
/*                            database record. 0 is the highest    */
/*                            permission level with each number    */
/*                            having less and less levels of       */
/*                            authority.                           */
/*******************************************************************/
/*******************************************************************/

public class User 
{
    private Integer id;
    private String  username;
    private String  password;
    private Integer permissionLevel;
    
    public User(Integer id, String username, String password, Integer permissionLevel)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permissionLevel = permissionLevel;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String username)
    {
        this.password = password;
    }
    
    public Integer getPermissionLevel()
    {
        return permissionLevel;
    }
    
    public void setPermissionLevel(Integer id)
    {
        this.permissionLevel = permissionLevel;
    }
}
