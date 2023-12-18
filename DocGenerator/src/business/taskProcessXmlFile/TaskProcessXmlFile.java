package business.taskProcessXmlFile;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import application.ApplicationProperties;
import data.XmlReader;

/**
 * @author Kai
 *
 */
public class TaskProcessXmlFile
{
    private XmlReader xmlReader = new XmlReader();

    /**
     * Auslesen einer XML-Datei in ein DO
     * 
     * 16.12.2023, Kai: Methode erstellt.
     * 
     * @param path Pfad der XML
     * @return DOs der Dateielemente
     */
    public List<DoAttributes> readDataObject(String path)
    {
        List<DoAttributes> listDoAttributes = new ArrayList<>();

        for (String attribute : ApplicationProperties.getInstance().getAttributeNames())
        {
            NodeList allAttributes = xmlReader.readXmlFile(path).getElementsByTagName(attribute);
            for (int i = 0; i < allAttributes.getLength(); i++)
            {
                DoAttributes doAttributes = new DoAttributes();
                NamedNodeMap nodeMap = allAttributes.item(i).getAttributes();

                mapNodeMapToDo(doAttributes, nodeMap);

                listDoAttributes.add(doAttributes);
            }
        }

        ApplicationProperties.kfwLogger.log("XML-Datei erfolgreich geladen.");
        
        return listDoAttributes;
    }

    /**
     * Mappen einer NodeMap auf das DO
     * 
     * 16.12.2023, Kai: Methode erstellt.
     * 
     * @param doAttributes DO der Attribute
     * @param nodeMap zu mappende NodeMap
     */
    private void mapNodeMapToDo(DoAttributes doAttributes, NamedNodeMap nodeMap)
    {
        for (String value : ApplicationProperties.getInstance().getAttributeValues())
        {
            Node attributeValue = nodeMap.getNamedItem(value);

            if (attributeValue != null)
            {
                doAttributes.setDoAttribute(value, attributeValue.getNodeValue());
            }
        }
    }
}
