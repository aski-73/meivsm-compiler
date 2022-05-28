package net.aveyon.meivsm;

import net.aveyon.intermediate_solidity.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaInformation {

    /**
     * Key: State name.
     * Value: List of {@link Function}s that represent the incoming transitions of the state.
     * Can be used as a helper for further code generation / processing.
     */
    private final Map<String, List<Function>> incomingTransitionMap = new HashMap<>();

    public Map<String, List<Function>> getIncomingTransitionMap() {
        return incomingTransitionMap;
    }
}
