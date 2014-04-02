/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classloadertest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HEX
 */
public class ClassLoaderTest {

    /**
     * @param args the command line arguments
     * @throws java.lang.NoSuchMethodException
     */
    public static void main(String[] args) throws NoSuchMethodException{
        NewJFrame j = new NewJFrame();
        j.setVisible(true);
        /*
         try {
         CustomURLClassLoader loader = new CustomURLClassLoader();
         Class<?> c = loader.loadClass("MergeSortActivity");
         Method m = c.getMethod("main", String[].class);
         try {
         m.invoke(null, (Object) new String[] {});
         } catch (IllegalAccessException ex) {
         Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
         Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InvocationTargetException ex) {
         Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
         }

         } catch (ClassNotFoundException ex) {
         Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        try {
            JarClassLoader jarLoader = new JarClassLoader(new URL("http://apollophotos.com/cs360/test/"));
             try {
                 jarLoader.invokeClass(jarLoader.getMainClassName(), args);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InvocationTargetException ex) {
                 Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

    }

}
