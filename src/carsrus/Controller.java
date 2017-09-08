package carsrus;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                       Class Controller                          */
/* =============================================================== */
/* Class Description - the Controller aspect of the MVC.  This     */ 
/*                     class acts as the main access point to the  */
/*                     logic portion of the overall application.   */
/*                     For this reason this class is setup as a    */
/*                     singleton.                                  */
/* --------------------------------------------------------------- */
/* method InitializeDB() - creates a single database connection    */
/*                         that all other database classes share   */
/*                         and use in order to send SQL statments  */
/*                         to the database.                        */
/* --------------------------------------------------------------- */
/* property model - is a class interface that allows access to the */
/*                  Cars and Users database table.                 */
/* property view - is a class interface that allows access to the  */
/*                 GUI of the View part of MVC.                    */
/* property user - is a class interface that allows access to the  */
/*                 presistant user account.  This variable         */
/*                 represents the currently logged in user in the  */
/*                 application.                                    */
/* property car - is a class interface that allows access to the   */
/*                 presistant car that is currently being viewed   */
/*                 in the View portion of the application.         */
/* property cars - is a class interface that allows access to the  */
/*                 presistant list of cars that is returned from   */
/*                 the database and can be viewed in the View      */
/*                 portion of the application.                     */
/* --------------------------------------------------------------- */
/* method login() - logins into a user account by getting the data */
/*                  inputed by the user and then sees if the       */
/*                  exists in the database.  Then the method       */
/*                  checks to see if the password in the database  */
/*                  matches the password inputed by the user.  If  */
/*                  everything checks out then the menu system is  */
/*                  enabled and the login panel's visibility is    */
/*                  set to false and the car panel's visibility is */
/*                  set to true.  If the login does not check out  */
/*                  then login panel stays visible, car panel      */
/*                  stays invisible, and the menu system stays     */
/*                  disabled.                                      */
/* method clearCarView() - sets all of the text to "" thus         */
/*                         clearing all of the TextFields in the   */
/*                         car panel View GUI interface.           */
/* method loadCarInView() - loads a car object in the View GUI     */
/*                          interface in the TextFields in the car */
/*                          panel.                                 */
/* method createCarFromView() - creates a car object from the View */
/*                              GUI interface car panel TextFields */
/* method insert() - creates a car object from the View GUI        */
/*                   interface car panel TextFields and creates a  */
/*                   record in the database Cars table.            */
/* method update() - creates a car object from the View GUI        */
/*                   interface car panel TextFields and changes a  */
/*                   record in the database Cars table.            */
/* method delete() - creates a car object from the View GUI        */
/*                   interface car panel TextFields and deletes a  */
/*                   record in the database Cars table.            */
/* method search() - gets the text from the View GUI interface     */
/*                   jTxtFdSearch and gets all the match records   */
/*                   as a list of cars in the database Cars table. */
/* method previous() - selects the previous car from the search    */
/*                     results to be displayed.                    */
/* method next() - selects the next car from the search results to */
/*                 be displayed.                                   */
/*******************************************************************/
/*******************************************************************/

public class Controller 
{
    /*******************************************************************/
    /*                      Create Singleton                           */
    /*******************************************************************/
    public final static Controller Instance = new Controller();
    
    /*******************************************************************/
    /*                Create Persistant User Account                   */
    /*******************************************************************/
    public static   User        user;
    public          List<Car>   cars    = new ArrayList<Car>();
    public          Car         car     = new Car();
    private         Model       model   = Model.Instance;
    private         View        view    = View.Instance;
    private         Integer     index   = 0;    
    private         String      keyword = "";    

    /*******************************************************************/
    /*                         Method Login                            */
    /* =============================================================== */
    /* logins into a user account by getting the data inputed by the   */
    /* user and then sees if the exists in the database.  Then the     */
    /* method checks to see if the password in the database matches    */
    /* the password inputed by the user.  If everything checks out     */
    /* then the menu system is enabled and the login panel's           */
    /* visibility is set to false and the car panel's visibility is    */
    /* set to true.  If the login does not check out then login panel  */
    /* stays visible, car panel stays invisible, and the menu system   */
    /* stays disabled.                                                 */
    /*******************************************************************/
    
    public boolean login()
    {   
        user = model.users.search( View.Instance.jTxtFdUsername.getText().trim() );
        if ( View.Instance.jPassFdPassword.getText().trim().equals( user.getPassword() ) )
        {
            View.Instance.fileMenu.setEnabled(true);
            View.Instance.helpMenu.setEnabled(true);
            View.Instance.jpanLogin.setVisible(false);
            View.Instance.jpanCars.setVisible(true);
            
            return true;
        }
        else
        {
            View.Instance.fileMenu.setEnabled(false);
            View.Instance.helpMenu.setEnabled(false);
            View.Instance.jpanLogin.setVisible(true);
            View.Instance.jpanCars.setVisible(false);
            
            return false;
        }
    }
    
