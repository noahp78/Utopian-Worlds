package noahp78.survive.plugin;


import java.util.ArrayList;
import java.util.List;

public class HandlerRegistry {    
    private static List<Class> handlers = new ArrayList<Class>();

    public static void register(Class clazz) {
        handlers.add(clazz);
    }

    public static List<Class> getHandlers() {
        return handlers;
    }
}