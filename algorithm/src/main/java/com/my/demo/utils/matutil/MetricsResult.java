package com.my.demo.utils.matutil;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangzhang17
 */
@Data
@ToString
@FieldNameConstants
public class MetricsResult {

    public static List<String> fieldList;

    static {
        fieldList = new ArrayList<>();
        fieldList.add(Fields.OLC);
        fieldList.add(Fields.OHA);
        fieldList.add(Fields.OLRC);
        fieldList.add(Fields.OBClus);
        fieldList.add(Fields.allMAV);
        fieldList.add(Fields.NBC);
        fieldList.add(Fields.badChannels);
        fieldList.add(Fields.OBC);
        fieldList.add(Fields.goodMAV);
        fieldList.add(Fields.ONS);
        fieldList.add(Fields.OFN);
        fieldList.add(Fields.DataQualityRating);
        fieldList.add(Fields.badMAV);
        fieldList.add(Fields.ODQ);
    }

    private String ONS;
    private String OHA;
    private String OFN;
    private String OLC;
    private List<String> OLRC = new ArrayList<>();
    private List<String> badChannels = new ArrayList<>();
    private String NBC;
    private String OBC;
    private String ODQ;
    private String OBClus;
    private String DataQualityRating;
    private String allMAV;
    private String badMAV;
    private String goodMAV;

}
