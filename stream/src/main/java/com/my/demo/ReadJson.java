package com.my.demo;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author ffdeng2
 * @date 2022-4-7 10:01
 */
public class ReadJson {

    public static void main(String[] args) {
        String path = "C:\\Users\\ffdeng2\\Desktop\\BHV\\ejmgar_P300run1_EEG\\ejmgar_P300run1_info.json";
        String str = readFile(path);
        System.out.println(str);
        Map maps = (Map) JSON.parse(str);
        Object event = maps.get("event");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(event.toString(), df);
        System.out.println(ldt);
    }

    public static String readFile(String filePath) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] buffer = new byte[1024];
        int count;
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            while (-1 != (count = inputStream.read(buffer))) {
                stringBuffer.append(new String(buffer, 0, count));
            }
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringBuffer.toString();
    }

}
