package com.my.demo;

/**
 * @author ffdeng2
 * @date 2022-3-23 14:50
 */

import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RAR5Test {

    static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        threadLocal.set(map);
        map.put("fileEmpty", "true");
        String rarDir = "C:\\Users\\ffdeng2\\Desktop\\newDir\\rfam8n_Audiommn_EEG.rar";
        String outDir = "C:\\Users\\ffdeng2\\Desktop\\BHV\\out";
        long begin = System.currentTimeMillis();
        // 第一个参数是需要解压的压缩包路径，第二个参数参考JdkAPI文档的RandomAccessFile
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(rarDir, "r");
             IInArchive inArchive = SevenZip.openInArchive(null,
                     new RandomAccessFileInStream(randomAccessFile))) {
            int[] in = new int[inArchive.getNumberOfItems()];
            for (int i = 0; i < in.length; i++) {
                in[i] = i;
            }
            inArchive.extract(in, true, new ExtractCallback(inArchive, outDir));
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - begin) + "ms");
        Map<String, String> map1 = threadLocal.get();
        map1.forEach((k, v) -> System.out.println("k->" + k +"  " + "v->" + v));
        String path = map1.get("path");
        if (path.contains(File.separator)) {
            System.out.println(path);
            String mkdirName = path.substring(0, path.indexOf("\\"));
            System.out.println("mkdirName---->>>>>>>>>" + mkdirName);
            String[] split = path.split("\\\\");
            System.out.println(Arrays.toString(split));
        }
        threadLocal.remove();
    }

    public static Boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return deleteFile(file);
    }

    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {
            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }

}
