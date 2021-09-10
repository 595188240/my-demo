package com.my.demo.utils.ziputil;

import com.my.demo.utils.matutil.Mat5Util;
import com.my.demo.utils.matutil.MetricsResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author ffdeng2
 */
public class UnZipCheckFile {

    public static String path = "C:\\Users\\ffdeng2\\Desktop\\";

    public static String fileName = "dea7rf_ceshi001_EEG.zip";

    public static Integer fileType = 1;

    public static String subjectId = "dea7rf";

    public static String retryCount = "";

    public static String taskName = "ceshi001";

    public static void main(String[] args) {
        checkFileContent(fileName, path, fileType, subjectId, retryCount, taskName);
    }

    private static List<MetricsResult> checkFileContent(String fileName, String filePath,
                                                 Integer fileType, String subjectId,
                                                 String retryCount, String taskName) {
        List<MetricsResult> results = null;
        ZipInputStream mZipin = null;
        File mfie = new File(filePath + fileName);
        try {
            mZipin = new ZipInputStream(new FileInputStream(mfie));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ZipEntry mZipen;
        String directory = "";
        String dirName = subjectId + "_" +  taskName + retryCount;
        try (ZipFile ignored = new ZipFile(filePath + fileName)) {
            while ((mZipen = mZipin.getNextEntry()) != null) {
                if (!mZipen.isDirectory()) {
                    String tempFileName = mZipen.getName();
                    String subName = tempFileName.substring(directory.length());
                    if (fileType.equals(1)) {
                        if (!(subName.equals(dirName + ".cnt") || subName.equals(dirName + ".dat")
                                || subName.equals(dirName + ".vhdr") || subName.equals(dirName + ".vmrk")
                                || subName.equals(dirName + "_QA" + ".mat"))) {
                            System.out.println("file name  error " + subName);
                        }
                        if (subName.equals(dirName + "_QA" + ".mat")) {
                            System.out.println(filePath + tempFileName);
                            MetricsResult metricsResult = Mat5Util.readMatFile(filePath + tempFileName);
                            System.out.println(metricsResult);
                        }
                    }
                    if (fileType.equals(2)) {
                        if (!(tempFileName.equals(dirName + ".edat") || tempFileName.equals(dirName + ".txt"))) {
                            System.out.println("file name error " + tempFileName);
                        }
                    }
                } else {
                    directory = mZipen.getName();
                    if (fileType.equals(1)) {
                        String tempName =  dirName + "_EEG";
                        if (!tempName.equals(directory.substring(0, directory.length() - 1))) {
                            System.out.println("error 1");
                        }
                    }
                    if (fileType.equals(2)) {
                        String tempName =  dirName + "_EEGBHV";
                        if (!tempName.equals(directory.substring(0, directory.length() - 1))) {
                            System.out.println("error 2");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
