package com.my.demo.utils.ziputil;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author ljgeng
 *
 */
public class ZipStream implements Closeable {

    private static final int BUFFER = 4096;

    private ZipOutputStream out;

    ZipFile zipFile;

    private String extraPath;

    MessageDigest digest;

    private StringBuilder pathBuilder = new StringBuilder();

    private Set<String> zipEntries = new HashSet<>();

    public ZipStream() {
        try {
            this.digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static ZipStream newZip(String zipFileName) throws IOException {
        ZipStream zipStream = new ZipStream();
        zipStream.out = new ZipOutputStream(new FileOutputStream(zipFileName));
        return zipStream;
    }

    public static ZipStream unZip(String zipFileName) throws IOException {
        ZipStream zipStream = new ZipStream();
        zipStream.zipFile = new ZipFile(zipFileName, Charset.forName("gbk"));
        return zipStream;
    }

    public ZipStream putExtraPath(String extraPath) {
        this.extraPath = extraPath;
        return this;
    }

    /**
     * 解压目录
     * @throws IOException
     */
    public void decompress() throws IOException {
        Enumeration<?> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.isDirectory()) {
                File file = new File(this.extraPath + "/" + entry.getName());
                file.mkdirs();
                continue;
            }
            createFile(zipFile, entry);
        }
    }

    private void createFile(ZipFile zipFile, ZipEntry entry) throws IOException {
        File file = new File(this.extraPath + "/" + entry.getName());
        try (InputStream is = zipFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER)) {
            byte buf[] = new byte[BUFFER];
            int l;
            while ((l = is.read(buf)) != -1) {
                bos.write(buf, 0, l);
                this.digest.update(buf,0,l);
            }
        }
    }

    public ZipStream putDirString(String path) {
        this.pathBuilder.append(path).append("/");
        return this;
    }

    /**
     * 打包目录
     *
     * @param file
     * @param name
     * @return
     * @throws IOException
     */
    public ZipStream compress(File file,String name) throws IOException {
        if (name == null) {
            name = file.getName();
        }
        putFile(this.pathBuilder.toString() + name, file);
        return this;
    }

    private void putFile(String entryName, File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            String name = entryName + "/";
            if(!zipEntries.contains(name)){
                out.putNextEntry(new ZipEntry(name));
                zipEntries.add(name);
            }
            for (int i = 0; i < files.length; i++) {
                putFile(entryName + "/" + files[i].getName(), files[i]);
            }
        } else {
//            String name = file.getName();
//            String suf = name.substring(name.lastIndexOf("."));
//            String allName = entryName + suf;
//            boolean flag = zipEntries.add(allName);
//            if(!flag){
//                String suffix = name.substring(name.lastIndexOf(Constants.DIR_COM));
//                allName = entryName +suffix;
//                zipEntries.add(allName);
//            }
            out.putNextEntry(new ZipEntry(entryName));
            try (FileInputStream in = new FileInputStream(file);) {
                byte[] b = new byte[BUFFER];
                int l;
                while ((l = in.read(b)) != -1) {
                    this.digest.update(b,0,l);
                    out.write(b, 0, l);
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (this.out != null) {
            out.close();
        }
        if (zipFile!= null) {
            zipFile.close();
        }
    }

//    public static void main(String[] args) {
//        try(ZipStream zs = ZipStream.unZip("D:\\iflytek\\test.zip");) {
////            zs.putDirString("abc");
////            zs.putDirString("aaa");
////            zs.compress(new File("D:\\iflytek\\123"),null);
////            zs.compress(new File("D:\\iflytek\\456"),"788");
//            zs.putExtraPath("D:\\iflytek\\agv");
//            zs.decompress();
//            System.out.println(zs.md5());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public void clear() {
        this.pathBuilder = new StringBuilder();
    }
}
