package com.my.demo.utils.ziputil;

import java.io.File;
import java.io.IOException;

/**
 * @author ffdeng2
 */
public class ZipTest {

    public static final String projectId = "iftk";
    public static final String subjectId = "dea7rf";
    public static final String taskId = "0001";
    public static final String dataId = "dataid1";
    public static final String eeg = "eeg";
    public static final String bhv = "bhv";
    public static final String firstqa = "firstqa";

    public static final String path = "C:\\Users\\ffdeng2\\Desktop\\result.zip";

    public static void main(String[] args) {
        try (ZipStream zs = ZipStream.newZip(path)) {
           zs.putDirString(projectId);
           zs.putDirString(subjectId);
           zs.putDirString(taskId);
           zs.putDirString(dataId);
           zs.putDirString(eeg);
           zs.compress(new File("C:\\Users\\ffdeng2\\Desktop\\dea7rf_ceshi001_EEG\\dea7rf_ceshi001.cnt"),
                   subjectId+"_"+taskId+"_"+dataId+"_eeg.cnt");

        } catch (IOException e) {
        }
    }

}
