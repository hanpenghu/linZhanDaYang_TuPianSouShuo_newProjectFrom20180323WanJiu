package com.winwin.picreport.Ddao.reportxmlmapper;
import com.winwin.picreport.Bcontroller.PicSearchPic.dto.SimplePrdtSamp;
import com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel.ExportXlsParam;
import com.winwin.picreport.Bcontroller.daYang.dto.AlterPrice;
import com.winwin.picreport.Bcontroller.daYang.dto.AlterPriceRecToFront;
import com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel.DaoChu;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.Model;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.ModelUsers;
import com.winwin.picreport.Edto.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;
import java.util.Map;
public interface A001TongYongMapper {

/////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////

   @Select("SELECT GETDATE()")
   Date selectDbDate();


   //在字段后面加上collate Chinese_PRC_CS_AS_WS是强制sqlServer区分大小写
   @Select({"select count(*) from tenant where tenantid collate Chinese_PRC_CS_AS_WS= #{tenantId}"})
   Integer conutTenantId(@Param("tenantId") String tenantId);
//   @Select({"select count(*) from tenant where tenantid= #{tenantId}"})
//   Integer conutTenantId(@Param("tenantId") String tenantId);


   @Select("SELECT COUNT(U.TENANTID) FROM USERS AS U,TENANT AS T WHERE U.TENANTID=T.TENANTID AND U.TENANTID=#{tenantId} AND T.TENANTID=#{tenantId} AND U.USEREMAIL=#{userEmail} AND U.USERPSWD=#{userPswd}")
   Integer countuserEmailAndPswd(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail, @Param("userPswd") String userPswd);

//   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE USEREMAIL=#{userEmail}")
//   Integer countuserEmail(@Param("userEmail") String userEmail,@Param("userPswd")  String userPswd);

//   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE USERPSWD=#{userPswd}")
//   Integer countuserPswd(@Param("userEmail") String userEmail,@Param("userPswd")  String userPswd);


   @Select("SELECT COUNT(U.TENANTID) FROM USERS AS U,TENANT AS T WHERE U.TENANTID=T.TENANTID AND U.TENANTID=#{tenantId} AND T.TENANTID=#{tenantId} AND USEREMAIL=#{userEmail}")
   Integer countuserEmail(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail);


   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE PHONE_NO=#{phoneNo}")
   Integer countPhoneNo(@Param("phoneNo") String phoneNo);
   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE USER_NAME=#{userName}")
   Integer countUserName(@Param("userName") String userName);



   @Update("UPDATE USERS SET TIMETOKEN =#{timestamp} WHERE TENANTID=#{tenantId} AND USEREMAIL=#{userEmail} AND USERPSWD=#{userPswd}")
   Integer updateTimeTokenOfUsers(@Param("timestamp") String timestamp, @Param("tenantId") String tenantId, @Param("userEmail") String userEmail, @Param("userPswd") String userPswd);


   //PHONE_NO=#{userEmail}是因为登录的时候前端用的字段都是userEmail,然后后台判断是email(在users表唯一)还是phone(在users表唯一)还是会员名(在users表不唯一)
   @Update("UPDATE USERS SET TIMETOKEN =#{timestamp} WHERE  TENANTID=#{tenantId} AND PHONE_NO=#{userEmail} AND USERPSWD=#{userPswd}")
   Integer updateTimeTokenOfUsers_Phone(@Param("timestamp") String timestamp, @Param("tenantId") String tenantId, @Param("userEmail") String userEmail, @Param("userPswd") String userPswd);


   //PHONE_NO=#{userEmail}是因为登录的时候前端用的字段都是userEmail,然后后台判断是email(在users表唯一)还是phone(在users表唯一)还是会员名(在users表不唯一)
   @Update("UPDATE USERS SET TIMETOKEN =#{timestamp} WHERE USER_NAME=#{userEmail} AND USERPSWD=#{userPswd} AND TENANTID=#{tenantId}")
   Integer updateTimeTokenOfUsers_HuiYuanMing(@Param("timestamp") String timestamp, @Param("userEmail") String userEmail, @Param("userPswd") String userPswd, @Param("tenantId") String tenantId);



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE USEREMAIL=#{userEmail} AND TIMETOKEN=#{timeStamp}")
   Integer countuserEmailAndTimeStamp(@Param("userEmail") String userEmail, @Param("timeStamp") String timeStamp);


   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE PHONE_NO=#{userEmail} AND TIMETOKEN=#{timeStamp}")
   Integer countPhoneNoAndTimeStamp(@Param("userEmail") String userEmail, @Param("timeStamp") String timeStamp);


