package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/24.
 */
public class IfSalePriceSamllEntityFlag {
  private List<IfSalePriceSamllEntity> states=new ArrayList<IfSalePriceSamllEntity>();
  //默认是1,表示都正常,不需要颜色标记,如果是0,表示需要颜色标记
  private String flag="1";

    public List<IfSalePriceSamllEntity> getStates() {
        return states;
    }

    public void setStates(List<IfSalePriceSamllEntity> states) {
        this.states = states;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
