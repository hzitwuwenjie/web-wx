package com.web.servlet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.web.entity.ImageAndTextMessage;
import com.web.entity.Item;
import com.web.entity.TextMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

@WebServlet(name = "Hello",value = "/wx")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        System.out.println("测试一下。有一个请求过来了"+request.getRemoteAddr());
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        System.out.println("signature==>"+signature);
        System.out.println("timestamp==>"+timestamp);
        System.out.println("nonce==>"+nonce);
        System.out.println("echostr==>"+echostr);
        if(echostr!=null)
             out.print(echostr);
        //将XML变成消息对象
        TextMessage txt= printLog(request);
        //在页面上输出XML用于回复 微信用户
        ImageAndTextMessage replay=new ImageAndTextMessage();
        replay.setFromUserName(txt.getToUserName());
        replay.setToUserName(txt.getFromUserName());
        replay.setCreateTime(System.currentTimeMillis());
        replay.setMsgType("news");
        replay.setArticleCount(2);
        ArrayList<Item> tuwen=new ArrayList<Item>();
        Item it1=new Item();
        it1.setTitle("美发券");
        it1.setDescription("美丽的美发卷");
        it1.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503021104&di=55b97982083bc95f5f068b769126a2a1&imgtype=jpg&er=1&src=http%3A%2F%2Fimg01.taopic.com%2F151021%2F240400-1510210Q94023.jpg");
        it1.setUrl("http://www.baidu.com");

        Item it2=new Item();
        it2.setTitle("美发券2");
        it2.setDescription("美丽的美发卷");
        it2.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503021104&di=55b97982083bc95f5f068b769126a2a1&imgtype=jpg&er=1&src=http%3A%2F%2Fimg01.taopic.com%2F151021%2F240400-1510210Q94023.jpg");
        it2.setUrl("http://www.baidu.com");
        tuwen.add(it1);
        tuwen.add(it2);

        replay.setArticles(tuwen);

        // 将对象转换成XML
        XStream x = new XStream(new DomDriver());
        x.alias("xml",ImageAndTextMessage.class);
        x.alias("item",Item.class);
        String xml=x.toXML(replay);
        out.print(xml);
        System.out.println(xml.replaceAll("<","{").replaceAll(">","}"));

        out.close();










    }


    private TextMessage printLog(HttpServletRequest request) throws ServletException, IOException {
        XStream xstream2 = new XStream(new DomDriver());
        xstream2.alias("xml",TextMessage.class);
        //接受POST过来的XML数据
        InputStream input= request.getInputStream();
        TextMessage txt=(TextMessage)xstream2.fromXML(input);
        input.close();
        return txt;

      /*  InputStreamReader iputreader=new InputStreamReader(input,"UTF-8");
        BufferedReader breader=new BufferedReader(iputreader);
        StringBuffer xml=new StringBuffer();
        String line=breader.readLine();
        while(line!=null){
            xml.append(line);
            line=breader.readLine();
        }
        breader.close();
        iputreader.close();
        input.close();
        //System.out.println(xml);
        //能不能将这个字符串中的"<",">"替换一下
        String showstring=xml.toString().replaceAll("<","[").replaceAll(">","]");
        System.out.println(showstring);*/
    }
}