   @Select("SELECT COUNT(TENANTID) FROM USERS WHERE USER_NAME=#{userEmail} AND TIMETOKEN=#{timeStamp}")
   Integer countMemberNoAndTimeStamp(@Param("userEmail") String userEmail, @Param("timeStamp") String timeStamp);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   @Select("SELECT SUM(ISNULL(TF.QTY,0)-ISNULL(TF.QTY_RTN,0)) FROM TF_QL TF LEFT JOIN  TF_QL_Z TZ ON TZ.QL_NO=TF.QL_NO  WHERE (ISNULL(TF.PRD_NO,'')+ISNULL(TF.BAT_NO,'')+ISNULL(TF.PRD_MARK,''))+ISNULL(CONVERT(VARCHAR(10),TZ.SC_DD,111),'')= #{recode}")
   Double selectSumQtyOfShengChanLingLiao(@Param("recode") String huoHao_piHao_teZheng_shengChanRiQi_dingDanNum);

   @Insert({"insert into tenant(tenantid,tenantname)values(#{info.tenantId},#{info.tenantName})","insert into users(tenantid,useremail,userpswd,lockbill)values(#{info.tenantId},#{info.userEmail},#{info.userPswd},#{info.lockBill})"})//""
   Integer insertTenantAndUsers(@Param("info") LoginInfo info);

   @Select("SELECT TOP 1 TOKENTIME FROM TENANT WHERE TENANTID=#{tenantId}")
   Long getTenantShiXiaoShiJianCha(@Param("tenantId") String tenantId);

//////////////////////////////////////////////////////////////
   @Update("UPDATE  USERS  SET TIMETOKEN='logOut' WHERE TENANTID=#{tenantId} AND USEREMAIL=#{userEmail} AND EXISTS (SELECT 1 FROM  TENANT B WHERE TENANTID=B.TENANTID)")
   Long logOutTenantIdAndUserEmail(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail);

   @Update("UPDATE  USERS  SET TIMETOKEN='logOut' WHERE TENANTID=#{tenantId} AND phone_no=#{userEmail} AND EXISTS (SELECT 1 FROM  TENANT B WHERE TENANTID=B.TENANTID)")
   Long logOutTenantIdAndPhoneNo(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail);

   @Update("UPDATE  USERS  SET TIMETOKEN='logOut' WHERE TENANTID=#{tenantId} AND user_name=#{userEmail} AND EXISTS (SELECT 1 FROM  TENANT B WHERE TENANTID=B.TENANTID)")
   Long logOutTenantIdAndUserName(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail);
/////////////////////////////////////////////////////////////////////////////////////////
   @Select("select tenantname from tenant where tenantid=#{tenantid}")
   List<String>selectTenantName(@Param("tenantid") String tenantid);

   @Insert("insert into users(tenantid,useremail,userpswd,lockbill)values(#{info.tenantId},#{info.userEmail},#{info.userPswd},#{info.lockBill})")
   Integer insertUsers(@Param("info") LoginInfo info);

   //u.user_name=#{info.userEmail}//这里之所以这样,是因为前端登录的时候不管是手机号还是用户名还是email都是靠userEmail这个字段来穿,这是历史遗留问题,但是也没关系,传过来后,再后台接口一开始就判断用户穿的是什么了
   @Select("Select count(u.tenantid) from users u,tenant t where u.tenantid=t.tenantid and t.tenantid=#{info.tenantId} and u.tenantid=#{info.tenantId} and u.user_name=#{info.userEmail} and u.userPswd=#{info.userPswd}")
    Integer selectCount_tenantIdAndUserNameAndUserPswd(@Param("info") LoginInfo info);

