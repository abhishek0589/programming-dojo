package com.abhishek.dojo.graph.salesforce;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by IntelliJ IDEA.
 * User: christian
 */
public class RemoveCommand implements Command {

    @Override
    public Map<String, String> execute(List<String> args) {
        Module d = Module.getInstance(args.get(0));
        if(d != null)
            return uninstall(d);
        Map<String,String> result = new LinkedHashMap<>();
        result.put(args.get(0),"is not installed");
        return result;
    }

    private Map<String, String> uninstall(Module parent) {
        Map<String, String> result = new HashMap<>();
        //get items dependent on current dependecies. if any of the items are installed, inform that parent is needed
        Set<Module> installedDependents = parent.getDependents().stream().filter(Module::isInstalled).collect(toSet());
        if(installedDependents.isEmpty()) {
            result.put(parent.getName(),"successfully removed");
            parent.setInstalled(false);
            //remove dependencies if possible
            for (Module dependency : parent.getDependencies()) {
                if(dependency.isInstalled()) {
                    result.putAll(uninstall(dependency));
                }
            }
        }
        else {
            result.put(parent.getName(),"is still needed.");
        }
        return result;
    }
}
