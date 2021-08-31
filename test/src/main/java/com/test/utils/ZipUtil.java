package com.test.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author ffdeng2
 */
public class ZipUtil {

    public static Integer fileType = 2;

    public static String subjectId = "dea7rf";

    public static void main(String[] args) {
        ZipInputStream mZipin = null;
        File mfie = new File("C:\\Users\\ffdeng2\\Desktop\\EEGBHV\\dea7rf_N-back_BHV.zip");
        try {
            mZipin = new ZipInputStream(new FileInputStream(mfie));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ZipEntry mZipen;
        ZipFile mZipFile = null;
        try {
            mZipFile = new ZipFile("C:\\Users\\ffdeng2\\Desktop\\EEGBHV\\dea7rf_N-back_BHV.zip");
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
