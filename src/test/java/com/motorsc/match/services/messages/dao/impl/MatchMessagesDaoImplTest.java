//package com.motorsc.match.services.messages.dao.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.motorsc.base.SpringBase;
//import com.motorsc.match.dto.messages.MatchMessagesPojo;
//import com.motorsc.match.services.messages.dao.MatchMessagesDao;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class MatchMessagesDaoImplTest extends SpringBase{
//
//
//    @Autowired
//    MatchMessagesDao matchMessagesDao;
//
//    @Test
//    public void insert() throws Exception {
//
//        for (int i = 0; i < 100; i++) {
//            MatchMessagesPojo pojo = new MatchMessagesPojo();
//            pojo.setTitle("haha");
//            pojo.setWorkId("sdfsdfsdfsdf");
//            pojo.setToId(String.valueOf(i));
//            int insert = matchMessagesDao.insert(pojo);
//        }
//    }
//
//    @Test
//    public void select() throws Exception {
//        MatchMessagesPojo pojo = matchMessagesDao.get(1L);
//        System.out.println(JSON.toJSONString(pojo));
//    }
//
//    @Test
//    public void update() throws Exception {
//        MatchMessagesPojo pojo = new MatchMessagesPojo();
//        pojo.setTitle("222");
//        pojo.setWorkId("2222222");
//        pojo.setId(1L);
//        int update = matchMessagesDao.update(pojo);
//        System.out.println(update);
//    }
//
//    @Test
//    public void list() throws Exception {
//        MatchMessagesPojo matchMessagesPojo = new MatchMessagesPojo();
//
//        List<MatchMessagesPojo> list = matchMessagesDao.findList(matchMessagesPojo);
//
//        System.out.println(JSON.toJSONString(list));
//        System.out.println(list.size());
//    }
//}