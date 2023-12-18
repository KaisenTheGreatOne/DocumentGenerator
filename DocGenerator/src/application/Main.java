package application;

import business.useCases.UcGenerateWordFromTo;

public class Main {

    /**
     * Einstiegsmethode
     * 
     * 16.12.2023, Kai: Methode erstellt.
     * @param args
     */
	public static void main(String[] args) 
	{
	    new Main(args);
	}
	
	/**
	 * Standardkonstruktor
	 * 
	 * @param args
	 */
	private Main(String[] args) 
	{
	    startApp(args);
	}
	
	/**
	 * Starten der Anwendung
	 * 
	 * 16.12.2023, Kai: Methode erstellt.
	 * @param args
	 */
	private void startApp(String[] args) 
	{
	    ApplicationProperties.kfwLogger.log("Starte Verarbeitung mit folgenden Argumenten:\n- Properties-Pfad: " + args[0] + "\n- XML-Pfad: " + args[1] + "\n- Ziel-Pfad: " + args[2]);
	    ApplicationProperties.getInstance().readPropertiesFile(args[0]);
	    new UcGenerateWordFromTo().processGenerateWordFromTo(args[1], args[2]);;
	}
}
