/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classloadertest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author HEX
 */
public class ClassLoaderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        CustomURLClassLoader loader = new CustomURLClassLoader();
        
        Class<?> c = loader.loadClass("MainActivity.class");
        Method m = c.getMethod("main", String[].class);
         m.invoke(null, (Object) new String[] {});


    }
    
}
