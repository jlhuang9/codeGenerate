//package com.motorsc.match.services.messages.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.motorsc.base.SpringBase;
//import com.motorsc.match.common.tool.PageResult;
//import com.motorsc.match.dto.messages.MatchMessagesPojo;
//import com.motorsc.match.service.messages.service.MatchMessagesService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//
//public class MatchMessagesServiceImplTest extends SpringBase {
//
//    @Autowired
//    MatchMessagesService matchMessagesService;
//
//    @Test
//    public void name() throws Exception {
//        MatchMessagesPojo pojo = new MatchMessagesPojo();
//        pojo.setIsReady(1);
//
//        int insert = matchMessagesService.insert(pojo);
//        System.out.println(insert);
//    }
//
//    @Test
//    public void insert() throws Exception {
//        MatchMessagesPojo matchMessagesPojo = new MatchMessagesPojo();
//
//        PageResult<MatchMessagesPojo> matchMessagesList = matchMessagesService.getMatchMessagesList(matchMessagesPojo);
//        System.out.println(matchMessagesList.getTotal());
//        System.out.println(JSON.toJSONString(matchMessagesList));
//    }
//
//    @Test
//    public void getOne() throws Exception {
//        MatchMessagesPojo pojo = matchMessagesService.get(1L);
//        System.out.println(JSON.toJSONString(pojo));
//    }
//}