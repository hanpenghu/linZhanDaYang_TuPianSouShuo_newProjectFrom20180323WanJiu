package com.winwin.picreport.Acomponent;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.UpDefMy01;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Collections;
import java.util.LinkedHashMap;
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

//        select olefield from up_def  where olefield like '%SamplesSys%'  and prd_no ='10100003'

       List<String>dingJiaGuanLianList= cnst.a001TongYongMapper.getOlefieldUsePrdNo(prdNo,Cnst.salPriceId);




        if(p.notEmpty(dingJiaGuanLianList)){
            for(String dingJiaGuanLian:dingJiaGuanLianList){
                if(p.notEmpty(dingJiaGuanLian)){
                    //找出相同条件下同一个hjNo  like 'SamplesSys' 的所有字段

                    UpDefMy01 up0 = cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId
                            ,Cnst.saleBilTypeNoTrans, Cnst.benBi,dingJiaGuanLian);


                    //得到含运费本币getUpDefMy20180512Saleone

                    UpDefMy01 up1= cnst.a001TongYongMapper
                            .getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId,
                                    Cnst.saleBilTypeHaveTrans, Cnst.benBi,dingJiaGuanLian);


                    //得到不含运费外币
                    UpDefMy01 up2= cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId,
                            Cnst.saleBilTypeNoTrans,Cnst.waiBi,dingJiaGuanLian);


                    //得到含运费外币
                    UpDefMy01 up3= cnst.a001TongYongMapper.getUpDefMy20180512Saleone(prdNo, Cnst.salPriceId,
                            Cnst.saleBilTypeHaveTrans,Cnst.waiBi,dingJiaGuanLian);
                    UpDefMy01 up=new UpDefMy01();
                    if(p.notEmpty(up0)){
                        BeanUtils.copyProperties(up0,up);
                        setUpOfSale(up,up0,up1,up2,up3);

                    }
                    if(p.notEmpty(up1)){
                        BeanUtils.copyProperties(up1,up);
                        setUpOfSale(up,up0,up1,up2,up3);

                    }
                    if(p.notEmpty(up2)){
                        BeanUtils.copyProperties(up2,up);
                        setUpOfSale(up,up0,up1,up2,up3);

                    }
                    if(p.notEmpty(up3)){
                        BeanUtils.copyProperties(up3,up);
                        setUpOfSale(up,up0,up1,up2,up3);

                    }

                    //直接使用当前的u组合成价格模块
                    listUpdefMy01SaleToFront.add(up);
                }

            }
        }


        this.sortBySdd(listUpdefMy01SaleToFront);
        //塞入将要传给前端的对象
        prdtSampX.setUpDefMyList(listUpdefMy01SaleToFront);








        //以上是销售价格模块的select,
        // 下面是采购价格模块的select//采购价格没有币别
        //得到不含运费采购
        List<UpDefMy01> listUpdefMy01BuyToFront=new LinkedList<UpDefMy01>();

        List<String>dingJiaGuanLianListBuy= cnst.a001TongYongMapper.getOlefieldUsePrdNo(prdNo,Cnst.buyPriceId);

        if(p.notEmpty(dingJiaGuanLianListBuy)){
            for(String  dingJiaGuanLian:dingJiaGuanLianListBuy){
                if(p.notEmpty(dingJiaGuanLian)){
                    UpDefMy01 u=new UpDefMy01();

                    UpDefMy01 u0=
                            cnst.a001TongYongMapper
                                    .getUpDefMy20180512BuyOne
                                            (prdNo,Cnst.buyPriceId,Cnst.buyBilTypeNoTrans,dingJiaGuanLian);//这个其实变成采购的了//2采购
                    UpDefMy01 u1=cnst.a001TongYongMapper.getUpDefMy20180512BuyOne(prdNo,Cnst.buyPriceId,Cnst.buyBilTypeHaveTrans,dingJiaGuanLian);

                    if(p.notEmpty(u0)){
                        BeanUtils.copyProperties(u0,u);
                        setUpOfBuy(u,u0,u1);
                    }


                    if(p.notEmpty(u1)){
                        BeanUtils.copyProperties(u1,u);
                        setUpOfBuy(u,u0,u1);
                    }
                    listUpdefMy01BuyToFront.add(u);
                }
            }
        }



        prdtSampX.setUpDefMyListBuy(listUpdefMy01BuyToFront);
    }







    private void setUpOfBuy(UpDefMy01 u,UpDefMy01 u0,UpDefMy01 u1){
        u.setNoTransUpBuy(u0==null?null:u0.getUp());
        u.setHaveTransUpBuy(u1==null?null:u1.getUp());
        u.setUp(null);
    }




        private void setUpOfSale(UpDefMy01 up,UpDefMy01 up0,UpDefMy01 up1,UpDefMy01 up2, UpDefMy01 up3){
            up.setNoTransUpSale(up0==null?null:up0.getUp());
            up.setHaveTransUpSale(up1==null?null:up1.getUp());
            up.setNoTransUpSaleWaiBi(up2==null?null:up2.getUp());
            up.setHaveTransUpSaleWaiBi(up3==null?null:up3.getUp());
            up.setUp(null);
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
