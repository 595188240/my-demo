package com.my.demo;

/**
 * @author ffdeng2
 * @date 2022-3-23 14:51
 */

import net.sf.sevenzipjbinding.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ExtractCallback implements IArchiveExtractCallback {

    private int index;
    private IInArchive inArchive;
    private String ourDir;

    public ExtractCallback(IInArchive inArchive, String ourDir) {
        this.inArchive = inArchive;
        this.ourDir = ourDir;
    }

    @Override
    public void setCompleted(long arg0) {
    }

    @Override
    public void setTotal(long arg0) {
    }

    public String times(long timeStamp) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdr.format(new Date(timeStamp));
    }

    @Override
    public ISequentialOutStream getStream(int index, ExtractAskMode extractAskMode) throws SevenZipException {
        this.index = index;
        final String path = (String) inArchive.getProperty(index, PropID.PATH);
        final boolean isFolder = (boolean) inArchive.getProperty(index, PropID.IS_FOLDER);
        final String[] oldPath = {""};

        return new ISequentialOutStream() {
            @Override
            public int write(byte[] data) {
                try {
                    if (!path.contains("__MACOSX")) {
                        File file = new File(ourDir + File.separator + path);
                        System.out.println(path + "-->>" + file.getName());
                        Map<String, String> map = RAR5Test.threadLocal.get();
                        map.put("fileEmpty", "false");
                        if (path.contains(".mff")) {
                            map.put("mffPath", path);
                        } else {
                            map.put(file.getName(), null);
                            map.put("path", path);
                        }
                        if (file.getName().endsWith(".mat")) {
                            map.put("matPath", ourDir + "\\" + path);
                            if (path.equals(oldPath[0])) {
                                save2File(file, data, true);
                            } else {
                                save2File(file, data, false);
                            }
                        }
                        if (file.getName().endsWith("_info.json")) {
                            map.put("jsonPath", ourDir + "\\" + path);
                            if (path.equals(oldPath[0])) {
                                save2File(file, data, true);
                            } else {
                                save2File(file, data, false);
                            }
                        }
                        oldPath[0] = path;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return data.length;
            }
        };
    }

    @Override
    public void prepareOperation(ExtractAskMode arg0) {
    }

    @Override
    public void setOperationResult(ExtractOperationResult extractOperationResult) {
    }

    public boolean save2File(File file, byte[] msg, boolean append) {
        OutputStream fos = null;
        try {
            File parent = file.getParentFile();
            if ((!parent.exists()) && (!parent.mkdirs())) {
                return false;
            }
            //是否追加
            fos = new FileOutputStream(file, append);
            fos.write(msg);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }

}