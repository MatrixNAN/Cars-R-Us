package carsrus;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                          Class View                             */
/* =============================================================== */
/* Class Description - the View aspect of the MVC.  This class     */ 
/*                     acts as the main access point to the view   */
/*                     portion of the overall application.  For    */
/*                     this reason this class is setup as a        */
/*                     singleton.                                  */
/* --------------------------------------------------------------- */
/* GUI Interface Menu System - allows for a user to access         */
/*                             functionality from a menu system in */
/*                             the application.                    */
/* GUI Interface Login System- allows a user to type in their      */
/*                             username and password to login to   */
/*                             the application.                    */
/* GUI Interface Cars Database - allows the user to add, remove,   */
/*                               update, and search the database   */
/*                               cars.                             */
/* --------------------------------------------------------------- */
/* property controller - allows access to the controller singelton */
/*                       of the MVC portion of the application.    */
/*******************************************************************/
/*******************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame
{
    /*******************************************************************/
    /*                      Create Singleton                           */
    /*******************************************************************/
    public final static View Instance = new View();
    
    /*******************************************************************/
    /*                      MVC Controller                             */
    /*******************************************************************/
    Controller controller = Controller.Instance;
    
    /*******************************************************************/
    /*                      Create Menu Bar                            */
    /* =============================================================== */
    /*                         Main Menus                              */
    /* --------------------------------------------------------------- */
    /* File - contains File, Open, Open Recent, Save, Close, Exit      */
    /* Help - contains FAQ, About                                      */
    /*******************************************************************/
    
    private JMenuBar    jMenuBar     = new JMenuBar();
    private JPopupMenu  jPopupMenu1  = new JPopupMenu();
    
    /*******************************************************************/
    /*                          File Menu                              */
    /*=================================================================*/
    /*                      Create Menu Items                          */
    /* --------------------------------------------------------------- */
    /* Exit - closes the application calling the exit method.         */ 
    /*******************************************************************/
    
    private JMenuItem jMenuItemExit     = new JMenuItem("Exit");

    /*******************************************************************/
    /*                        Database Menu                            */
    /*=================================================================*/
    /*                      Create Menu Items                          */
    /* --------------------------------------------------------------- */
    /* Insert - Adds a new car record into the database.               */ 
    /* Update - Changes a car record in the database.                  */ 
    /* Search - gets all of the cars that match the model or the make  */
    /*          from the database.                                     */
    /* Previous - displays the previous car in the database search     */
    /*          result.                                                */
    /* Next - displays the previous car in the database search result. */
    /* Delete - removes a car record from the database.                */
    /* Clear - sets all of the Text Fields to "" for the Car Interface */
    /*******************************************************************/
    
    private JMenuItem jMenuItemInsert = new JMenuItem("Insert");
    private JMenuItem jMenuItemUpdate = new JMenuItem("Update");
    private JMenuItem jMenuItemSearch = new JMenuItem("Search");
    private JMenuItem jMenuItemPrevious = new JMenuItem("Previous");
    private JMenuItem jMenuItemNext = new JMenuItem("Next");
    private JMenuItem jMenuItemDelete = new JMenuItem("Delete");
    private JMenuItem jMenuItemClear  = new JMenuItem("Clear");

    /*******************************************************************/
    /*                          Help Menu                              */
    /*=================================================================*/
    /*                      Create Menu Items                          */
    /* --------------------------------------------------------------- */
    /* FAQ   - Creates a new file calling the newFile method.          */
    /* About - Opens an existing file calling the openFile method.     */
    /*******************************************************************/
    
    private JMenuItem jMenuItemFAQ      = new JMenuItem("FAQ");
    private JMenuItem jMenuItemAbout    = new JMenuItem("About");

    /*
    private JMenuItem jMenuItemNew = new JMenuItem("New",
            new ImageIcon(getClass().getResource("image/new.gif")));
    */

    /*******************************************************************/
    /*                     Create Main Menus                           */
    /* =============================================================== */
    /* File - contains File, Open, Open Recent, Save, Close, Exit      */
    /* Database - contains Add, Delete, Update, Search, and Clear      */
    /*            the database records.                                */
    /* Help - contains FAQ, About                                      */
    /*******************************************************************/

    public JMenu fileMenu          = new JMenu("File");
    public JMenu databaseMenu      = new JMenu("Database");
    public JMenu helpMenu          = new JMenu("Help");
        
    
    /*******************************************************************/
    /*                     Create User Login                           */
    /* =============================================================== */
    /* jlblUsername - Stores the username text for the jTxtFdUsername. */
    /* jlblpassword - Stores the password text for the jTxtFdPassword. */
    /* jTxtFdUsername - Receives the user input for the username.      */
    /* jlblpassword   - Receives the user input for the password.      */
    /*******************************************************************/

    public JLabel jlblUsername = new JLabel("Username");
    public JLabel jlblPassword = new JLabel("Password");

    public JTextField      jTxtFdUsername   = new JTextField("", 10);
    public JPasswordField  jPassFdPassword  = new JPasswordField("", 10); 
    
    public JButton jbtnLogin = new JButton("Login");    
    
    public  JPanel  jpanLogin        = new JPanel();
    public  JFrame  frame            = new JFrame();
    public  boolean isLoginSuccess   = false;

    
    /*******************************************************************/
    /*                Create Cars R Us Database GUI                    */
    /* =============================================================== */
    /* jlblUsername - Stores the username text for the jTxtFdUsername. */
    /* jlblpassword - Stores the password text for the jTxtFdPassword. */
    /* jTxtFdUsername - Receives the user input for the username.      */
    /* jlblpassword   - Receives the user input for the password.      */
    /*******************************************************************/
    
    /*-----------------------------------------------------------------*/
    /*              Create Cars R Us Database Labels                   */
    /*-----------------------------------------------------------------*/

    public JLabel jlblSearch       = new JLabel("Search");
    public JLabel jlblId           = new JLabel("ID");
    public JLabel jlblVinNumber    = new JLabel("Vin Number");
    public JLabel jlblTrimLevel    = new JLabel("Trim Level");
    public JLabel jlblModel        = new JLabel("Model");
    public JLabel jlblMake         = new JLabel("Make");
    public JLabel jlblPreview      = new JLabel("Preview");
    public JLabel jlblDescription  = new JLabel("Description");
    public JLabel jlblPrice        = new JLabel("Price");
    public JLabel jlblImg          = new JLabel();
    
    public ImageIcon icon;

    /*-----------------------------------------------------------------*/
    /*            Create Cars R Us Database Text Fields                */
    /*-----------------------------------------------------------------*/

    public JTextField jTxtFdSearch         = new JTextField("", 10);
    public JTextField jTxtFdId             = new JTextField("", 10);
    public JTextField jTxtFdVinNumber      = new JTextField("", 10);
    public JTextField jTxtFdTrimLevel      = new JTextField("", 10); 
    public JTextField jTxtFdModel          = new JTextField("", 10);
    public JTextField jTxtFdMake           = new JTextField("", 10); 
    public JTextField jTxtFdPreview        = new JTextField("", 10);
    public JTextField jTxtFdDescription    = new JTextField("", 10); 
    public JTextField jTxtFdPrice          = new JTextField("", 10); 
    
    /*-----------------------------------------------------------------*/
    /*              Create Cars R Us Database Buttons                  */
    /*-----------------------------------------------------------------*/

    public JButton jbtnInsert   = new JButton("Insert");    
    public JButton jbtnUpdate   = new JButton("Update");    
    public JButton jbtnDelete   = new JButton("Delete");    
    public JButton jbtnSearch   = new JButton("Search");    
    public JButton jbtnClear    = new JButton("Clear");    
    public JButton jbtnPrevious = new JButton("Previous");
    public JButton jbtnNext     = new JButton("Next");

    /*-----------------------------------------------------------------*/
    /*              Create Cars R Us Database Panels                   */
    /*-----------------------------------------------------------------*/

    public JPanel jpanCars                  = new JPanel();
    public JPanel jpanCarsLabels            = new JPanel();
    public JPanel jpanCarsTextFields        = new JPanel();
    public JPanel jpanCarsButtonGrid        = new JPanel();
    public JPanel jpanCarsButtons           = new JPanel();
    public JPanel jpanCarsButtonsPrevNext   = new JPanel();
    public JPanel jpanCarsSearch            = new JPanel();
    
    View()
    {
        /*-----------------------------------------------------------------*/
        /*              Create The Main Application Window                 */
        /*-----------------------------------------------------------------*/

        frame.setSize(600, 350);
        frame.setLayout(new FlowLayout());
        jpanLogin.setLayout(new FlowLayout());
        jpanCars.setLayout(new BorderLayout());
        jpanCarsLabels.setLayout(new GridLayout(8, 1));
        jpanCarsTextFields.setLayout(new GridLayout(8, 1));
        jpanCarsButtonGrid.setLayout(new GridLayout(2, 1));
        jpanCarsButtonsPrevNext.setLayout(new FlowLayout());
        jpanCarsButtons.setLayout(new FlowLayout());
        jpanCarsSearch.setLayout(new FlowLayout());
        
        /*-----------------------------------------------------------------*/
        /*                    Create The Main Menu Bar                     */
        /*-----------------------------------------------------------------*/

        frame.setJMenuBar(jMenuBar);        
        jMenuBar.add(fileMenu);
        jMenuBar.add(databaseMenu);
        jMenuBar.add(helpMenu);

        /*-----------------------------------------------------------------*/
        /*                  Add Menu Items To File Menu                    */
        /*-----------------------------------------------------------------*/

        fileMenu.add(jMenuItemExit);

        fileMenu.setMnemonic('F');
        jMenuItemExit.setMnemonic('x');

        /*-----------------------------------------------------------------*/
        /*                  Add Menu Items To File Menu                    */
        /*-----------------------------------------------------------------*/

        databaseMenu.add(jMenuItemInsert);
        databaseMenu.add(jMenuItemUpdate);
        databaseMenu.addSeparator();
        databaseMenu.add(jMenuItemSearch);
        databaseMenu.add(jMenuItemPrevious);
        databaseMenu.add(jMenuItemNext);
        databaseMenu.addSeparator();
        databaseMenu.add(jMenuItemDelete);
        databaseMenu.addSeparator();
        databaseMenu.add(jMenuItemClear);

        databaseMenu.setMnemonic('D');
        jMenuItemInsert.setMnemonic('I');
        jMenuItemUpdate.setMnemonic('U');
        jMenuItemSearch.setMnemonic('S');
        jMenuItemPrevious.setMnemonic('P');
        jMenuItemNext.setMnemonic('N');
        jMenuItemDelete.setMnemonic('l');
        jMenuItemClear.setMnemonic('C');

        /*-----------------------------------------------------------------*/
        /*                  Add Menu Items To Help Menu                    */
        /*-----------------------------------------------------------------*/

        helpMenu.add(jMenuItemFAQ);
        helpMenu.add(jMenuItemAbout);

        helpMenu.setMnemonic('H');
        jMenuItemFAQ.setMnemonic('Q');
        jMenuItemAbout.setMnemonic('A');

        /*-----------------------------------------------------------------*/
        /*                Add User Log In To Main Window                   */
        /*-----------------------------------------------------------------*/

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jpanLogin.add(jlblUsername);
        jpanLogin.add(jTxtFdUsername);
        jpanLogin.add(jlblPassword);
        jpanLogin.add(jPassFdPassword);
        jpanLogin.add(jbtnLogin);
        frame.add(jpanLogin);
        fileMenu.setEnabled(false);
        helpMenu.setEnabled(false);
        frame.setVisible(true);

        
        /*-----------------------------------------------------------------*/
        /*                 Add Database GUI To Cars Panel                  */
        /*-----------------------------------------------------------------*/
        jpanCarsSearch.add( jlblSearch );
        jpanCarsSearch.add( jTxtFdSearch );
        jpanCarsLabels.add( jlblId );
        jpanCarsLabels.add( jlblVinNumber );
        jpanCarsLabels.add( jlblTrimLevel );
        jpanCarsLabels.add( jlblModel );
        jpanCarsLabels.add( jlblMake );
        jpanCarsLabels.add( jlblPreview );
        jpanCarsLabels.add( jlblDescription );
        jpanCarsLabels.add( jlblPrice );
        jpanCars.add( jpanCarsLabels, BorderLayout.WEST );

        /*-----------------------------------------------------------------*/
        /*        Add Cars R Us Database Text Fields To Cars Panel         */
        /*-----------------------------------------------------------------*/

        jpanCarsTextFields.add( jTxtFdId );
        jpanCarsTextFields.add( jTxtFdVinNumber );
        jpanCarsTextFields.add( jTxtFdTrimLevel ); 
        jpanCarsTextFields.add( jTxtFdModel );
        jpanCarsTextFields.add( jTxtFdMake ); 
        jpanCarsTextFields.add( jTxtFdPreview );
        jpanCarsTextFields.add( jTxtFdDescription ); 
        jpanCarsTextFields.add( jTxtFdPrice ); 
        jpanCars.add( jpanCarsSearch, BorderLayout.NORTH );
        jpanCars.add( jpanCarsTextFields, BorderLayout.CENTER ); 

        /*-----------------------------------------------------------------*/
        /*          Add Cars R Us Database Buttons To Cars Panel           */
        /*-----------------------------------------------------------------*/
        jpanCarsButtonsPrevNext.add( jbtnPrevious );
        jpanCarsButtonsPrevNext.add(   jbtnNext   );
        jpanCarsButtons.add( jbtnSearch );    
        jpanCarsButtons.add( jbtnInsert );    
        jpanCarsButtons.add( jbtnUpdate );    
        jpanCarsButtons.add( jbtnClear  );    
        jpanCarsButtons.add( jbtnDelete );
        jpanCarsButtonGrid.add( jpanCarsButtonsPrevNext );
        jpanCarsButtonGrid.add( jpanCarsButtons );
        jpanCars.add( jpanCarsButtonGrid,  BorderLayout.SOUTH );
        jpanCars.add( jlblImg,          BorderLayout.EAST  );
        frame.add( jpanCars );
        jpanCars.setVisible( false );

        /*******************************************************************/
        /*                     Create Event Handlers                       */
        /* =============================================================== */
        /* login - logs into the application if the username exists and    */
        /*         the password matches in the database.                   */
        /* insert - add a car to the database when the add button is       */
        /*          clicked.                                               */
        /* update - changes the data for a car in the database when the    */
        /*          update button is clicked.                              */
        /* delete - removes a car from the database when the delete button */
        /*          is clicked.                                            */
        /* search - finds all the cars that match the make or model when   */
        /*          the search button is clicked.                          */
        /* previous - selects the previous car from the search results to  */
        /*            be displayed when the previous button is clicked.    */
        /* next - selects the next car from the search results to be       */
        /*        displayed when the next button is clicked.               */
        /* clear - removes all text from the TextFields in the car panel   */
        /*         when the clear button is clicked.                       */
        /*******************************************************************/
    
        /*=================================================================*/
        /*                        Login Click Event                        */
        /* --------------------------------------------------------------- */
        /* logs into the application if the username exists and the        */
        /* password matches in t he database.                              */
        /*=================================================================*/

        jbtnLogin.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                isLoginSuccess = controller.login();
            }
        });

        /*=================================================================*/
        /*                       Insert Click Event                        */
        /* --------------------------------------------------------------- */
        /* adds a car to the database when the add button is clicked.      */
        /*=================================================================*/

        jbtnInsert.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.insert();
            }
        });

        /*=================================================================*/
        /*                       Clear Click Event                         */
        /* --------------------------------------------------------------- */
        /* changes the data for a car in the database when the update      */
        /* button is clicked.                                              */
        /*=================================================================*/

        jbtnClear.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.clearCarView();
            }
        });

        /*=================================================================*/
        /*                       Delete Click Event                        */
        /* --------------------------------------------------------------- */
        /* removes a car from the database when the delete button is       */
        /* clicked.                                                        */
        /*=================================================================*/

        jbtnDelete.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.delete();
            }
        });

        /*=================================================================*/
        /*                      Update Click Event                         */
        /* --------------------------------------------------------------- */
        /* removes all text from the TextFields in the car panel when the  */
        /* clear button is clicked.                                        */
        /*=================================================================*/

        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.update();
            }
        });

        /*=================================================================*/
        /*                       Search Click Event                        */
        /* --------------------------------------------------------------- */
        /* finds all the cars that match the make or model when the search */
        /* button is clicked.                                              */
        /*=================================================================*/

        jbtnSearch.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.search();
            }
        });
        
        /*=================================================================*/
        /*                      Previous Click Event                       */
        /* --------------------------------------------------------------- */
        /* selects the previous car from the search results to be          */
        /* displayed when the previous button is clicked.                  */
        /*=================================================================*/

        jbtnPrevious.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.previous();
            }
        });

        /*=================================================================*/
        /*                        Next Click Event                         */
        /* --------------------------------------------------------------- */
        /* selects the next car from the search results to be displayed    */
        /* when the next button is clicked.                                */
        /*=================================================================*/

        jbtnNext.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.next();
            }
        });
        
        /*=================================================================*/
        /*                   Insert Menu Click Event                       */
        /* --------------------------------------------------------------- */
        /* adds a car to the database when the add button is clicked.      */
        /*=================================================================*/

        jMenuItemInsert.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.insert();
            }
        });

        /*=================================================================*/
        /*                     Clear Menu Click Event                      */
        /* --------------------------------------------------------------- */
        /* changes the data for a car in the database when the update      */
        /* button is clicked.                                              */
        /*=================================================================*/

        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.clearCarView();
            }
        });

        /*=================================================================*/
        /*                    Delete Menu Click Event                      */
        /* --------------------------------------------------------------- */
        /* removes a car from the database when the delete button is       */
        /* clicked.                                                        */
        /*=================================================================*/

        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.delete();
            }
        });

        /*=================================================================*/
        /*                    Update Menu Click Event                      */
        /* --------------------------------------------------------------- */
        /* removes all text from the TextFields in the car panel when the  */
        /* clear button is clicked.                                        */
        /*=================================================================*/

        jMenuItemUpdate.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.update();
            }
        });

        /*=================================================================*/
        /*                    Search Menu Click Event                      */
        /* --------------------------------------------------------------- */
        /* finds all the cars that match the make or model when the search */
        /* button is clicked.                                              */
        /*=================================================================*/

        jMenuItemSearch.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.search();
            }
        });
        
        /*=================================================================*/
        /*                    Previous Menu Click Event                    */
        /* --------------------------------------------------------------- */
        /* selects the previous car from the search results to be          */
        /* displayed when the previous button is clicked.                  */
        /*=================================================================*/

        jMenuItemPrevious.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.previous();
            }
        });

        /*=================================================================*/
        /*                     Next Menu Click Event                       */
        /* --------------------------------------------------------------- */
        /* selects the next car from the search results to be displayed    */
        /* when the next button is clicked.                                */
        /*=================================================================*/

        jMenuItemNext.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {                
                controller.next();
            }
        });
    }
}
