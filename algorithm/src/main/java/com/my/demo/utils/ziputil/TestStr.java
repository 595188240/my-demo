package com.my.demo.utils.ziputil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ffdeng
 * @date 2021/6/9 17:18
 */
public class TestStr {

    public static final String TEMP_PATH = "unzip_tmp";


    public static void main(String[] args) {
        String parentPath = "C:\\Users\\ffdeng2\\Desktop\\文件文件夹";
        System.out.println(unzip(parentPath));
    }

    public static String unzip(String parentPath) {
        File file = new File(parentPath);
        if (!file.exists()) {
            return null;
        }
        // files 用户上传的所有文件
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        // tmpPath 文件解压的临时空间
        String tmpPath = parentPath + File.separator + TEMP_PATH + File.separator;
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        List<File> zipFiles = Arrays.stream(files).collect(Collectors.toList());
        // 解压文件
        zipFiles.forEach(zf -> {
            try (ZipStream zipStream = ZipStream.unZip(zf.getAbsolutePath())) {
                zipStream.putExtraPath(tmpPath);
                zipStream.decompress();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmpPath;
    }
}
