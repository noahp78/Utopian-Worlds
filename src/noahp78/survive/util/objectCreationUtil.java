package noahp78.survive.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class objectCreationUtil {
	 public static Object createObject(Constructor constructor,
		      Object[] arguments) {

		    System.out.println("Constructor: " + constructor.toString());
		    Object object = null;

		    try {
		      object = constructor.newInstance(arguments);
		      System.out.println("Object: " + object.toString());
		      return object;
		    } catch (InstantiationException e) {
		    	logManager.LogCrash(e.getStackTrace().toString());
		      //handle it
		    } catch (IllegalAccessException e) {
		    	logManager.LogCrash(e.getStackTrace().toString());
		      //handle it
		    } catch (IllegalArgumentException e) {
		    	logManager.LogCrash(e.getStackTrace().toString());
		      //handle it
		    } catch (InvocationTargetException e) {
		    	logManager.LogCrash(e.getStackTrace().toString());
		      //handle it
		    }
		    return object;
		  }
}
