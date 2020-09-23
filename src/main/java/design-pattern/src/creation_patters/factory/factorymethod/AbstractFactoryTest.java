package creation_patters.factory.factorymethod;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 16:30
 * @description @link
 */

public class AbstractFactoryTest {
    public static void main(String[] args) {
        try {
            ProductShow a;
            AbstractFactory af;
            af = (AbstractFactory) ReadXML.getObject();
            assert af != null;
            a = af.newProduct();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：提供了产品的接口
interface ProductShow {
    public void show();
}

//具体产品1：实现抽象产品中的抽象方法
class ConcreteProductShow1 implements ProductShow {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ConcreteProductShow2 implements ProductShow {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}

//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public ProductShow newProduct();
}

//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    public ProductShow newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProductShow1();
    }
}

//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    public ProductShow newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProductShow2();
    }
}

class ReadXML {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("F:\\workspace\\sword-offer\\sword-offer-yuan\\src\\main\\java\\design-pattern\\src\\creation_patters\\factory\\factorymethod\\config.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className1");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "creation_patters.factory.factorymethod." + classNode.getNodeValue();
            //System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}