   @Select("Select count(u.tenantid) from users u,tenant t where u.tenantid=t.tenantid and t.tenantid=#{info.tenantId} and u.tenantid=#{info.tenantId} and u.phone_no=#{info.userEmail} and u.userPswd=#{info.userPswd}")
    Integer selectCount_tenantIdAndPhoneNoAndUserPswd(@Param("info") LoginInfo info);

   @Select("SELECT COUNT(U.TENANTID) FROM USERS U,TENANT T WHERE U.TENANTID=T.TENANTID and T.TENANTID=#{info.tenantId} and U.TENANTID=#{info.tenantId} AND U.USEREMAIL=#{info.userEmail}")
   Integer seletTenantIdAndUserEmail(@Param("info") LoginInfo info);

   @Select("SELECT COUNT(U.TENANTID) FROM USERS U,TENANT T WHERE U.TENANTID=T.TENANTID and T.TENANTID=#{info.tenantId} and U.TENANTID=#{info.tenantId} AND U.USER_NAME=#{info.userName}")
   Integer seletTenantIdAndUserName(@Param("info") LoginInfo info);

   @Select("SELECT COUNT(U.TENANTID) FROM USERS U,TENANT T WHERE U.TENANTID=T.TENANTID and T.TENANTID=#{info.tenantId} and U.TENANTID=#{info.tenantId} AND U.PHONE_NO=#{info.phoneNo}")
   Integer seletTenantIdAndPhoneNo(@Param("info") LoginInfo info);




   @Insert({"insert into tenant (tenantid,tenantname)values(#{info.tenantId},#{info.tenantName})"})
   Integer insertTenant(@Param("info") LoginInfo info);

   @Insert({"insert into users(tenantid,userEmail,userPswd,lockbill,phone_no,user_name)values(#{info.tenantId},#{info.userEmail},#{info.userPswd},#{info.lockBill},#{info.phoneNo},#{info.userName})"})
   Integer insertUser(@Param("info") LoginInfo info);

//   @Select("SELECT COUNT(U.TENANTID) FROM USERS U,TENANT T WHERE U.TENANTID=T.TENANTID and T.TENANTID=#{info.tenantId} and U.TENANTID=#{info.tenantId} AND U.USEREMAIL=#{info.userEmail} AND U.USER_NAME=#{info.userName} AND U.PHONE_NO=#{info.phoneNo}")
//   Integer seletTenantIdAndUserEmailAndUserNamePhoneNo(@Param("info")LoginInfo info);

   @Insert("insert into users(tenantid,userEmail,userPswd,lockbill,phone_no,user_name)values(#{info.tenantId},#{info.userEmail},#{info.userPswd},#{info.lockBill},#{info.phoneNo},#{info.userName})")
   Integer insertUsersOfTenantIdAndUserEmailOrPhoneNoOrUserName(@Param("info") LoginInfo info);

   @Select("select count(tenantid) from tenant where tenantName=#{info.tenantName}")
   int countTenantName(@Param("info") LoginInfo info);


   List<LoginInfo> selectUserEditInfo(@Param("info") LoginInfo info);



   int updateUserInfo(LoginInfo info);//注意:没有@Param的话,直接就可以用info里面的字段

   @Select("SELECT tenantID AS tenantId,userEmail AS userEmail,phone_no AS phoneNo,user_Name AS userName from users where tenantId=#{tenantId} and (userEmail=#{userEmail} or phone_no=#{userEmail})")
    List<LoginInfo> selectUsers(@Param("tenantId") String tenantId, @Param("userEmail") String userEmail);



   List<PrdtSamp0> chanPinBianMaJianDangTiaoJianChaXun(PrdtSamp1 p1);
   Integer getCountOfDuoTiaoJianChaXunZongJiLuShu(PrdtSamp1 p1);

   @Select("Select top 1 prd_no from prdt where name=#{prdCode} order by prd_no desc")
   String selectTop1PrdtNo(@Param("prdCode") String prdCode);



   @Select("Select top 1 prd_no from prdt where IDX1=#{indx1} order by prd_no desc")
   String selectTop1MaxPrdtNo(@Param("indx1")String indx1);

