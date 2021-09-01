package com.test.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author ffdeng2
 */
public class ZipUtil {

    public static Integer fileType = 1;

    public static String subjectId = "dea7rf";

    public static String pathName = "C:\\Users\\ffdeng2\\Desktop\\EEGQC\\dea7rf_N-back.zip";

    public static void main(String[] args) {
        ZipInputStream mZipin = null;
        File mfie = new File(pathName);
        try {
            mZipin = new ZipInputStream(new FileInputStream(mfie));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ZipEntry mZipen;
        ZipFile mZipFile = null;
        try {
            mZipFile = new ZipFile(pathName);
            String directory = null;
            while ((mZipen = mZipin.getNextEntry()) != null) {
                if (!mZipen.isDirectory()) {
                    String fileName = mZipen.getName();
                    if (fileType.equals(1)) {
                        if (fileName.contains(directory)
                                && !fileName.endsWith(".vhdr")) {
                            System.out.println("錯誤！");
                        }
                        if (!fileName.contains(directory)
                                && !fileName.equals(subjectId + "_N-back" + ".mat")) {
                            System.out.println("錯誤！!");
                        }
                        if (fileName.endsWith(".mat")) {
                            System.out.println("mat--->>>" + directory + fileName);
                        }
                    }
                    if (fileType.equals(2)) {
                        if (!directory.equals(subjectId + "_N-back/")) {
                            System.out.println("錯誤！");
                        }
                        fileName = fileName.substring(directory.length());
                        if (!(fileName.equals(subjectId + "_N-back" + ".edat")
                                || fileName.equals(subjectId + "_N-back" + ".txt"))) {
                            System.out.println("錯誤！!");
                        }
                    }
                    System.out.println(directory + " file:" + mZipen.getName() + " size:" + mZipen.getSize());
                } else {
                    System.out.println("it is directory" + mZipen.getName());
                    directory = mZipen.getName();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException();
        } finally {
            try {
                mZipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
