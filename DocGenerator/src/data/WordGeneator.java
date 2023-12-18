package data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

import application.ApplicationProperties;
import business.taskProcessXmlFile.DoAttributes;

/**
 * @author Kai
 *
 */
public class WordGeneator
{
    public void generateWordDocument(List<DoAttributes> doAttributes, String path)
    {
        ApplicationProperties.kfwLogger.log("Generiere Word-Dokument...");

        try (XWPFDocument document = new XWPFDocument())
        {
            XWPFTable table = document.createTable(doAttributes.size() + 1, 3);

            populateTableWithData(table, doAttributes);

            FileOutputStream out = new FileOutputStream(path + "/GenerierteWord.docx");
            document.write(out);
            out.close();

            ApplicationProperties.kfwLogger
                    .log("Word-Dokument erfolgreich an " + path + "/GenerierteWord.docx generiert.");
        }
        catch (IOException e)
        {
            ApplicationProperties.kfwLogger.logError("Während der generierung des Word-Dokuments ist ein Fehler aufgetreten.");
            e.printStackTrace();
        }
    }

    private void populateTableWithData(XWPFTable table, List<DoAttributes> doAttributes)
    {
        // Restlichen Daten setzen
        int rowCounter = 1;
        for (DoAttributes attributeDo : doAttributes)
        {
            HashMap<String, String> allAttributeValues = attributeDo.getDoAttributes();

            for (int i = 0; i < allAttributeValues.keySet().size(); i++)
            {
                String key = allAttributeValues.keySet().toArray()[i].toString();
                XWPFTableCell newCell = table.getRow(rowCounter).getCell(i);
                XWPFTableCell headerCell = table.getRow(rowCounter - 1).getCell(i);

                // Überschriften setzen
                if (rowCounter == 1)
                {
                    headerCell.setText(key);
                    headerCell.setColor("c4c2c2");
                }

                newCell.setText(allAttributeValues.get(key));
            }

            rowCounter++;
        }
    }
}