   //prdCode对应name
   @Insert({"insert into prdt(prd_no,idx1,name,rem,usr,chk_man,knd,dfu_ut,ut)" +
           "values(#{prdNo},#{indx1},#{prdCode}," +
           "'SamplesSys',#{usr},#{chkMan},#{knd},#{dfuUt},#{mainUnit})"})
   Integer insertPrdtOnePrdNo(@Param("prdNo") String prdNo,
                              @Param("indx1")String indx1,
                              @Param("prdCode") String prdCode,
                              @Param("usr")String usr,
                              @Param("chkMan")String chkMan,
                              @Param("knd") String knd,
                              @Param("dfuUt") String dfuUt,
                              @Param("mainUnit")String mainUnit);


   List<UpDefMy01> getUpDefMy20180512Buy(@Param("prdNo")String prdNo
           , @Param("priceId")String priceId
           ,@Param("bilType") String bilType);

    List<UpDefMy01> getUpDefMy(@Param("prdNo") String prdNo,@Param("priceId")String priceId);


   List<UpDefMy01> getUpDefMy20180512Sale(
           @Param("prdNo") String prdNo
           ,@Param("priceId")String priceId
           ,@Param("bilType")String bilType
           ,@Param("CurId")String CurId

   );

   UpDefMy01 getUpDefMy20180512Saleone(@Param("prdNo")String prdNo,
                                  @Param("priceId")String priceId,
                                  @Param("bilType")String bilType,
                                  @Param("CurId")String CurId,
                                  @Param("olefield")String olefield);


   UpDefMy01 getUpDefMy20180512BuyOne(@Param("prdNo")String prdNo,
                                      @Param("priceId")String priceId,
                                      @Param("bilType")String bilType,
                                      @Param("olefield")String olefield);

    @Select({"SELECT IDX_UP FROM INDX WHERE IDX_NO=#{idxNo}"})
   String deDaoShangJi_IdxNo(@Param("idxNo") String idxNo);

    @Select({"select idx_no from indx where idx_up=#{idxNo}"})
   List<String> selectAllXiaJi(@Param("idxNo")String idxNo);

    @Select({"Select count(*) from prdt where prd_no=#{prdNoMax}"})
   Integer ifIdxNoExistInPrdt(@Param("prdNoMax") String prdNoMax);

    @Select({"Select count(id) from prdt_samp where prd_code=#{prdCode}"})
    Integer isPrdCodeExist(@Param("prdCode") String prdCode);

    @Update({"update prdt set nouse_dd=#{nouseDd} where prd_no=#{prdNo}"})
   Integer updatePrdtNouseDd(@Param("prdNo") String prdNo,@Param("nouseDd") String s);



   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   /**
    *用于林展导入excel受订单的时候判断sapso表里面是否有这个条数据
    * */


   @Select({"select count(id) from sapso\n" +
           "where\n" +
//           "isnull(timeSameBatch,'')!=#{timesamebatch}\n" +
//           "and\n" +
//           "isnull(uuid,'') !=#{uuid}\n" +
//           "and \n" +
           "isnull(osno,'')=#{osno}\n" +
//           "and\n" +
//           "isnull(ebno,'')=#{ebno}\n" +
           "and\n" +
//           "isnull(caigouno,'')=#{caigouno}\n" +
//           "and \n" +
           "isnull(prdno,'')=#{prdno}\n" +
           "and\n" +
           "isnull(saphh,'')=#{saphh}\n" +
//           "and\n" +
//           "isnull(sapph,'')=#{sapph}\n" +
//           "and \n" +
//           "isnull(sapwlm,'')=#{sapwlm}\n" +
//           "and\n" +
//           "isnull(maitouno,'')=#{maitouno}\n" +
//           "and\n" +
//           "isnull(luohao,'')=#{luohao}\n" +
//           "and\n" +
//           "isnull(ganghao,'')=#{ganghao}\n" +
//           "and\n" +
//           "isnull(realWidth,'')=#{realwidth}\n" +
//           "and\n" +
//           "isnull(realLength,'')=#{reallength}\n" +
//           "and\n" +
//           "isnull(chengfendaima,'')=#{chengFenDaiMa}" +
           ""})
   Integer countIfSapsoExist(Sapso b);

