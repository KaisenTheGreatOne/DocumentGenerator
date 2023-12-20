# DocumentGenerator
 
Dieses Java-Tool ermöglicht es, Attribute aus einer XML-Datei auszulesen und in Tabellenform in einer Word-Datei zu speichern. Der Anwender kann die zu extrahierenden Attribute und Elemente in der `Properties.json` Datei konfigurieren und das Tool über die Konsole mit den entsprechenden Dateipfaden ausführen.

## Voraussetzungen
- Java 17 oder höher
- Ant (optional, für den Build-Prozess)

## Konfiguration
1. Eine `Properties.json` erstellen, oder die bereits vorhandene verwenden und die zu extrahierenden XML-Attribute und Elemente angeben. Beispiel:
```
{
 	"AttributeNames": ["xmlAttribute"],
  	"AttributeValues": ["name", "dataType", "description"]
}
```
2. Die vorhandene `build.xml` mit dem target **create_run_jar** ausführen.
3. Die generierte `DocGen.jar` über die Kommandozeile mit folgenden Parametern ausführen:
```
java -jar DocGen.jar Pfad/zu/Properties.json Pfad/zu/XML-Datei.xml Pfad/zum/word/Ausgabeordner
```
**Wichtig!**: Immer sicherstellen, dass die Pfade zur Properties.json, XML-Datei und dem Word-Ausgabeordner korrekt angeben sind!

Alternativ kann die Anwendung direkt aus einer integrierten Entwicklungsumgebung (IDE) wie IntelliJ oder Eclipse ausgeführt werden, indem die Main-Klasse gestartet und die erforderlichen Pfade als Argumente übergeben werden.
