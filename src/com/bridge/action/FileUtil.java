package com.bridge.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    /**
     * ���ļ�д���ƶ���·��
     * 
     * @param file
     * @param path
     */
    public static void writeFileTo(File file, String path) {
        try {
            FileInputStream in = new FileInputStream(file);
            File destFile = new File(path);
            FileOutputStream out = new FileOutputStream(destFile);
            byte[] b = new byte[in.available()];
            in.read(b);
            in.close();
            out.write(b);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ���ļ�д���ƶ���·��
     * 
     * @param file
     * @param path
     */
    public static void writeFileTo(File[] file, String path) {
        for (File f : file) {
            writeFileTo(f, path);
        }
    }
}
