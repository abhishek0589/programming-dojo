package com.abhishek.dojo.graph.salesforce;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: christian
 */
public class ListCommand implements Command {


    @Override
    public Map<String, String> execute(List<String> args) {
        Map<String, String> result = new LinkedHashMap<>();
        Module.getInstalled().forEach(m -> result.put(m.getName(),""));
        return result;
    }

}
