package com.aveyon.meivsm;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import com.aveyon.meivsm.parser.PlantUmlLexer;
import com.aveyon.meivsm.parser.PlantUmlParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public final class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Smart Contract als plant Uml einlesen
        // String file = "sm_rental.plantuml";
        String file = "sm_purchase.plantuml";
        // String file = "sm_trip-insurance.plantuml";
        // String file = "sm_crowd-funding.plantuml";

        InputStream in;
        if (args.length > 0) {
            file = args[0];
            in = new FileInputStream(file);
        } else {
            // File files = new File(App.class.getResource("/grammar").toURI());
            // for (File f: files.listFiles())
            //     System.out.println(f.getAbsolutePath());
            in = App.class.getResource("/" + file).openStream();
        }

        // Kompilieren
        MyListener listenerDone = compile(createParseTree(in));
        String contract = listenerDone.getSmartContract().toString();
        // System.out.println(contract);
        try (FileWriter fw = new FileWriter("/tmp/" + listenerDone.getSmartContractName() + ".sol")) {
            fw.write(contract);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("/tmp/" + listenerDone.getSmartContractName() + ".sol");
        // inspect(in);

    }

    public static ParseTree createParseTree(InputStream in) throws IOException {
        CharStream input = CharStreams.fromStream(in);
        // Lexer erstellen
        PlantUmlLexer lexer = new PlantUmlLexer(input);
        // Vom Lexer gelesene Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Parser erzeugen
        PlantUmlParser parser = new PlantUmlParser(tokens);
        // Parsen mit der Root-Grammatikregel starten. Parsetree zurückgeben
        return parser.plantUml();
    }

    public static MyListener compile(ParseTree parseTree) throws IOException {

        ParseTreeWalker walker = new ParseTreeWalker();

        PreListener preListener = new PreListener();
        walker.walk(preListener, parseTree);

        MyListener listener = new MyListener(preListener.getAttributesList(),
                preListener.getStateDefEntryActivitiesMap(), preListener.getStateDefExitActivitiesMap(),
                preListener.isPayStar());
        walker.walk(listener, parseTree);

        return listener;
    }

    public static void inspect(InputStream in) throws IOException {
        CharStream input = CharStreams.fromStream(in);
        // Lexer erstellen
        PlantUmlLexer lexer = new PlantUmlLexer(input);
        // Vom Lexer gelesene Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Parser erzeugen
        PlantUmlParser parser = new PlantUmlParser(tokens);

        org.antlr.v4.gui.Trees.inspect(parser.plantUml(), parser);
    }
}
