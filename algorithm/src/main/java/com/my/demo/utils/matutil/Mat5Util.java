package com.my.demo.utils.matutil;

import com.alibaba.fastjson.JSON;
import us.hebi.matlab.mat.format.Mat5;
import us.hebi.matlab.mat.format.Mat5File;
import us.hebi.matlab.mat.types.Array;
import us.hebi.matlab.mat.types.Char;
import us.hebi.matlab.mat.types.Matrix;
import us.hebi.matlab.mat.types.Struct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 */
public class Mat5Util {

    public static String filePath = "C:\\Users\\ffdeng2\\Desktop\\task-rest\\sub03_task-rest_EEG\\results_QA_sub03_task-rest.mat";

    public static void main(String[] args) throws IOException {
        System.out.println(JSON.toJSONString(readMatFile(filePath)));
    }

    public static MetricsResult readMatFile(String path) throws IOException {
        Mat5File file = Mat5.readFromFile(path);
        Struct results_qa = file.getStruct("results_QA");
        MetricsResult result = new MetricsResult();
        List<String> fieldList = MetricsResult.fieldList;
        for (String field : fieldList) {
            if (field.equals(MetricsResult.Fields.badChannels)
                    || field.equals(MetricsResult.Fields.OLRC)) {
                Array array = results_qa.get(field);
                if (array.getNumElements() == 0) {
                    continue;
                }
                Matrix m = (Matrix) array;
                List<String> list = new ArrayList<>();
                for (int i = 0; i < m.getNumCols(); i++) {
                    list.add(String.valueOf(m.getDouble(i)));
                }
                ReflectionUtils.setFieldValue(result, field, new ArrayList<>(list));
                continue;
            }
            if (field.equals(MetricsResult.Fields.DataQualityRating)) {
                Char aChar = results_qa.getChar(field);
                ReflectionUtils.setFieldValue(result, field, aChar);
            } else {
                Matrix matrix = results_qa.getMatrix(field);
                ReflectionUtils.setFieldValue(result, field, matrix);
            }
        }
        return result;
    }
}

