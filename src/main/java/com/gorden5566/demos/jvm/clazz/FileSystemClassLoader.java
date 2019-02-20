package com.gorden5566.demos.jvm.clazz;

import java.io.*;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-classloader/index.html#code6
 *
 * @author gorden5566
 * @date 2019-02-20
 */
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }

        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        String fullName = rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        System.out.println(fullName);
        return fullName;
    }
}