   //通过产品名称中的idxNo找到页面的分类名称fenLeiNo和FenLeiName
   //后来这个方法暂时没用了
    @Select("select a.idx_up as fenLeiNo,b.name as fenLeiName from indx a,indx b " +
            " where a.idx_no=#{idxNo} and a.idx_up=b.idx_no")
    Map<String,String> getFenLeiNoFromIndx(@Param("idxNo") String idxNo);
//   //////////////价格修改模块////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   @Update({"update up_def set  " +
//           "cur_id =#{curIdAfter}," +
//           "qty=#{qtyAfter}, " +
//           "up=#{upAfter}," +
//           "hj_no=#{unitAfter}," +
//           "rem =#{remFrontAfter} " +
//           "  where #{dingJiaZhuJian}=isnull(oleField,'')+isnull(bil_Type,'')+isnull(cur_id,'')+isnull(prd_no,'')"})
   Integer updateUpdef(AlterPrice alterPrice);





   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Select({"select top 1 idx_no from indx where name=#{idxName}"})
   String getIdxNoFromIdxName(@Param("idxName") String idxName);

   @Select({"select top 1 prd_no from prdt where name=#{prdName}"})
    String getPrdNoUsePrdName(@Param("prdName") String prdName);

   @Select({"select  isnull(object_id('tf_pos_z'),-1)"})
    Integer ifExistTfPosZ();


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /**
    *权限模块
    * */
   @Select({"select u.auth from tenant t,users u where t.tenantId=u.tenantId and t.tenantId=#{tenantId} and u.user_name=#{userName}"})
   String getAuth(@Param("tenantId")String tenantId ,@Param("userName")String userName);

   @Select({"select u.uuid from tenant t,users u where t.tenantId=u.tenantId and t.tenantId=#{tenantId} and u.user_name=#{userName}"})
    String getUsersUuid(@Param("tenantId")String tenantId ,@Param("userName")String userName);

   @Select({"select isnull(model_uuid,'') as modelUuid,isnull(users_uuid,'') as usersUuid,isnull(can_use,'') as canUse from model_users where users_uuid=#{usersUuid}"})
   List<ModelUsers> getModelUsers(@Param("usersUuid")String usersUuid);

   @Select({"select top 1 isnull(model_uuid,'') as modelUuid,isnull(model_name,'') as modelName,isnull(rem,'') as rem from model_auth where model_uuid=#{modelUuid}"})
   Model getModels(@Param("modelUuid")String modelUuid);
   ////////////////////////////////////////////////////////////////////////////attach//////////////////////////////////////////////////////////////////////
   //图片搜索模块的根据图片afterUrl得到打样的简单信息
   @Select({" select prd_code as prdtCode,idx_name as prdtName from prdt_samp   where thum like #{urlAfter} or attach like #{urlAfter}"})
    List<SimplePrdtSamp> getSimplePrdtSamps(@Param("urlAfter") String urlAfter);

   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //定价修改记录修改内容模块
   @Select({"SELECT top 20  have_Trans_Up_Other_After as haveTransUpOtherAfter,have_Trans_Up_Other_Before as haveTransUpOtherBefore,have_Trans_Up_My_After as haveTransUpMyAfter,have_Trans_Up_My_Before as haveTransUpMyBefore,no_Trans_Up_Other_After as noTransUpOtherAfter,no_Trans_Up_Other_Before as noTransUpOtherBefore,no_Trans_Up_My_After as noTransUpMyAfter,no_Trans_Up_My_Before as noTransUpMyBefore, ding_jia_guan_lian as dingJiaGuanLian,USER_NAME as userName,tenant_id as tenantId,alter_time as alterTime,prdt_code as prdtCode,prdt_samp_uuid as prdtSampUuid,qty_before as qtyBefore,qty_after as qtyAfter,up_before as upBefore,up_after as upAfter,unit_before as unitBefore,unit_after as unitAfter,rem_front_before as remFrontBefore,rem_front_after as remfrontAfter,bil_type as bilType,cur_id_before as curIdBefore,cur_id_after as curIdAfter,sale_or_buy as saleOrBuy from alter_price_rec where prdt_samp_uuid=#{prdtSampUuid} and sale_or_buy=#{saleOrBuy} order by alter_time desc"})
   List<AlterPriceRecToFront> selectTop20AlterPriceRec(@Param("prdtSampUuid") String prdtSampUuid, @Param("saleOrBuy") String saleOrBuy);


