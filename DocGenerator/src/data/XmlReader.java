package data;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * @author Kai
 *
 */
public class XmlReader
{
    /**
     * Lesen einer XML File
     * 
     * 16.12.2023, Kai: Methode erstellt.
     * 
     * @param path Pfad der Datei
     * @return XML Datei bearbeitungsfertig
     */
    public Document readXmlFile(String path)
    {
        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder;
        Document document = null;

        try
        {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return document;
    }
}
