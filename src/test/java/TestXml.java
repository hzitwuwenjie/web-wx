import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.web.entity.TextMessage;

/**
 * 　　  　  　           \\\|///
 * 　　　 　  　   \\　.-.-　//
 * 　　　　　  　(　 .@.@　)
 * +-------oOOo-----( _ )-----oOOo--------------------------------------------+
 * |　@author 　༺༺超༒神༻༻
 * |　@author 深圳合众艾特信息技术有限公司
 * |　@create 2017年08月11日 - 9:19
 * |    @description 使用Xschema 来完成对象到xml的转换。或者XML到对象的转换
 * +---------------------------------Oooo---------------------------------------+
 */
public class TestXml {

    public static void main(String[] args) {
        
        String xml="<xml>" +
                "<ToUserName>gh_0183e39a2b4f</ToUserName>" +
                "<FromUserName>oAJ-e1E6XCjuCf3NGhCPumYkgvq8</FromUserName>" +
                "<CreateTime>1502413568</CreateTime>" +
                "<MsgType>text</MsgType>" +
                "<Content>zwm</Content>" +
                "<MsgId>6452817140078584287</MsgId>" +
                "</xml> ";
        XStream xstream2 = new XStream(new DomDriver());
        xstream2.alias("xml",TextMessage.class);
        TextMessage ob= (TextMessage)xstream2.fromXML(xml);
         System.out.println(ob.getToUserName());
        System.out.println(ob.getFromUserName());
        System.out.println(ob.getMsgType());

    }
}
