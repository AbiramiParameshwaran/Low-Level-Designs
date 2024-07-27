package Prototype;

import java.util.HashMap;
import java.util.Map;

public class NotebookRegistry {
    private Map<String, Notebook> map= new HashMap<>();

    public void registerPrototype(String name, Notebook notebook) {
        map.put(name, notebook);
    }

    public Notebook getPrototype(String name) {
        return  map.get(name);
    }
}
