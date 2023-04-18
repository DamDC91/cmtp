package cmtp.plugin;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

import cmtp.AbstractPlugin;

import java.io.BufferedReader;

public class PluginManager {
	
	static private final String packageName = "cmtp.plugin"; 

    static public Set<String> getAllPlugins() {
        InputStream stream = ClassLoader.getSystemClassLoader()
          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
          .filter(line -> line.endsWith(".class"))
          .map(line -> getClassName(line, packageName))
          .filter(classname -> isPlugin(classname))
          .collect(Collectors.toSet());
    }
    
    static private boolean isPlugin(String className)
    {
    	try {
        	Class<?> c = Class.forName(packageName + "."
                    + className);
        	return (AbstractPlugin.class.isAssignableFrom(c));    	
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    return false;
    }
 
    static private String getClassName(String className, String packageName) {
    	return className.substring(0, className.lastIndexOf('.'));
    }
    
    static public Class<? extends AbstractPlugin> getPlugin(String className) {
    	if(isPlugin(className))
    	{
	        try {
	        	return Class.forName(packageName + "."
	                    + className).asSubclass(AbstractPlugin.class);
	        } catch (ClassNotFoundException e) {
	        	e.printStackTrace();
	        }
    	}
        return null;
    }
    
    
}