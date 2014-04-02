package classloadertest;

import java.net.*;
import java.security.*;

public class CustomURLClassLoader extends URLClassLoader {

    static URL urls[];

    static {
        try {
            urls = new URL[1];
            urls[0] = new URL("http://apollophotos.com/cs360/mergesort/");
            //urls[0] = new URL("file:/home/classes/TaskScheduling.jar");
            // urls[0] = new URL("file:localhost\\TaskScheduling.jar");
        } catch (Exception e) {
            throw new RuntimeException("Can't create URLs " + e);
        }
    }

    ;

    public CustomURLClassLoader() {
        super(urls);
    }

    public final synchronized Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        // First check if we have permission to access the package.
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            int i = name.lastIndexOf('.');
            if (i != -1) {
                sm.checkPackageAccess(name.substring(0, i));
            }
        }
        return super.loadClass(name, resolve);
    }

    protected Class findClass(final String name)
            throws ClassNotFoundException {
        // First check if we have permission to access the package.
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            int i = name.lastIndexOf('.');
            if (i != -1) {
                sm.checkPackageDefinition(name.substring(0, i));
            }
        }
        return super.findClass(name);
    }

    protected PermissionCollection getPermissions(CodeSource codesource) {
        // Use all the standard permissions, plus allow the code to
        // exit the VM.
        PermissionCollection pc = super.getPermissions(codesource);
        pc.add(new RuntimePermission("exitVM"));
        return pc;
    }
/*
    public void getJAR() throws IOException {
        URL u = new URL("jar:http://apollophotos.com/cs360/MergeSortActivity.jar!/");
        JarURLConnection uc = (JarURLConnection) u.openConnection();
        Attributes attr = uc.getMainAttributes();
        String name = attr.getValue(Attributes.Name.MAIN_CLASS);
        try {
            invokeClassJAR(name);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomURLClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CustomURLClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CustomURLClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void invokeClassJAR(String name)
            throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        Class c = loadClass(name);
        Method m = c.getMethod("main", new Class[]{});
        m.setAccessible(true);
        int mods = m.getModifiers();
        if (m.getReturnType() != void.class || !Modifier.isStatic(mods)
                || !Modifier.isPublic(mods)) {
            throw new NoSuchMethodException("main");
        }
        try {
            m.invoke(null, (Object) new String[] {});
        } catch (IllegalAccessException e) {
            // This should not happen, as we have disabled access checks
        }
    }
}
/*
 protected Class<?> findClass(String name) throws ClassNotFoundException {
 byte[] classBytes = null;
 try {
 classBytes = loadClassBytes(name);
 } catch (IOException e) {
 throw new ClassNotFoundException(name);
 }

 Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
 if (cl == null) {
 throw new ClassNotFoundException(name);
 }
 return cl;
 }

 private byte[] loadClassBytes(String name) throws IOException {
 String cname = name.replace('.', '/') + ".class";
 FileInputStream in = null;
 in = new FileInputStream(cname);
 try {
 ByteArrayOutputStream buffer = new ByteArrayOutputStream();
 int ch;
 while ((ch = in.read()) != -1) {
 byte b = (byte) (ch - key);
 buffer.write(b);
 }
 in.close();
 return buffer.toByteArray();
 } finally {
 in.close();
 }
 }
*/
 private int key;
 }

