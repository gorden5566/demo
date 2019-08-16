package com.gorden5566.demos.jni;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author gorden5566
 * @date 2019/08/12
 */
public class JniUtils {

    /**
     * 添加 java.library.path 路径
     *
     * @param libraryPath
     * @throws IOException
     */
    public static void addLibraryDir(String libraryPath) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            for (int i = 0; i < paths.length; i++) {
                if (libraryPath.equals(paths[i])) {
                    return;
                }
            }

            String[] tmp = new String[paths.length + 1];
            System.arraycopy(paths, 0, tmp, 0, paths.length);
            tmp[paths.length] = libraryPath;
            field.set(null, tmp);
        } catch (IllegalAccessException e) {
            throw new IOException("Failed to get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException("Failed to get field handle to set library path");
        }
    }
}
