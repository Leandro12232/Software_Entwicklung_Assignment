package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    void testMainOutput() {
        // 🔹 Ausgangs-Streams sichern
        PrintStream originalOut = System.out;

        // 🔹 Neuen Stream zum Abfangen der Ausgabe vorbereiten
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 🔹 main() ausführen
        Main.main(new String[]{});

        // 🔹 Stream wiederherstellen
        System.setOut(originalOut);

        // 🔹 Ausgabe prüfen
        String output = outContent.toString().trim();

        assertTrue(output.contains("Hello and welcome!"), "Begrüßung fehlt in der Ausgabe");
        assertTrue(output.contains("i = 5"), "Schleife wurde nicht vollständig ausgeführt");
    }
}
