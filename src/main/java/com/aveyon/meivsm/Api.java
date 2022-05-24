package com.aveyon.meivsm;

import net.aveyon.intermediate_solidity.SmartContractModel;

import java.io.IOException;
import java.io.InputStream;

public interface Api {
    SmartContractModel parse(InputStream plantUmlFile) throws IOException;
}
