package com.my.demo.utils.fileutil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljgeng
 *
 */
public final class FileUtil {

    private FileUtil() {}

    /**
     * 清空目录
     * @param target
     */
    public static void clear(String target) {
        File targetFile = new File(target);
        if (!targetFile.isDirectory()) {
            return;
        }
        try {
            FileUtils.cleanDirectory(targetFile);
        } catch (IOException e) {
        }
        targetFile.delete();
    }

    /**
     * 递归获取目录下所有文件
     * @param dir
     * @return
     */
    public static List<File> getAllFile(File dir) {
        if (dir == null || dir.isFile()) {
            throw new IllegalArgumentException();
        }
        List<File> files = new ArrayList<>();
        File[] arr = dir.listFiles();
        for (File f : arr) {
            if (f.isFile()) {
                files.add(f);
            } else {
                files.addAll(getAllFile(f));
            }
        }
        return files;
    }
}
