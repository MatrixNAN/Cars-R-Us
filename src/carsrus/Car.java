package carsrus;

/*******************************************************************/
/*******************************************************************/
/*                   Created By Nate Nesler                        */
/* =============================================================== */
/*                       Date 05/05/2013                           */
/* --------------------------------------------------------------- */
/*                          Class Car                              */
/* =============================================================== */
/* Class Description - car object represents a car at a car        */ 
/*                     dealership lot.                             */
/* --------------------------------------------------------------- */
/* property id - will hold the id number from a database record.   */
/* property vinNumber - holds the vin number from a database       */
/*                      record.                                    */
/* property trimLevel - holds the trim level from a database       */
/*                      record.                                    */
/* property model - holds the model from a database record.        */
/* property make - holds the make from a database record.          */
/* property preview - holds the preview image from a database      */
/*                    record.                                      */
/* property description - holds the description from a database    */
/*                        record.                                  */
/* property price - holds the price from a database record.        */
/*******************************************************************/
/*******************************************************************/

public class Car 
{
    private Integer id;
    private String vinNumber;
    private String trimLevel;
    private String model;
    private String make;
    private String preview;
    private String description;
    private String price;

    public Car()
    {
        
    }

    public Car(Integer id, String vinNumber, String trimLevel, String model, String make, String description, String preview, String price)
    {
        this.id = id;
        this.vinNumber = vinNumber;
        this.trimLevel = trimLevel;
        this.model = model;
        this.make = make;
        this.preview = preview;
        this.description = description;
        this.price = price;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getPreview() 
    {
        return preview;
    }

    public void setPreview(String preview) 
    {
        this.preview = preview;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getPrice() 
    {
        return price;
    }

    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getMake() 
    {
        return make;
    }

    public void setMake(String make) 
    {
        this.make = make;
    }

    public String getVinNumber() 
    {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) 
    {
        this.vinNumber = vinNumber;
    }

    public String getTrimLevel() 
    {
        return trimLevel;
    }

    public void setTrim(String trimLevel) 
    {
        this.trimLevel = trimLevel;
    }
}
