package com.winwin.picreport.Edto;

import com.winwin.picreport.Futils.hanhan.p;

import java.util.ArrayList;
import java.util.List;

public class CategoryNameCode {

    private List<CategoryNameCode> childs;

    private List<String> prdCodeList=new ArrayList<>();//就是prdt中的name
    //2018_8_29   weekday(3)   17:22:05因为后期客户要求界面添加编码建档的时候选择分类只蹦出一个编码,所以我这里添加一个字段实现
    private String prdCode;
    private String idxName;//用于分类名称(小范围)

    private String idxNo;//用于分类编号(小范围)



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    public String getPrdCode() {
        for(String s:prdCodeList){
            if(s.startsWith("WW-NE-"))prdCode=s;
        }
        if(p.empty(prdCode)&&p.notEmpty(prdCodeList))prdCode=prdCodeList.get(0);
        if(p.empty(prdCode))prdCode="WW-NE-";
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public List<String> getPrdCodeList() {
        return prdCodeList;
    }

    public CategoryNameCode setPrdCodeList(List<String> prdCodeList) {
        this.prdCodeList = prdCodeList;
        return this;
    }

    public String getIdxName() {
        return idxName;
    }

    public CategoryNameCode setIdxName(String idxName) {
        this.idxName = idxName;
        return this;
    }

    public String getIdxNo() {
        return idxNo;
    }

    public CategoryNameCode setIdxNo(String idxNo) {
        this.idxNo = idxNo;
        return this;
    }


    public List<CategoryNameCode> getChilds() {
        return childs;
    }

    public CategoryNameCode setChilds(List<CategoryNameCode> childs) {
        this.childs = childs;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.winwin.picreport.Edto.CategoryNameCode{");
        sb.append("prdCodeList=").append(prdCodeList);
        sb.append(", idxName='").append(idxName).append('\'');
        sb.append(", idxNo='").append(idxNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
