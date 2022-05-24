package net.aveyon.meivsm;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;

public class MyListenerTest {

    private MyListener testSubject;

    private ParseTreeWalker walker;

    @Before
    public void setUp() {
        testSubject = new MyListener(new LinkedList<>(), new HashMap<>(), new HashMap<>(), false);
        walker = new ParseTreeWalker();

    }

    // @Test
    public void enterTransCreatesIfStatementWithTwoConditions() throws IOException {
        // GIVEN
        String umlInput = "STATE1 --> STATE2: EingabeAusAlphabet";
        InputStream in = new ByteArrayInputStream(umlInput.getBytes(StandardCharsets.UTF_8));
        ParseTree parseTree = App.createParseTree(in);

        // WHEN
        walker.walk(testSubject, parseTree);

        // THEN
        String expected = "\t\tif (state.isEqual(\"STATE1\") && input.isEqual(\"EingabeAusAlphabet\")){\n)";
        assertEquals(expected, testSubject.getSmartContract());
    }
}
