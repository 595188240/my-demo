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

public class ExtractCallback2 implements IArchiveExtractCallback {

    private int index;
    private IInArchive inArchive;
    private String ourDir;

    public ExtractCallback2(IInArchive inArchive, String ourDir) {
        this.inArchive = inArchive;
        this.ourDir = ourDir;
    }

    @Override
    public void setCompleted(long arg0) {
    }

    @Override
    public void setTotal(long arg0) {
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
                    //if (!isFolder) {
                        if (!path.contains("__MACOSX")) {
                            File file = new File(ourDir + File.separator + path);
                            System.out.println(path + "-->>" + file.getName());
                            if (path.equals(oldPath[0])) {
                                save2File(file, data, true);
                            } else {
                                save2File(file, data, false);
                            }
                            oldPath[0] = path;
                            System.out.println(file.lastModified());
                        }
                    //}
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
        File parent = file.getParentFile();
        if ((!parent.exists()) && (!parent.mkdirs())) {
            return false;
        }
        //是否追加
        try (OutputStream fos = new FileOutputStream(file, append)) {
            fos.write(msg);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}