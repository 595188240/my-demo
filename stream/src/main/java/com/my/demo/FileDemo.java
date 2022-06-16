package com.my.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ffdeng2
 * @date 2022-2-28 14:48
 */
public class FileDemo {

    public static void main(String[] args) {
        String path = "C:\\Users\\ffdeng2\\Desktop\\BHV\\ejmgar_P300run1_EEGBHV.zip";
        File file = new File(path);
        BasicFileAttributes bAttributes = null;
        try {
            bAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileTime fileTime = bAttributes.creationTime();
        System.out.println(fileTime.toString());
        long l = bAttributes.creationTime().toMillis();
        System.out.println(l);
        System.out.println(times(l));
        System.out.println(times(bAttributes.lastModifiedTime().toMillis()));
    }

    public static String times(long timeStamp) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdr.format(new Date(timeStamp));
    }

}