    /*******************************************************************/
    /*                      Method Clear Car View                      */
    /* =============================================================== */
    /* sets all of the text to "" thus clearing all of the TextFields  */
    /* in the car panel View GUI interface.                            */
    /*******************************************************************/
    
    public void clearCarView()
    {
        View.Instance.jTxtFdVinNumber.setText("");
        View.Instance.jTxtFdTrimLevel.setText("");
        View.Instance.jTxtFdModel.setText("");
        View.Instance.jTxtFdMake.setText("");
        View.Instance.jTxtFdPreview.setText("");
        View.Instance.jTxtFdDescription.setText("");
        View.Instance.jTxtFdPrice.setText("");        
        index = 0;
    }
    
    /*******************************************************************/
    /*                     Method Load Car In View                     */
    /* =============================================================== */
    /* loads a car object in the View GUI interface in the TextFields  */
    /* in the car panel.                                               */
    /*******************************************************************/
    
    public void loadCarInView(Car car)
    {
        View.Instance.jTxtFdId.setText( car.getId().toString() );
        View.Instance.jTxtFdVinNumber.setText( car.getVinNumber() );
        View.Instance.jTxtFdTrimLevel.setText( car.getTrimLevel() );
        View.Instance.jTxtFdModel.setText( car.getModel() );
        View.Instance.jTxtFdMake.setText( car.getMake() );
        View.Instance.jTxtFdPreview.setText( car.getPreview() );
        View.Instance.jTxtFdDescription.setText( car.getDescription() );
        View.Instance.jTxtFdPrice.setText( car.getPrice() );
        View.Instance.icon = new ImageIcon( car.getPreview() );
        View.Instance.jlblImg.setIcon(View.Instance.icon);
    }
    
    /*******************************************************************/
    /*                 Method Create Car From View                     */
    /* =============================================================== */
    /* creates a car object from the View GUI interface car panel      */
    /* TextFields.                                                     */
    /*******************************************************************/
    
    public void createCarFromView()
    {
        this.car = new Car( Integer.parseInt( View.Instance.jTxtFdId.getText().trim() ), 
                           View.Instance.jTxtFdVinNumber.getText().trim(),
                           View.Instance.jTxtFdTrimLevel.getText().trim(),
                           View.Instance.jTxtFdModel.getText().trim(),
                           View.Instance.jTxtFdMake.getText().trim(),
                           View.Instance.jTxtFdPreview.getText().trim(),
                           View.Instance.jTxtFdDescription.getText().trim(),
                           View.Instance.jTxtFdPrice.getText().trim()
                         );
    }
    
    /*******************************************************************/
    /*                          Method Insert                          */
    /* =============================================================== */
    /* creates a car object from the View GUI interface car panel      */
    /* TextFields and creates a record in the database Cars table.     */
    /*******************************************************************/
    
    public void insert()
    {
        createCarFromView();
        model.cars.insert( car );
        searchKeyword(keyword);
    }
    
    /*******************************************************************/
    /*                          Method Update                          */
    /* =============================================================== */
    /* creates a car object from the View GUI interface car panel      */
    /* TextFields and changes a record in the database Cars table.     */
    /*******************************************************************/
    
    public void update()
    {
        createCarFromView();
        model.cars.update( car );
    }
    
    /*******************************************************************/
    /*                          Method Delete                          */
    /* =============================================================== */
    /* creates a car object from the View GUI interface car panel      */
    /* TextFields and deletes a record in the database Cars table.     */
    /*******************************************************************/
    
    public void delete()
    {
        createCarFromView();
        model.cars.delete( car );
        searchKeyword(keyword);
    }
    
    /*******************************************************************/
    /*                          Method Search                          */
    /* =============================================================== */
    /* gets the text from the View GUI interface jTxtFdSearch and gets */
    /* all the match records as a list of cars in the database Cars    */
    /* table.                                                          */
    /*******************************************************************/
    
    public void searchKeyword(String keyword)
    {
        this.keyword = keyword;
        cars = model.cars.search( keyword );
        index = 0;
        if (cars.size() > 0)
        {
            car = cars.get(index);
            loadCarInView( car );
        }
    }

    public void search()
    {
        searchKeyword( View.Instance.jTxtFdSearch.getText().trim() );
    }

    /*******************************************************************/
    /*                        Method Previous                          */
    /* =============================================================== */
    /* selects the previous car from the search results to be          */
    /* displayed.                                                      */
    /*******************************************************************/
    
    public void previous()
    {
        if ((index - 1) >= 0)
        {
            car = cars.get(--index);
        }
        loadCarInView( car );
    }

    /*******************************************************************/
    /*                           Method Next                           */
    /* =============================================================== */
    /* selects the next car from the search results to be displayed.   */
    /*******************************************************************/
    
    public void next()
    {
        if ((index + 1) < cars.size())
        {
            car = cars.get(++index);
        }
        loadCarInView( car );
    }
}
