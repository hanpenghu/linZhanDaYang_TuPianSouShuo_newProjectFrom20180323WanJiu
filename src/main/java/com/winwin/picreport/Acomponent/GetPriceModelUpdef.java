package com.winwin.picreport.Acomponent;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.UpDefMy01;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.commons.io.CopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class GetPriceModelUpdef {
    @Autowired
   private Cnst cnst;
    public void GetPriceModel(PrdtSamp0 prdtSampX) {

        String prdNo=prdtSampX.getPrdNo();
        //动态sql,如果第二个参数是null的话就选出来所有的
        List<UpDefMy01> upDefMyList1= cnst.a001TongYongMapper.getUpDefMy(prdNo,Cnst.salPriceId);//这个其实变成销售的了//1销售
        ////动态sql,如果第二个参数不是null的话就选出来对应的priceId
        List<UpDefMy01> upDefMyListBuy1= cnst.a001TongYongMapper.getUpDefMy(prdNo,Cnst.buyPriceId);//这个其实变成采购的了//2采购
        //走一遍 get方法,等于给该赋值的字段赋值,因为我在get方法里面做了赋值运算
        //最后把up设置成null是为了在接口返回给前端再调get方法的时候不再计算了
        upDefMyListBuy1.forEach(v->{v.getNoTransUpBuy();v.getHaveTransUpBuy();v.getNoTransUpSale();v.getHaveTransUpSale();v.setUp(null);});
        upDefMyList1.forEach(v->{v.getNoTransUpBuy();v.getHaveTransUpBuy();v.getNoTransUpSale();v.getHaveTransUpSale();v.setUp(null);});

        //接下来是把同一次保存的带运费和不带运费的合并成一项
        //销售的有本币和外币
        List<UpDefMy01> upDefMyList = this.m销售定价合并(upDefMyList1);

        //采购的只有本币
        List<UpDefMy01> upDefMyListBuy=this.m采购定价合并(upDefMyListBuy1);


        prdtSampX.setUpDefMyList(upDefMyList);
        prdtSampX.setUpDefMyListBuy(upDefMyListBuy);


    }

    private List<UpDefMy01> m销售定价合并(List<UpDefMy01> upDefMyList1) {
        List<UpDefMy01>list最终组合定价对象=new ArrayList<>();
        //销售定价由于有币别,所以合并方式不一样
        List<List<UpDefMy01>> list分组后的定价对象list = f根据olefied定价关联字段分组(upDefMyList1);
        for(List<UpDefMy01> list某一分组的定价对象:list分组后的定价对象list){
            //同一分组内的定价对象是同一次保存的,用olefield(java对象的dingJiaGuanLian)字段一样
            UpDefMy01 upDefMy01 = h合并相同dingJiaGuanLian_olefield的list(list某一分组的定价对象);
            list最终组合定价对象.add(upDefMy01);
        }
        return list最终组合定价对象;
    }

    private UpDefMy01 h合并相同dingJiaGuanLian_olefield的list(List<UpDefMy01> list某一分组的定价对象){
        UpDefMy01 upDefMy01将要合并后的对象=new UpDefMy01();
        if(p.notEmpty(list某一分组的定价对象)){ BeanUtils.copyProperties(list某一分组的定价对象.get(0),upDefMy01将要合并后的对象); }
        if(p.notEmpty(upDefMy01将要合并后的对象)){
            for(UpDefMy01 u:list某一分组的定价对象){
                if(p.notEmpty(u.getNoTransUpSale())&&p.dy(u.getCurId(),"RMB")){
                    upDefMy01将要合并后的对象.setNoTransUpSale(u.getNoTransUpSale());
                }
                if(p.notEmpty(u.getNoTransUpSale())&&p.bdy(u.getCurId(),"RMB")){
                    upDefMy01将要合并后的对象.setNoTransUpSaleWaiBi(u.getNoTransUpSale());
                }
                if(p.notEmpty(u.getHaveTransUpSale())&&p.dy(u.getCurId(),"RMB")){
                    upDefMy01将要合并后的对象.setHaveTransUpSale(u.getHaveTransUpSale());
                }
                if(p.notEmpty(u.getHaveTransUpSale())&&p.bdy(u.getCurId(),"RMB")){
                    upDefMy01将要合并后的对象.setHaveTransUpSaleWaiBi(u.getHaveTransUpSale());
                }
            }
        }
        return upDefMy01将要合并后的对象;
    }





    private List<List<UpDefMy01>> f根据olefied定价关联字段分组(List<UpDefMy01> upDefMyList1){
        List<List<UpDefMy01>>list根据olefield分组后的定价集合=new LinkedList<List<UpDefMy01>>();
        Set<String>set定价关联字段olefield集=this.d得到所有的定价关联字段集_不重复(upDefMyList1);
        for(String a定价关联字段:set定价关联字段olefield集){
            List<UpDefMy01>d当前的定价关联字段对应的定价对象List=new ArrayList<UpDefMy01>();
            for(UpDefMy01 upDefMy01:upDefMyList1){
                if(p.dy(a定价关联字段,upDefMy01.getDingJiaGuanLian())){
                    d当前的定价关联字段对应的定价对象List.add(upDefMy01);
                }
            }
            list根据olefield分组后的定价集合.add(d当前的定价关联字段对应的定价对象List);
        }
        return list根据olefield分组后的定价集合;
    }

    private Set<String>d得到所有的定价关联字段集_不重复(List<UpDefMy01> upDefMyList1){
        Set<String>set定价关联字段olefield集=new TreeSet<String>();
        for(UpDefMy01 upDefMy01:upDefMyList1){
            set定价关联字段olefield集.add(upDefMy01.getDingJiaGuanLian());
        }
        return set定价关联字段olefield集;
    }





    //思路,拿最终结果集合当前对象做对比
    private List<UpDefMy01> m采购定价合并(List<UpDefMy01> upDefMyList) {
        //根据map中有相同的key会覆盖掉原来key对应数据的特性来处理同一次插入定价表数据
        //储存处理过后的UpDefMy01
        Map<String, UpDefMy01> map最终结果集 = new HashMap();

        for(UpDefMy01 o当前循环的定价对象:upDefMyList){

            String key定价关联字段=o当前循环的定价对象.getDingJiaGuanLian();

            if(map最终结果集.containsKey(key定价关联字段)){//此时是已经添加过该定价关联的key和对应的定价对象value
                //此时有一样进行有一样的处理
                UpDefMy01 temp临时处理后的定价对象=new UpDefMy01();

                BeanUtils.copyProperties(o当前循环的定价对象,temp临时处理后的定价对象);
                //处理   upDefMy01和upDefMy011到upDefMy012
                UpDefMy01 o最终结果集中的定价对象 = map最终结果集.get(key定价关联字段);

                if(p.notEmpty(o当前循环的定价对象.getHaveTransUpBuy())){
                    temp临时处理后的定价对象.setHaveTransUpBuy(o当前循环的定价对象.getHaveTransUpBuy());
                }

                if(p.notEmpty(o最终结果集中的定价对象.getHaveTransUpBuy())){
                    temp临时处理后的定价对象.setHaveTransUpBuy(o最终结果集中的定价对象.getHaveTransUpBuy());
                }


                if(p.notEmpty(o最终结果集中的定价对象.getNoTransUpBuy())){
                    temp临时处理后的定价对象.setNoTransUpBuy(o最终结果集中的定价对象.getNoTransUpBuy());
                }
                if(p.notEmpty(o当前循环的定价对象.getNoTransUpBuy())){
                    temp临时处理后的定价对象.setNoTransUpBuy(o当前循环的定价对象.getNoTransUpBuy());
                }

                map最终结果集.put(key定价关联字段,temp临时处理后的定价对象);
            }else{
                //此时没有一样的进行没有一样的处理
                map最终结果集.put(key定价关联字段,o当前循环的定价对象);
            }
        }



        List<UpDefMy01> list最终定价对象结果集=new LinkedList<>();
        map最终结果集.forEach((key定价时间,value最终定价对象)->list最终定价对象结果集.add(value最终定价对象));
        //按时间从新排序
        this.sortBySdd(list最终定价对象结果集);
        return list最终定价对象结果集;
    }


    private void sortBySdd(List<UpDefMy01> list){
        Collections.sort(list,(o1,o2)->{
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
