package cmtp;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.BufferedReader;

public class AccessingAllClassesInPackage {

    static public Set<String> findAllClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
          .filter(line -> line.endsWith(".class"))
          .map(line -> getClassName(line, packageName))
          .collect(Collectors.toSet());
    }
 
    static private String getClassName(String className, String packageName) {
    	return className.substring(0, className.lastIndexOf('.'));
    }
}