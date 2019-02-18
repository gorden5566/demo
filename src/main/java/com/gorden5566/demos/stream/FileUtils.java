package com.gorden5566.demos.stream;

import java.io.*;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class FileUtils {
    public static void copyFile(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 新建输入流，用于读取文件
            fis = new FileInputStream(src);

            // 新建输出流，用于输出文件
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            // 分批读取文件并输出
            int count = 0;
            while ((count = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入输出流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printFileContent(String fileName) {
        try {
            FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
