import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.web.entity.ImageAndTextMessage;
import com.web.entity.Item;
import com.web.entity.TextMessage;

import javax.xml.soap.Text;
import java.util.ArrayList;

/**
 * 　　  　  　           \\\|///
 * 　　　 　  　   \\　.-.-　//
 * 　　　　　  　(　 .@.@　)
 * +-------oOOo-----( _ )-----oOOo--------------------------------------------+
 * |　@author 　༺༺超༒神༻༻
 * |　@author 深圳合众艾特信息技术有限公司
 * |　@create 2017年08月11日 - 9:38
 * |    @description
 * +---------------------------------Oooo---------------------------------------+
 */
public class TestObject {

    public static void main(String[] args) {

        //将一个对象转换成XML输出

        XStream x = new XStream(new DomDriver());
        ImageAndTextMessage replay=new ImageAndTextMessage();
        replay.setFromUserName("d");
        replay.setToUserName("sdfa");
        replay.setCreateTime(System.currentTimeMillis());
        replay.setMsgType("news");
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

        x.alias("xml",ImageAndTextMessage.class);
        x.alias("item",Item.class);
        String xml=x.toXML(replay);
        System.out.println(xml);


    }
}
