package net.aveyon.meivsm;

import net.aveyon.intermediate_solidity.ExpressionIf;
import net.aveyon.intermediate_solidity.SmartContractModel;
import net.aveyon.intermediate_solidity.util.Pair;
import net.aveyon.intermediate_solidity_extractor.IntermediateSolidityExtractor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Objects;

public class AppTest {
    IntermediateSolidityExtractor extractor = new IntermediateSolidityExtractor();

    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void compileStringAttributeWithWhitespaces() throws IOException {
        // GIVEN
        String givenPlantUml = "" +
            "@startuml testContract\n" +
            "[*] -> test\n" +
            "test: entry/ title: string = \"IrgendeinProjekt Mit Leerzeichen\"\n" +
            "@enduml\n";

        // WHEN
        String contract = new App().compile(new ByteArrayInputStream(givenPlantUml.getBytes()));

        // THEN
        String expectedSolidity = "";
        System.out.println(contract);
    }

    @Test
    public void appGeneratesCorrectSmartContractModel() throws IOException {
        // GIVEN
        String givenPlantUml =
            "@startuml testContract\n" +
                "[*] -> StateA\n" +
                "StateA: entry/ i: int = 1\n" +
                "StateA -> StateB\n" +
                "StateB: entry/ title: string = \"IrgendeinProjekt Mit Leerzeichen\"\n" +
                "@enduml\n";

        // WHEN
        Pair<SmartContractModel, MetaInformation> model = new App().parse(new ByteArrayInputStream(givenPlantUml.getBytes()));
        IntermediateSolidityExtractor extractor = new IntermediateSolidityExtractor();
        System.out.println(extractor.generateSmartContractModel(model.getFirst()));

        // THEN
        // correct contract name
        assertEquals("testContract", model.getFirst().getDefinitions().getContracts().get(0).getName());
        // has 3 field declarations (state, i and title)
        assertEquals(3, model.getFirst().getDefinitions().getContracts().get(0).getFields().size());
        // has the ctor
        assertNotNull(model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getConstructor());
        // has 1 expression in constructor (call to init)
        assertEquals(1, model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getConstructor().getExpressions().size());
        // has the init function
        assertNotNull(model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(0));
        assertEquals("init", model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(0).getName());
        // has 3 expression in init func (comment, state transition and value assignment)
        assertEquals(3, model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(0).getExpressions().size());
        // has the handle function
        assertNotNull(model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(1));
        // handle function contains an if expression
        assertTrue(model.getFirst().getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(1).getExpressions().get(0) instanceof ExpressionIf);
    }

    @Test
    public void appGeneratesCorrectPurchaseContractModelWith7IfConditions() throws IOException {
        // GIVEN
        String plantUmlFile = Objects.requireNonNull(this.getClass().getClassLoader().getResource("purchase_test.plantuml"))
            .getPath();
        FileInputStream fis = new FileInputStream(plantUmlFile);

        // WHEN
        Pair<SmartContractModel, MetaInformation> model = new App().parse(fis);
        System.out.println(extractor.generateSmartContractModel(model.getFirst()));

        // THEN
        // handle function is the second function of the contract. First one is the init() function
        ExpressionIf handleFunctionIf = (ExpressionIf) model.getFirst().getDefinitions()
            .getContracts().get(0)
            .getDefinitions()
            .getFunctions().get(1)
            .getExpressions().get(0);

        assertEquals(7, handleFunctionIf.getConditions().size());
    }

    @Test
    public void appGeneratesIncomingTransitionMapWith2EntriesForExampleState() throws IOException {
        // GIVEN
        String givenPlantUml =
            "@startuml testContract\n" +
                "[*] -> Test: call()\n" +
                "Test -> ExampleState: read()\n" +
                "[*] -> ExampleState: directRead()\n" +
                "@enduml\n";

        // WHEN
        Pair<SmartContractModel, MetaInformation> model = new App().parse(new ByteArrayInputStream(givenPlantUml.getBytes()));

        // THEN
        assertEquals(2, model.getSecond().getIncomingTransitionMap().get("ExampleState".toUpperCase()).size());
    }

    /**
     * Current global variables and what it should be translated to:
     * - balance => this.balance
     */
    @Test
    public void appGeneratesTranslatesGlobalVariablesCorrectly() throws IOException {
        // GIVEN
        String givenPlantUml =
            "@startuml testContract\n" +
                "[*] -> Test: call\n" +
                "Test: entry/ call(balance)\n" +
                "Test: entry/ transfer balance to msg.sender\n" +
                "[Test] -> [*]: directRead()\n" +
                "@enduml\n";

        // WHEN
        Pair<SmartContractModel, MetaInformation> model = new App().parse(new ByteArrayInputStream(givenPlantUml.getBytes()));
        String extracted = extractor.generateSmartContractModel(model.getFirst());
        System.out.println(extracted);

        // THEN
        assertTrue(extracted.contains("address(this).balance"));
    }

    @Test
    public void appGeneratesSimpleRentalContract() throws IOException {
        // GIVEN
        String plantUmlFile = Objects.requireNonNull(this.getClass().getClassLoader().getResource("sm_rental_ma_test.plantuml"))
            .getPath();
        assertNotNull(plantUmlFile);
        FileInputStream fis = new FileInputStream(plantUmlFile);

        // WHEN
        String contract = new App().compile(fis);

        // THEN
        System.out.println(contract);
    }
}
