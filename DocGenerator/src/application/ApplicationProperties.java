package application;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kfw.Tools.Logging.KfwLogger;
import kfw.Tools.Reader.JsonFileReader;

/**
 * @author Kai
 *
 */
public class ApplicationProperties
{
    public static KfwLogger kfwLogger = new KfwLogger();
    
    /* Benennung der Attribute-Namen in der PropertiesJson */
    private static String JSON_ATTRIBUTES_NAME = "AttributeNames";

    /* Benennung der Attribute-Values in der PropertiesJson */
    private static String JSON_ATTRIBUTE_VALUES = "AttributeValues";

    public static ApplicationProperties INSTANCE;

    private List<String> attributeNames = new ArrayList<>();
    private List<String> attributeValues = new ArrayList<>();

    /**
     * Singleton Pattern callfunktion
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * 
     * @return Instanz dieser Klasse
     */
    public static ApplicationProperties getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ApplicationProperties();
        }

        return INSTANCE;
    }

    /**
     * @return the attributeNames
     */
    public List<String> getAttributeNames()
    {
        return attributeNames;
    }

    /**
     * @param attributeNames the attributeNames to set
     */
    public void setAttributeNames(List<String> attributeNames)
    {
        this.attributeNames = attributeNames;
    }

    /**
     * @return the attributeValues
     */
    public List<String> getAttributeValues()
    {
        return attributeValues;
    }

    /**
     * @param attributeValues the attributeValues to set
     */
    public void setAttributeValues(List<String> attributeValues)
    {
        this.attributeValues = attributeValues;
    }

    /**
     * Lesen der properties-Json
     * 
     * 18.12.2023, Kai: Methode erstellt.
     * 
     * @param path
     */
    public void readPropertiesFile(String path)
    {
        kfwLogger.log("Lade Properties-Datei");
        
        try
        {
            JSONObject properties = new JsonFileReader().readJsonFile(path);

            JSONArray attributeNamesFromFile = (JSONArray) properties.get(JSON_ATTRIBUTES_NAME);
            if (attributeNamesFromFile != null)
            {
                int len = attributeNamesFromFile.size();
                for (int i = 0; i < len; i++)
                {
                    attributeNames.add(attributeNamesFromFile.get(i).toString());
                    kfwLogger.log("Attribut-Name '" + attributeNamesFromFile.get(i).toString() + "' gefunden");
                }
            }
            
            JSONArray attributeValuesFromFile = (JSONArray) properties.get(JSON_ATTRIBUTE_VALUES);
            if (attributeValuesFromFile != null)
            {
                int len = attributeValuesFromFile.size();
                for (int i = 0; i < len; i++)
                {
                    attributeValues.add(attributeValuesFromFile.get(i).toString());
                    kfwLogger.log("Attribut-Value '" + attributeValuesFromFile.get(i).toString() + "' gefunden");
                }
            }
            
            kfwLogger.log("Properties-Datei erfolgreich geladen.");
        }
        catch (Exception e)
        {
            kfwLogger.logError("Fehler beim Laden der Properties-Datei!");
            e.printStackTrace();
        }

    }
}