    /////////////////////////////////////////////////////////////////////////////////////////////
   //在prdt表中通过prdNo找主单位ut
   @Select({"select ut from prdt where prd_no=#{prdtNo}"})
    String selectUtByPrdNoFromPrdt(@Param("prdtNo") String prdtNo);

   @Update({"update prdt set ut=#{mainUnit} where prd_no=#{prdtNo}"})
   int updateUtToPrdtUsePrdNo(@Param("prdtNo") String prdtNo,@Param("mainUnit")  String mainUnit);


//   @Select({"select top 80 olefield from up_def  where olefield like '%SamplesSys%'  and prd_no =#{prdNo} and price_id=#{priceId} group by olefield"})
   @Select({"select a.olefield from (select top 80 olefield from up_def  where olefield like '%SamplesSys%'  and prd_no =#{prdNo} and price_id=#{priceId} order by s_dd desc) a group by a.olefield"})
   List<String> getOlefieldUsePrdNo(@Param("prdNo") String prdNo,@Param("priceId") String priceId);

   @Update({"update prdt_samp set prd_no=#{prdNo} where id=#{uuid}"})
    int updatePrdNoByUuid(@Param("uuid")String uuid,@Param("prdNo")String prdNo);

   @Select({"select isnull(attach,'') from prdt_samp where id=#{id}"})
   String selectAttachUseId(@Param("id") String id);


   @Update({"update prdt_samp set attach=#{attach2save} where id=#{id}"})
   int updateAttachById(@Param("id")String id,@Param("attach2save") String attach2save);

   @Select({"select top 1 prd_no  from prdt_cus1 where  cus_no=#{cusOsNo} and sup_prd_no=#{duiFangPrdNo}"})
    String getPrdNoUseCus_noAndSup_prd_noFromPrdt_cus1(@Param("cusOsNo")String cusOsNo,@Param("duiFangPrdNo")String duiFangPrdNo);



  List<DaoChu> getPrdtSamp001(@Param("idList") List<String>idList);


   DaoChu getPrdtSamp002(@Param("bilType")String bilType,@Param("curId")String curId,@Param("priceId")String priceId,@Param("id")String id);


//    List<String> getIdUseConfirmTime(@Param("startConfirmTime") String startConfirmTime,@Param("endConfirmTime")String endConfirmTime);
    List<String> getIdUseConfirmTime(ExportXlsParam ep);
    @Select({"select rto_tax from cust where cus_no=#{cusNo}"})
    Double getTaxRtoFromCust(@Param("cusNo")String cusNo);

    @Select({"select prd_no from prdt_samp where id=#{id}"})
    String getPrdNoFromPrdtSampUseId(@Param("id")String id);

    @Select({"select a.olefield from (select top 80 olefield from up_def where prd_no=#{prdNo} and olefield like #{olefield} and price_id=#{priceId} order by s_dd DESC) a group by a.olefield "})
    List<String> selectTop80Olefiled(@Param("prdNo")String prdNo,@Param("olefield")String olefield,@Param("priceId")String priceId);

    List<String> selectTop80OlefiledAndNoIn(@Param("prdNo")String prdNo
                                            ,@Param("olefield")String olefield,
                                            @Param("priceId")String priceId,
                                            @Param("dingJiaGuanLiansNotIn") List<String> dingJiaGuanLiansNotIn);

    @Select({"select count(*) from up_def where isnull(oleField,'')+isnull(bil_Type,'')+isnull(cur_id,'')+isnull(prd_no,'')=#{dingJiaZhuJian}"})
    int isExsit(@Param("dingJiaZhuJian") String dingJiaZhuJian);

    @Select({"select userPswd from users where user_name=#{userName}"})
    List<String> selectSecretFromUserName(@Param("userName") String userName);

    @Update({"update prdt_samp set main_unit=#{mainUt} where id =#{id}"})
    int  updateUt2PrdtSamp(@Param("id") String id,@Param("mainUt")String mainUt);

    @Select({"select top 1 model_name from model_auth where model_uuid=#{modelUuid}"})
    String selectModelName(@Param("modelUuid") String modelUuid);
}
