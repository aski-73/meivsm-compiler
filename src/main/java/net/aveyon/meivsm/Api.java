package net.aveyon.meivsm;

import net.aveyon.intermediate_solidity.SmartContractModel;
import net.aveyon.intermediate_solidity.util.Pair;

import java.io.IOException;
import java.io.InputStream;

public interface Api {
    Pair<SmartContractModel, MetaInformation> parse(InputStream plantUmlFile) throws IOException;
}
