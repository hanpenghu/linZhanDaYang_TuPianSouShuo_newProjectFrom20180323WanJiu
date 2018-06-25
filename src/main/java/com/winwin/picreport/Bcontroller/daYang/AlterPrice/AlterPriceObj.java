package com.winwin.picreport.Bcontroller.daYang.AlterPrice;

import com.winwin.picreport.Bcontroller.daYang.dto.AlterPrice;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */
public class AlterPriceObj {
    //当销售修改价格的时候,这个必填,用于将关联的采购价格一起用prm_no关联起来
    private List<BuyPriceUnionId> buyPriceUnionIds=new LinkedList<BuyPriceUnionId>();
    //销售都要填入的实际修改价格的东西
    private List<AlterPrice>alterPrices=new LinkedList<AlterPrice>();

    public List<BuyPriceUnionId> getBuyPriceUnionIds() {
        return buyPriceUnionIds;
    }

    public void setBuyPriceUnionIds(List<BuyPriceUnionId> buyPriceUnionIds) {
        this.buyPriceUnionIds = buyPriceUnionIds;
    }

    public List<AlterPrice> getAlterPrices() {
        return alterPrices;
    }

    public void setAlterPrices(List<AlterPrice> alterPrices) {
        this.alterPrices = alterPrices;
    }


    @Override
    public String toString() {
        return "AlterPriceObj{" +
                "buyPriceUnionIds=" + buyPriceUnionIds +
                ", alterPrices=" + alterPrices +
                '}';
    }
}
