package net.aveyon.meivsm;

import java.io.*;
import java.util.Objects;

import net.aveyon.meivsm.parser.PlantUmlLexer;
import net.aveyon.meivsm.parser.PlantUmlParser;

import net.aveyon.intermediate_solidity.SmartContractModel;
import net.aveyon.intermediate_solidity_extractor.IntermediateSolidityExtractor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Generates smart contract files by using the Extended Generation Gap (EGG) Pattern
 */
public final class App implements Api {
    public static void main(String[] args) {
        // Smart Contract als plant Uml einlesen
        String file = "sm_purchase.plantuml";

        try (InputStream in = args.length > 0 ? new FileInputStream(args[0])
            : Objects.requireNonNull(App.class.getResource("/" + file)).openStream()){
            App app = new App();

            System.out.println(app.compile(in));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
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

    public String compile(InputStream plantUmlFile) throws IOException {
        IntermediateSolidityExtractor extractor = new IntermediateSolidityExtractor();
        return extractor.generateSmartContractModel(parse(plantUmlFile));
    }

    @Override
    public SmartContractModel parse(InputStream plantUmlFile) throws IOException {
        return walkParseTree(createParseTree(plantUmlFile));
    }

    /**
     * The actual parsing of the provided plant uml file
     */
    static ParseTree createParseTree(InputStream in) throws IOException {
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

    /**
     * @param parseTree A parse tree representing a solidity file created by the solidity parser
     * @return A {@link SmartContractModel} instance representing the provided parseTree
     */
    private static SmartContractModel walkParseTree(ParseTree parseTree) {

        ParseTreeWalker walker = new ParseTreeWalker();

        PreListener preListener = new PreListener();
        walker.walk(preListener, parseTree);

        MyListener listener = new MyListener(preListener.getAttributesList(),
            preListener.getStateDefEntryActivitiesMap(), preListener.getStateDefExitActivitiesMap(),
            preListener.isPayStar());
        walker.walk(listener, parseTree);

        System.out.println(listener.getSmartContract().toString());

        return listener.getModel();
    }
}
