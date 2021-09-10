package com.my.demo.utils.fileutil;

import com.my.demo.utils.ziputil.ZipStream;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 */
public class FileTest {

    public static final String path = "C:\\Users\\ffdeng2\\Desktop\\result.zip";
    public static final String projectId = "iftk";
    public static final String subjectId = "dea7rf";
    public static final String taskId = "0001";
    public static final String dataId = "dataid1";
    public static final String eeg = "eeg";
    public static final String bhv = "bhv";
    public static final String firstqa = "firstqa";

    public static void main(String[] args) {
        File file = new File("C:\\Users\\ffdeng2\\Desktop\\文件文件夹\\unzip_tmp\\");
        List<File> dirList = new ArrayList<>();
        getAllDir(file, dirList);
        dirList.stream().filter(f ->
            f.getName().endsWith("_EEG")).forEach(f -> {
            try (ZipStream zs = ZipStream.newZip(path)) {
                zs.putDirString(projectId);
                zs.putDirString(subjectId);
                zs.putDirString(taskId);
                zs.putDirString(dataId);
                zs.putDirString(eeg);

                //找出目录下所有的文件进行压缩
                List<File> allFile = FileUtil.getAllFile(f);
                allFile.stream().filter(ff -> !ff.getName().endsWith(".mat")).forEach(fff -> {
                    System.out.println(fff);
                    try {
                        zs.compress(fff, subjectId + "_" + taskId + "_" + dataId + "_eeg" + fff.getName().substring(fff.getName().lastIndexOf(".")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
            }
        });
    }

    private static void getAllDir(File file, List<File> dirList) {
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                dirList.add(f);
                getAllDir(f, dirList);
            }
        }
    }
}
