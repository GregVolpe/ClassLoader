/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classloadertest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

/**
 *
 * @author HEX
 */
public class JarClassLoader extends URLClassLoader {

    private URL url;

    public JarClassLoader(URL url) {
        super(new URL[]{url});
        this.url = url;
    }

    public String getMainClassName() throws IOException {
        //URL u = new URL("jar", "", url + "MergeSortActivity.jar!/");
        URL u = new URL("jar:http://www.apollophotos.com/cs360/test/MergeSortActivity.jar!/");
        JarURLConnection uc = (JarURLConnection) u.openConnection();
        Attributes attr = uc.getMainAttributes();
        //return uc.getManifest().getMainAttributes().getValue("Main-Class");
        
        return attr != null
                ? attr.getValue(Attributes.Name.MAIN_CLASS)
                : null;
                
    }

    public void invokeClass(String name, String[] args)
            throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        Class<?> c = loadClass(name);
        Method m = c.getMethod("main", String[].class);
        m.setAccessible(true);
        int mods = m.getModifiers();
        if (m.getReturnType() != void.class || !Modifier.isStatic(mods)
                || !Modifier.isPublic(mods)) {
            throw new NoSuchMethodException("main");
        }
        try {
            m.invoke(null, new Object[]{args});
        } catch (IllegalAccessException e) {
            // This should not happen, as we have disabled access checks
        }
    }


}
