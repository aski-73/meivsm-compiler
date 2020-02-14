package com.aveyon.meivsm;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

import com.aveyon.meivsm.parser.PlantUmlLexer;
import com.aveyon.meivsm.parser.PlantUmlParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AppTest {

    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    public void compileStringAttributeWithWhitespaces() throws IOException {
        // GIVEN
        String givenPlantUml = ""+
"@startuml testContract" +
"[*] -> test" +
"test: entry/ title: string = \"IrgendeinProjekt Mit Leerzeichen\"" +
"@enduml";  

        // WHEN
        MyListener listenerDone = App.compile(createParseTree(givenPlantUml));
        String contract = listenerDone.getSmartContract().toString();

        // THEN
        String expectedSolidity = "";
        System.out.println(contract);
    }

    private ParseTree createParseTree(String plantUml) {
        CharStream input = CharStreams.fromString(plantUml);
        // Lexer erstellen
        PlantUmlLexer lexer = new PlantUmlLexer(input);
        // Vom Lexer gelesene Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Parser erzeugen
        PlantUmlParser parser = new PlantUmlParser(tokens);
        // Parsen mit der Root-Grammatikregel starten. Parsetree zurückgeben
        return parser.plantUml();
    }
}
