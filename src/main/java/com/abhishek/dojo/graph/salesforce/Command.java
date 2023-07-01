package com.abhishek.dojo.graph.salesforce;

import java.util.List;
import java.util.Map;

public interface Command {
    
    Map<String, String> execute(List<String> args);
}
