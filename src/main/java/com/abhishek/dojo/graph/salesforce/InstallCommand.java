package com.abhishek.dojo.graph.salesforce;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: christian
 * To change this template use File | Settings | File Templates.
 */
public class InstallCommand implements Command {

    @Override
    public Map<String, String> execute(List<String> args) {
        Map<String, String> result = new LinkedHashMap<>();
        for (String depName : args) {
            Module dep = Module.getInstance(depName);
            install(dep, result);
        }
        return result;
    }

    private Map<String, String> install(Module current, Map<String, String> result) {
        if (!current.isInstalled()) {
            current.setInstalled(true);

            for (Module dependency : current.getDependencies()) {
                if (!dependency.isInstalled()) { // not entirely necessary
                    install(dependency, result);
                }

            }
            result.put(current.getName(), "successfully installed");
        }
        else {
            result.put(current.getName(), "is already installed");

        }
        return result;
    }
}
