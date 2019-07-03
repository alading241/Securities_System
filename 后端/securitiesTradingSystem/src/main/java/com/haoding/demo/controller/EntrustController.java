package com.haoding.demo.controller;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.service.serviceImpl.EntrustServiceImpl;
import com.haoding.demo.utils.TimeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  委托交易的控制器
 */
@RestController
//@RequestMapping("/entrust")
public class EntrustController {
    @Autowired
    EntrustServiceImpl entrustService;

    /**
     * 挂单
     * @param userId
     * @param stockId
     * @param number
     * @param price
     * @param type
     * @return
     */
    @GetMapping("/restingOrder")
    @ResponseBody
    @ApiOperation(value = "挂单",notes = "用户添加操作")
    public String restingOrder(String userId,String stockId,int number,double price,String type){
        Map map =new HashMap();
        String msg="";
        String restingOrderTime = TimeUtils.getNowTime();
        boolean flag=entrustService.restingOrder(userId,stockId,restingOrderTime,number,price,type);
        map.put("success",flag);
        msg= JSON.toJSONString(map);
        return msg;
    }

    @GetMapping("/cancellation")
    @ResponseBody
    @ApiOperation(value = "撤单",notes = "用户操作")
    public String cancellation(String entrustId){
        String msg=entrustService.cancellation(entrustId);
        return msg;
    }

    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryResting")
    @ResponseBody
    @ApiOperation(value = "查询当日挂单")
    public String queryResting(String phone){
        String msg=entrustService.queryResting(phone);
        return msg;
        /*ArrayList arrayList=new ArrayList();
        Map map = new HashMap();
        map.put("entrust_id","1231131");
        map.put("stock_id","000727");
        map.put("user_id","12313211");
        map.put("time","2019-06-01 11:10:00");
        map.put("stock_name","我也网络");
        map.put("station","未成");
        map.put("number",1100);
        map.put("price",11.5);

        Map map1 = new HashMap();
        map1.put("entrust_id","1231131");
        map1.put("stock_id","000001");
        map1.put("user_id","12313211");
        map1.put("time","2019-06-01 11:10:00");
        map1.put("stock_name","我网络");
        map1.put("station","未成");
        map1.put("number",1100);
        map1.put("price",11.5);

        Map map2 = new HashMap();
        map2.put("entrust_id","1231131");
        map2.put("stock_id","000827");
        map2.put("user_id","123111211");
        map2.put("time","2019-06-01 11:10:00");
        map2.put("stock_name","我也");
        map2.put("station","未成");
        map2.put("number",1100);
        map2.put("price",11.5);

        arrayList.add(map);
        arrayList.add(map1);
        arrayList.add(map2);
        return JSON.toJSONString(arrayList);*/
    }

    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryEntrust")
    @ResponseBody
    @ApiOperation(value = "查询当日委托")
    public String queryEntrust(String phone){
        String msg=entrustService.queryEntrust(phone);
        return msg;
        /*ArrayList arrayList=new ArrayList();
        Map map = new HashMap();
        map.put("entrust_id","1231131");
        map.put("stock_id","000727");
        map.put("user_id","12313211");
        map.put("time","2019-06-01 11:10:00");
        map.put("stock_name","我也网络");
        map.put("station","已成");
        map.put("type","buy");
        map.put("entrustMount",1000);
        map.put("dealMount",300);
        map.put("averagePrice",11.2);

        Map map1 = new HashMap();
        map1.put("entrust_id","1231131");
        map1.put("stock_id","000001");
        map1.put("user_id","12313211");
        map.put("time","2019-06-01 11:10:00");
        map1.put("stock_name","我网络");
        map1.put("station","未成");
        map1.put("type","sell");
        map1.put("entrustMount",1000);
        map1.put("dealMount",300);
        map1.put("averagePrice",11.2);

        Map map2 = new HashMap();
        map2.put("entrust_id","1231131");
        map2.put("stock_id","000827");
        map2.put("user_id","123111211");
        map2.put("time","2019-06-01 11:10:00");
        map2.put("stock_name","我也");
        map2.put("station","已撤");
        map2.put("type","buy");
        map2.put("entrustMount",1000);
        map2.put("dealMount",300);
        map2.put("averagePrice",11.2);

        arrayList.add(map);
        arrayList.add(map1);
        arrayList.add(map2);
        return JSON.toJSONString(arrayList);*/
    }


    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryPurchase")
    @ResponseBody
    @ApiOperation(value = "查询当日成交")
    public String queryPurchase(String phone){
        String msg=entrustService.queryPurchase(phone);
        return msg;
        /*ArrayList arrayList=new ArrayList();
        Map map = new HashMap();
        map.put("entrust_id","1231131");
        map.put("stock_id","000727");
        map.put("user_id","12313211");
        map.put("time","2019-06-01 11:10:00");
        map.put("stock_name","我也网络");
        map.put("station","已成");
        map.put("number",1100);
        map.put("type","buy");
        map.put("dealPrice",11.5);
        map.put("dealTotalPrice",2000);

        Map map1 = new HashMap();
        map1.put("entrust_id","1231131");
        map1.put("stock_id","000001");
        map1.put("user_id","12313211");
        map1.put("time","2019-06-01 11:10:00");
        map1.put("stock_name","我网络");
        map1.put("station","已成");
        map1.put("number",1100);
        map1.put("type","sell");;
        map1.put("dealPrice",11.5);
        map1.put("dealTotalPrice",2000);

        Map map2 = new HashMap();
        map2.put("entrust_id","1231131");
        map2.put("stock_id","000827");
        map2.put("user_id","123111211");
        map2.put("time","2019-06-01 11:10:00");
        map2.put("stock_name","我也");
        map2.put("station","已成");
        map2.put("number",1100);
        map2.put("type","buy");
        map2.put("dealPrice",11.5);
        map2.put("dealTotalPrice",2000);

        arrayList.add(map);
        arrayList.add(map1);
        arrayList.add(map2);
        return JSON.toJSONString(arrayList);*/
    }



}
