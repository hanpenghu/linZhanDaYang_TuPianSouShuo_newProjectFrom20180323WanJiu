package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert.servicesBatchRefactor.OrderToErp;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.OrderPreCnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.AmtAndAmtnAndTaxChongXinSuan;
import com.winwin.picreport.Futils.MsgGenerate.Msg;

import com.winwin.picreport.Futils.TimeStampToDate;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.stra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

@SuppressWarnings("unchecked")
@Component
public class CommonDaoRuDBZhiQianZhengLi {

    /**
     * 查找货号的优先次序
    优先次序：货号(最精确)，货名找货号，对方货号找货号
    *
    * */
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());


    @Autowired
    private Cnst cnst;

    ////////////////////////受订单号成功后是SO/////////////////////////////////////////////
///////////////////////注意事务要加在所有调用的方法上面,如果方法套方法,就必须都加事务///////////////////////////////////////////////////
    //timeout=30超时30秒后自动解除事务
    // Isolation.READ_UNCOMMITTED读取未提交数据(会出现脏读, 不可重复读)
    //Propagation.REQUIRED 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)

    public void saveYiPiDingDanHaoXiangTongDe(Map<String, List> listMap, List<Msg> listmsg,String sap) {

        MfPosWithBLOBs mm=new MfPosWithBLOBs();
        List<TfPosWithBLOBs> tfPosWithBLOBsList=new LinkedList<>();
        List<TfPosZ>tfPosZList=new LinkedList<>();
        List<Sapso>sapsoList=new LinkedList<>();





        //循环插入所有
        //用list3来装入合并同一货号的几个东西后的ShouDingDanFromExcel
        List<ShouDingDanFromExcel> list3 = listMap.get("samePrdNoMeraged");



////////////////////////sapso插入数据搜集开始//////////////////////////////////////////////////////////////////////////////////
        if(p.dy(sap,"sap")){//如果是sap业务订单导入,加上这一步
            Msg msg = new Msg();
            //收集同一货号的list       samePrdNoList
            List<List<ShouDingDanFromExcel>> samePrdNoList = listMap.get("samePrdNoList");
            ////////////////////////循环未合并要插入sapso的list开始////////////////////////////////////////////////////////////////////////////////////
            int kkk=1;
            for (List<ShouDingDanFromExcel> listx : samePrdNoList) {

                ///////////////////////循环同一个货号下的要入sapso的数据开始/////////////////////////////////////////////////////////////
                String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date());
                String uuid = UUID.randomUUID().toString();//uuid相同代表  单号+货号+成分代码  相同
                for (ShouDingDanFromExcel s : listx) {

                    //直接set进去
//                    this.通过对方品号获取prdNo(shouDingDanFromExcel,msg,listmsg);

                    String prdName = s.getPrdName();


                    //数据非法的时候这个方法会抛出异常//这个是通用数据非法处理器
                    //该方法主要判断有些数据不能为空
                    this.a判断数据是否非法并获取prd_no(msg,s, listmsg,kkk);

                    //sap行号不能为空
                    if(p.empty(s.getSaphh())){
                        String sL="有saphh(SAP行号)为空,可能在"+(kkk+1)+"行附近,可以通过货品名称"+ prdName +"来查找";
                        msg.setMsg(sL);
                        listmsg.add(msg);
                        throw new RuntimeException(sL);
                    }



                    //Eb单号不能为空
                    if (p.empty(s.getEbNo())) {
                        String sf=stra.b().a("有《EB单号》为空").a(",应该在"+(kkk+1)+"行附近,").a("请根据货号: ").a(s.getPrdNo()).a("  查找").g();
                        msg.setMsg(sf);
                        listmsg.add(msg);
                        throw new RuntimeException(sf);
                    }

                        Sapso b = new Sapso();
                        b.setRemBody(s.getRemBody());
                        b.setSupPrdNo(s.getDuiFangPrdNo());
                        b.setOsno(s.getOsNo());
                        b.setPrdno(s.getPrdNo());
                        b.setQty(new BigDecimal(s.getQty()));
                        b.setCaigouno(s.getCaiGouNo());
                        b.setEbno(s.getEbNo());
                        b.setMaitouno(s.getMaiTouNo());
                        b.setSaphh(s.getSaphh());
                        b.setSapph(s.getSapph());
                        b.setSapwlm(s.getSapwlm());
                        b.setLuohao(s.getLuoHao());
                        b.setGanghao(s.getGangHao());
                        b.setReallength(s.getRealLength());
                        b.setRealwidth(s.getRealWidth());
                        //20171108加了成分代码
                        b.setChengFenDaiMa(s.getCfdm());//这个是历史遗留问题//这个原来用于导出
                        b.setChengfendaima(s.getCfdm());//这个是真正的导入的
                        b.setTimesamebatch(dateStr);
                        b.setUuid(uuid);//uuid相同代表  单号+货号+成分代码  相同
                        /**
                         *在插入之前判断是否有重复的,有重复的就不插入,因为之前林展的出现过这种导入重复的情况
                         * */


                        Integer kk;
                        try {
                            kk = cnst.a001TongYongMapper.countIfSapsoExist(b);
                        } catch (Exception e) {l.error(e.getMessage(),e);

                            l.error(e.getMessage(),e);
                            throw new RuntimeException(e.toString());
                        }



                        //注意 sapao是excel的原始记录,跟erp系统表没有关系,只是将来sap导出excel的时候拆行用的
                        if (p.notEmpty(kk) && kk >0) {
                            //存在就删掉,将来再导入
                            SapsoExample see=new SapsoExample();
                            see.createCriteria()
                                  .andChengfendaimaEqualTo(b.getChengFenDaiMa().trim())
//                                .andSapwlmEqualTo(b.getSapwlm().trim())
//                                .andSapphEqualTo(b.getSapph().trim())
                                    .andSaphhEqualTo(b.getSaphh().trim())
//                                .andEbnoEqualTo(b.getEbno().trim())
//                                .andCaigounoEqualTo(b.getCaigouno().trim())
                                    .andPrdnoEqualTo(b.getPrdno().trim())
                                    .andOsnoEqualTo(b.getOsno().trim());
                            //此时除了qty都不相等了//有重复的就删掉
                            Integer pp = cnst.sapsoMapper.deleteByExample(see);//这个后期已经加上成分代码

                        }


                        //放入list准备将来批处理
                        sapsoList.add(b);
                    kkk=kkk+1;
                }
                ///////////////////////循环同一个货号下的要入sapso的数据结束/////////////////////////////////////////////////////////////


            }
/////////////////////////////循环未合并要插入sapso的list开始///////////////////////////////////////////////////////////////////////////////////////
        }
