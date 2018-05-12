package com.winwin.picreport.Acomponent;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.UpDefMy01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class GetPriceModelUpdef20180512 {
    @Autowired
    private Cnst cnst;

    public void getPriceModel(PrdtSamp0 prdtSampX){
        String prdNo=prdtSampX.getPrdNo();
        //销售价格模块select开始
        List<UpDefMy01> listUpdefMy01SaleToFront=new LinkedList<UpDefMy01>();
        //找出相同条件下同一个hjNo  like 'SamplesSys' 的所有字段
        //销售不含运费本币的前20个//取出来符合条件的有可能 不到20个
        List<UpDefMy01> upDefMy20180512 = cnst.a001TongYongMapper.getUpDefMy20180512Sale(prdNo, Cnst.salPriceId, Cnst.saleBilTypeNoTrans, Cnst.benBi);
        for(UpDefMy01 u:upDefMy20180512){
            //当前的u是不含运费本币,但是u包含所有运费和币别字段,之后将u改造成最终结果
            String dingJiaGuanLian = u.getOlefield();
            u.setNoTransUpSale(u.getUp());
            u.setUp(null);//设置为null,避免前端用这个
            //得到含运费本币
            UpDefMy01 up1= cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId, Cnst.saleBilTypeHaveTrans, Cnst.benBi,dingJiaGuanLian);
            u.setHaveTransUpSale(up1.getUp());
            //得到不含运费外币
            UpDefMy01 up2= cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId, Cnst.saleBilTypeNoTrans,Cnst.waiBi,dingJiaGuanLian);
            u.setNoTransUpSaleWaiBi(up2.getUp());
            //得到含运费外币
            UpDefMy01 up3= cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId, Cnst.saleBilTypeHaveTrans,Cnst.waiBi,dingJiaGuanLian);
            u.setHaveTransUpSaleWaiBi(up3.getUp());
            //直接使用当前的u组合成价格模块
            listUpdefMy01SaleToFront.add(u);
        }
        this.sortBySdd(listUpdefMy01SaleToFront);
        //塞入将要传给前端的对象
        prdtSampX.setUpDefMyList(listUpdefMy01SaleToFront);








        //以上是销售价格模块的select,下面是采购价格模块的select//采购价格没有币别
        //得到不含运费采购
        List<UpDefMy01> listUpdefMy01BuyToFront=new LinkedList<UpDefMy01>();
        List<UpDefMy01> upDefMyListBuy1= cnst.a001TongYongMapper.getUpDefMy20180512Buy(prdNo,Cnst.buyPriceId,Cnst.buyBilTypeNoTrans);//这个其实变成采购的了//2采购
        for(UpDefMy01 u:upDefMyListBuy1){
            String dingJiaGuanLian = u.getOlefield();
            u.setNoTransUpBuy(u.getUp());u.setUp(null);//变null是要 告诉前端不要用这个
            UpDefMy01 u1=cnst.a001TongYongMapper.getUpDefMy20180512BuyOne(prdNo,Cnst.buyPriceId,Cnst.buyBilTypeHaveTrans,dingJiaGuanLian);
            u.setHaveTransUpBuy(u1.getUp());
            listUpdefMy01BuyToFront.add(u);
        }

        prdtSampX.setUpDefMyListBuy(listUpdefMy01BuyToFront);
    }



























    private void sortBySdd(List<UpDefMy01> list){
        Collections.sort(list,(o1, o2)->{
            long time1 = o1.getSDd().getTime();
            long time2 = o2.getSDd().getTime();
            if(time1<time2){//desc
                return 1;
            }else if(time1==time2){
                return 0;
            }else{
                return -1;
            }
        });
    }
}
