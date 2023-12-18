package business.taskProcessXmlFile;

import java.util.LinkedHashMap;

/**
 * @author Kai
 *
 */
public class DoAttributes
{
    private LinkedHashMap<String, String> doAttributes = new LinkedHashMap<>();;

    /**
     * Getter für doAttributes
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * @return
     */
    public LinkedHashMap<String, String> getDoAttributes()
    {
        return doAttributes;
    }

    /**
     * Ermitteln eines Values der Map
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * @param key
     * @return Value aus der Do Map
     */
    public String getValue(String key)
    {
        return doAttributes.get(key);
    }
    
    
    /**
     * Setter für DoAttributes
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * @param doAttributes
     */
    public void setDoAttributes(LinkedHashMap<String, String> doAttributes)
    {
        this.doAttributes = doAttributes;
    }
    
    /**
     * Setzen eines einzelnen Attributes
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * @param key
     * @param value
     */
    public void setDoAttribute(String key, String value)
    {
        doAttributes.put(key, value);
    }
}