///////////////////////////////////////////sapso插入数据搜集结束/////////////////////////////////////////////////////



        ////////////////for循环开始////////////////////////////////////////////////////////////////////////////////////////////////
        //插入sunlike主表//其实是插入一个list里面做准备,搜集tfpos  tfposz 和mfpos数据开始

        for(int iii=0;iii<list3.size();iii++){
            ShouDingDanFromExcel s1=list3.get(iii);
            //同一个iii下面必须一次性插入tf_pos 和tf_pos_z和sapso
            this.saveOneShouDingDanFromExcelToTable(s1, listmsg,iii,mm,tfPosWithBLOBsList,tfPosZList);
        }

/////////////////////////////////////for循环结束///////////////////////////////////////////////////////////////////////////////////////
        /**
         *真正的批处理插入数据库
         * */

        try {

            cnst.commonOrderBatchToDb.f(mm,tfPosWithBLOBsList,tfPosZList,sapsoList,sap);
        } catch (Exception e) {

            Msg msg = new Msg();
            msg.setMsg(e.getMessage());
            listmsg.add(msg);
            e.printStackTrace();
            throw new RuntimeException("导入erp订单批处理未知异常");
        }

        cnst.manyTabSerch.updateMfPosNullToNothing001(mm);
        cnst.manyTabSerch.updateTfPosNullToNothing001(mm);
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Isolation.READ_UNCOMMITTED读取未提交数据(会出现脏读, 不可重复读)
    //Propagation.REQUIRED 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)

    public void saveOneShouDingDanFromExcelToTable(ShouDingDanFromExcel s, List<Msg> listmsg,int iii, MfPosWithBLOBs mm,List<TfPosWithBLOBs> tfPosWithBLOBsList,List<TfPosZ> tfPosZList) {
        Msg msg = new Msg();
        //直接set进去
        //        this.通过对方品号获取prdNo(s,msg,listmsg);
        //数据非法的时候这个方法会抛出异常//数据非法搜集器
        this.a判断数据是否非法并获取prd_no(msg,s, listmsg,iii+1);
        TfPosWithBLOBs t = new TfPosWithBLOBs();
        TfPosZ tz = new TfPosZ();
        PrdtWithBLOBs pdt = new PrdtWithBLOBs();
        String osDd = s.getOsDd();
        String estDd = s.getEstDd();

        if (p.empty(osDd)) {
            //            osDd="32503564800000";//2999-12-31
            osDd = null;
        }
        if (p.empty(estDd)) {
            estDd = null;//2999-12-31
            //            estDd="32503564800000";
        }
        //////////////////////////////////////
        //加bilType, 运费类型, 1.不含运费 2.含运费//将来导入mf_pos.bil_type
       if(p.notEmpty(s.getBilType()))mm.setBilType(s.getBilType());
        mm.setTaxId(s.getTaxId());
        mm.setOsNo(s.getOsNo());
        mm.setRem(s.getRemhead());
        mm.setCurId(s.getCurId());
        mm.setExcRto(new BigDecimal(s.getExcRto()));
        mm.setSalNo(p.threeEyeCalculate(p.notEmpty(s.getSalNo()),s.getSalNo(),""));
        //下面2条是老郑在20170929让我加上的
        //是把界面选的存的代号sal_no，同时写进 mf_pos.usr , mf_pos.chk_man两个字段
        if (p.empty(mm.getSalNo())) {
            mm.setUsr("ADMIN");
            mm.setChkMan("ADMIN");
        } else {
            mm.setUsr(mm.getSalNo());
            mm.setChkMan(mm.getSalNo());
        }
        mm.setCusNo(s.getCusNo());
        //老郑说了,这个客户单号也用osNo填充
        mm.setCusOsNo(s.getOsNo());
        mm.setOsId("SO");
        //后来加的4个,为了避免是null
        mm.setClsId("F");
        mm.setPayMth("1");
        mm.setPayDays((short) 1);
        mm.setChkDays((short) 30);
        if (osDd == null) {
            mm.setOsDd(null);
        } else {
            //"销售订单导入的时候《订单日期》不是有效的时间戳osDd:《"+osDd+"》"
            try {
                mm.setOsDd(TimeStampToDate.timeStampToDate(Long.parseLong(osDd)));
            } catch (Exception e) {l.error(e.getMessage(),e);
                msg.setMsg("销售订单导入的时候《订单日期》不是有效的时间戳osDd:《"+osDd+"》");
                listmsg.add(msg);
                throw new RuntimeException(msg.getMsg());
            }

        }
        //下面2017-10-24老郑让我加的
        mm.setZhangId("3");
        mm.setPayRem("结帐期:2017-11-01;票据到期日:2017-12-02");
        try {
            mm.setPayDd(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-01"));
        } catch (ParseException e) {
        }
        mm.setChkDd(cnst.manyTabSerch.getDate());
        mm.setIntDays((short) 30);
        //2017-11-13老郑让加上
        mm.setUseDep("2000");
        mm.setSendMth("1");
        mm.setPoDep("2000");
        if (estDd == null) {
            if(p.notEmpty(osDd)){
                try {
                    mm.setEstDd(TimeStampToDate.timeStampToDate(Long.parseLong(osDd)));
                } catch (Exception e) {l.error(e.getMessage(),e);
                    msg.setMsg("销售订单导入的时候预交日期不是有效的时间戳estDd:《"+osDd+"》");
                    listmsg.add(msg);
                    throw new RuntimeException(msg.getMsg());
                }
            }else{
                mm.setEstDd(null);
            }

        } else {
            try {
                mm.setEstDd(TimeStampToDate.timeStampToDate(Long.parseLong(estDd)));
            } catch (Exception e) {l.error(e.getMessage(),e);
                msg.setMsg("销售订单导入的时候预交日期不是有效的时间戳estDd:《"+estDd+"》");
                listmsg.add(msg);
                throw new RuntimeException(msg.getMsg());
            }
        }
///////////////////////
        t.setOsNo(s.getOsNo());
        //之所以cusosno也传入osno,是因为老郑20170929让这么做的
        t.setCusOsNo(s.getOsNo());
        t.setOsId(OrderPreCnst.SO);
        t.setSupPrdNo(s.getDuiFangPrdNo());

        t.setPrdNo(s.getPrdNo());
        t.setPrdName(s.getPrdName());

        try {
            t.setQty(new BigDecimal(s.getQty().trim().replace(",","")));
        } catch (Exception e) {
            String ss="qty  数量 字段有非法数据  导致excel没有插入  根据品名《"+s.getPrdName()+"》去找";
            listmsg.add(Msg.gmg().setMsg(ss));
            throw new RuntimeException(ss);
        }

//        t.setUnit(s.getUnit());
        t.setUnit("1");
        try {
            t.setTax(new BigDecimal(s.getTax().trim()));
        } catch (Exception e) {l.error(e.getMessage(),e);
            String ss="tax  税额 字段有非法数据  导致excel没有插入  根据品名《"+s.getPrdName()+"》去找";
            listmsg.add(Msg.gmg().setMsg(ss));
            throw new RuntimeException(ss);
        }
        try {
            t.setTaxRto(new BigDecimal(s.getTaxRto().trim()));
        } catch (Exception e) {l.error(e.getMessage(),e);
            String ss="taxRto  税率 字段有非法数据  导致excel没有插入 根据品名《"+s.getPrdName()+"》去找";
            listmsg.add(Msg.gmg().setMsg(ss));
            throw new RuntimeException(ss);
        }
        try {
            t.setAmt(new BigDecimal(s.getAmt().trim()));
        } catch (Exception e) {l.error(e.getMessage(),e);
            String ss="amt  金额 字段有非法数据  导致excel没有插入  根据品名《"+s.getPrdName()+"》去找";
            listmsg.add(Msg.gmg().setMsg(ss));
            throw new RuntimeException(ss);
        }
        try {
            t.setAmtn(new BigDecimal(s.getAmtn().trim()));
        } catch (Exception e) {l.error(e.getMessage(),e);
            String ss="amtn  未税金额 字段有非法数据  导致excel没有插入  根据品名《"+s.getPrdName()+"》去找";
            listmsg.add(Msg.gmg().setMsg(ss));
            throw new RuntimeException(ss);
        }




        t.setRem(s.getRemBody());
        t.setPrdMark("");


        try {
            t.setUp(new BigDecimal(s.getUp().trim()));
        } catch (Exception e) {l.error(e.getMessage(),e);
            String sss="有价格不正确,在"+(iii+1)+"行附近,根据货品名称《"+s.getPrdName()+"》 去找到！";
            listmsg.add(Msg.gmg().setMsg(sss));
            p.throwE(sss);
        }
//        t.setWh("0000");
        //20171113老郑让改
//        t.setWh("1000");
        //2018_4_10   weekday(2)   10:30:48  //老郑让改成前端传过来
        t.setWh(p.threeEyeCalculate(p.notEmpty(s.getWh()),s.getWh(),"1000"));



//        p.p("---------s.getWh是"+s.getWh()+"---------------导入sapSoExcel实验仓库----以下是tfpos得到的wh---------------------------");
//        p.p(t.getWh());
//        p.p("-------------------------------------------------------");



        if (estDd == null) {
            if(p.notEmpty(osDd)){
                try {
                    t.setEstDd(TimeStampToDate.timeStampToDate(Long.parseLong(osDd)));
                } catch (Exception e) {l.error(e.getMessage(),e);
                    msg.setMsg("销售订单导入的时候预交日期不是有效的时间戳estDd:《"+osDd+"》");
                    listmsg.add(msg);
                    throw new RuntimeException(msg.getMsg());
                }
            }else{
                t.setEstDd(null);
            }

        } else {
            try {
                t.setEstDd(TimeStampToDate.timeStampToDate(Long.parseLong(estDd)));
            } catch (Exception e) {l.error(e.getMessage(),e);
                msg.setMsg("销售订单导入的时候预交日期不是有效的时间戳estDd:《"+estDd+"》");
                listmsg.add(msg);
                throw new RuntimeException(msg.getMsg());
            }
        }

        if (osDd == null) {
            t.setOsDd(null);
        } else {
            try {
                t.setOsDd(TimeStampToDate.timeStampToDate(Long.parseLong(osDd)));
            } catch (Exception e) {l.error(e.getMessage(),e);
                msg.setMsg("销售订单导入的时候《订单日期》不是有效的时间戳osDd:《"+osDd+"》");
                listmsg.add(msg);
                p.p(JSON.toJSONString(s));
                throw new RuntimeException(msg.getMsg());
            }

        }

        //t.setItm();
        //后来为了避免null加的一项
//        t.setPreItm(t.getItm());
        ////////////////////////////////////////////////
        tz.setOsNo(s.getOsNo());
        tz.setSapwlm(s.getSapwlm());
//        tz.setSaphh(s.getSaphh());//20170929老郑说这个不用写入值了
        tz.setSapph(s.getSapph());
        tz.setCfdm(s.getCfdm());
        tz.setOsId(OrderPreCnst.SO);
        //tz.setItm();
////////////////////////////////////////////////
        pdt.setPrdNo(s.getPrdNo());
        pdt.setName(s.getPrdName());
////////////////////////////////////////////////

        this.saveOneShouDingDanFromExcelToTableInsert
                (t, tz, pdt, s, listmsg, iii,mm,
                tfPosWithBLOBsList,tfPosZList);
///////////////////////////////////////////
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Isolation.READ_UNCOMMITTED读取未提交数据(会出现脏读, 不可重复读)
    //Propagation.REQUIRED 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)

    public void saveOneShouDingDanFromExcelToTableInsert
    ( TfPosWithBLOBs t, TfPosZ tz, PrdtWithBLOBs pdt,
     ShouDingDanFromExcel s, List<Msg> listmsg,int iii,MfPosWithBLOBs mm
            ,List<TfPosWithBLOBs> tfPosWithBLOBsList,
     List<TfPosZ> tfPosZList) {


        PrdtExample prdtExample = new PrdtExample();

        prdtExample.createCriteria().andPrdNoEqualTo(pdt.getPrdNo()).andNameEqualTo(pdt.getName());
        long l2 = cnst.prdtMapper.countByExample(prdtExample);
        //此时数据库prdt表没有该条记录,我们下面不再插入其他记录,而是告诉客户,该记录在数据库prdt表不存在,请自行注册该商品到数据库,
        //这也是老郑的要求
        Msg msg = new Msg();
        if (l2 == 0) {
            msg.setWeiNengChaRuHuoZheChaRuShiBaiDeSuoYouDingDanHao(t.getOsNo());
            msg.setNotExsitThisPrdtNoInPrdtTab(pdt.getPrdNo());
//            msg.setMsg("--------------该订单号osNo=" + t.getOsNo() +
//                    "这批(整个excel的数据)一个也没有插入,插入数据的时候遇到--商品(prdtNo=" + pdt.getPrdNo()
//                    + ")--没有在商品表Prdt表里面或者 商品名=" + pdt.getName() + "不在商品表中,导致无法插入数据,--------");
            msg.setMsg("商品《"+pdt.getPrdNo()+"》对应《"+pdt.getName()+"》在erp中不存在!");
            msg.setOtherMsg("根据对方货号sup_prd_no获得的货号在prdt中对应的当前货名不符合！");
            listmsg.add(msg);
            //不再进行下面步骤
            throw new RuntimeException(msg.getMsg());
        } else {
            //单独分出来是为了只在下面的几个插入使用事务
            this.saveChuLePrdtDe(t, tz, listmsg,iii,mm,tfPosWithBLOBsList,tfPosZList);
        }
//    } catch (RuntimeException e) {
//        e.printStackTrace();
//        throw new RuntimeException();
//    }
    }

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 插入三个主表,换成了插入三个集合最后commit
     */
    // Isolation.READ_UNCOMMITTED读取未提交数据(会出现脏读, 不可重复读)
    //Propagation.REQUIRED 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)

    public void saveChuLePrdtDe(TfPosWithBLOBs t, TfPosZ tz,
                                List<Msg> listmsg,int iii,MfPosWithBLOBs mm,
                                List<TfPosWithBLOBs> tfPosWithBLOBsList,
                                List<TfPosZ> tfPosZList) {
        try {


            //注意:tf_pos和tf_pos_z必须共用itm才对//注意iii是从0开始索引的 itm是从1  所以要加1
            t.setItm(iii+1);
            t.setEstItm(t.getItm());
//            cnst.tfPosMapper.insert(t);
            //加入list
            tfPosWithBLOBsList.add(t);
            //注意:tf_pos和tf_pos_z必须共用itm才对//注意iii是从0开始索引的 itm是从1  所以要加1
            //公用itm才能在erp界面进行关联
            tz.setItm(t.getItm());
            //此时表存在
//            cnst.tfPosZMapper.insert(tz);
            //加入list
            tfPosZList.add(tz);
            //接下来update一下老郑于2017年-10-09要把null变成固定值的地方
            //下面2个update最后弄



        } catch (Exception e) {l.error(e.getMessage(),e);
            Msg msg = new Msg();
            msg.setMsg("未知异常,发生在方法  saveChuLePrdtDe  《最后一步批处理搜集器》");
            listmsg.add(msg);
            e.printStackTrace();
            throw new RuntimeException(JSON.toJSONString(msg));
        }


    }
//////////////////////////////////////////////////////////////////////////////////


    //数据非法的时候会抛出异常到前端
    public void a判断数据是否非法并获取prd_no(Msg msg, ShouDingDanFromExcel s, List<Msg> listmsg, int jiShuQi) {
        //2018_6_6   weekday(3)   16:13:40添加
        if(p.empty(s.getCurId())){
            msg.setMsg("有 币别 为空: 在《"+(jiShuQi+1)+"》行附近查找");
            listmsg.add(msg);
            throw new RuntimeException(msg.getMsg());
        }

        //在使用货号之前如果是空的,先流水一下货号
        if (p.empty(s.getPrdNo())) {
            String prdNo=cnst.a001TongYongMapper.getPrdNoUsePrdName(s.getPrdName());
            if(p.empty(prdNo)){
                this.通过对方品号获取prdNo(s,msg,listmsg);
            }
            if(p.empty(prdNo)){
                String s1="有货号为空,根据品名和对方货号在erp也找不到对应的货号,在"+(jiShuQi+1)+"行附近";
                s1=s1+",对应的品名为："+s.getPrdName();
                msg.setMsg(s1);
                listmsg.add(msg);
                throw new RuntimeException(msg.getMsg());
            }else{
                s.setPrdNo(prdNo);
            }
        }


        //如果此时货号还是空的,就抛出异常
        if (p.empty(s.getPrdNo())) {
            msg.setMsg("有货号为空且根据货品名字在erp找不到货号,可能在"+(jiShuQi+1)+"行附近"+",对应的品名为："+s.getPrdName());
            listmsg.add(msg);
            //这个功能是迎合老郑说的:货品代号（品号） PRDT.PRD_NO里不存在提示整单不能导入
            throw new RuntimeException(msg.getMsg());
        }


        if(s.getPrdNo().length()>30){
            String s1=stra.b().a("货号：").a(s.getPrdNo()).a("长度超过30！").g();
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }


        if(p.empty(s.getPrdName())){
            String s1="有品名为空,可能在"+(jiShuQi+1)+"行附近";
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }

        if(s.getPrdName().length()>100){
            String s1="货品名字:"+s.getPrdName()+"长度超过100";
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }

        if(p.empty(s.getOsNo())){
            //由于合并过,所以无法确定精确行数
            String s1="excel有单号为空,可能在"+(jiShuQi+1)+"行附近";
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }
        if(s.getOsNo().length()>20){
            String s1=stra.b().a("单号：").a(s.getOsNo()).a("长度超过20！").g();
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }





        if(s.getRemBody()!=null&&s.getRemBody().length()>1000){
            String s1="表身备注长度不能大于1000个字符";
            msg.setMsg(s1);
            listmsg.add(msg);
            throw new RuntimeException(s1);
        }


        //如果单价有问题,就要抛出异常
        if (p.empty(s.getUp()) || p.dy(s.getUp(),"0")) {
            msg.setMsg("有单价《为空>或者《0》,估计在《"+(jiShuQi+1)+"》行附近,可以根据货号《"+s.getPrdNo()+"》查找");
            listmsg.add(msg);
            throw new RuntimeException(msg.getMsg());
        }
    }
    private void 通过对方品号获取prdNo(ShouDingDanFromExcel s,Msg msg, List<Msg> listmsg) {
        /**
         * 3）	标准订单的导入格式里加一列对方品号（最好列次序不要固定，识别列名就可以）。
         如果excel有品号按照品号，如果excel里无品号，有客户代码，
         对方品号，按同时符合这两个条件的查出品号select
         prd_no  from prdt_cus1 where  cus_no=客户代码 and sup_prd_no=对方品号
         * */
        try {
            if(p.empty(s.getPrdNo())){


                String prdNo=cnst.a001TongYongMapper
                        .getPrdNoUseCus_noAndSup_prd_noFromPrdt_cus1
                                (s.getCusOsNo(),s.getDuiFangPrdNo());


                if(p.notEmpty(prdNo)){
                    s.setPrdNo(prdNo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(" 《通过对方品号获取prdNo()方法》  异常 ");
            msg.setOtherMsg(e.toString());
            listmsg.add(msg);
            throw new RuntimeException(msg.getMsg());
        }
    }
/////////////////////////////////////////////////////////////////////////////////
}
