package business.useCases;

import java.util.List;

import business.taskProcessXmlFile.DoAttributes;
import business.taskProcessXmlFile.TaskProcessXmlFile;
import data.WordGeneator;

/**
 * @author Kai
 *
 */
public class UcGenerateWordFromTo
{
    /**
     * Generieren der Word-Dokumentation zu einem DO
     * 
     * 16.12.2023, Kai: Methode erstellt.
     * @param path
     */
    public void processGenerateWordFromTo(String xmlPath, String wordPath)
    {
        List<DoAttributes> doAttributes = new TaskProcessXmlFile().readDataObject(xmlPath);
        
        new WordGeneator().generateWordDocument(doAttributes, wordPath);
    }
}
