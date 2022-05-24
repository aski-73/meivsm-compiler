package net.aveyon.meivsm;

import net.aveyon.intermediate_solidity.ExpressionIf;
import net.aveyon.intermediate_solidity.SmartContractModel;
import net.aveyon.intermediate_solidity_extractor.IntermediateSolidityExtractor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Objects;

public class AppTest {

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
        String givenPlantUml = ""+
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
"[*] -> test\n" +
"test: entry/ title: string = \"IrgendeinProjekt Mit Leerzeichen\"\n" +
"@enduml\n";

        // WHEN
        SmartContractModel model = new App().parse(new ByteArrayInputStream(givenPlantUml.getBytes()));
        IntermediateSolidityExtractor extractor = new IntermediateSolidityExtractor();
        System.out.println(extractor.generateSmartContractModel(model));
        // THEN

        assertEquals(model.getDefinitions().getContracts().get(0).getName(), "testContract");
        assertNotNull(model.getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(0));
        assertTrue(model.getDefinitions().getContracts().get(0).getDefinitions().getFunctions().get(0).getExpressions().get(0) instanceof ExpressionIf);
    }

    @Test
    public void appGeneratesCorrectPurchaseContractModelWith8States() throws IOException {
        // GIVEN
        String plantUmlFile = Objects.requireNonNull(this.getClass().getClassLoader().getResource("purchase_test.plantuml"))
            .getPath();
        FileInputStream fis = new FileInputStream(plantUmlFile);

        // WHEN
        SmartContractModel model = new App().parse(fis);
        IntermediateSolidityExtractor extractor = new IntermediateSolidityExtractor();
        System.out.println(extractor.generateSmartContractModel(model));

        // THEN
        ExpressionIf handleFunctionIf = (ExpressionIf) model.getDefinitions()
            .getContracts().get(0)
            .getDefinitions()
            .getFunctions().get(0)
            .getExpressions().get(0);

        assertEquals(handleFunctionIf.getConditions().size(), 8);
    }
}
