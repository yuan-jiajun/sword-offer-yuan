package creation_patters.builder;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.io.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 20:58
 * @description @link
 */

public class ParlourDecorator {
    public static void main(String[] args) {
        try {
            AbstractDecorator d;
            d = (AbstractDecorator) ReadXML.getObject();
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//产品：客厅
class Parlour {
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show() {
        String parlour = wall + "\t" + TV + "\t" + sofa;
        System.out.println(parlour);
    }
}

//抽象建造者：装修工人
abstract class AbstractDecorator {
    //创建产品对象
    protected Parlour product = new Parlour();

    public abstract void buildWall();

    public abstract void buildTV();

    public abstract void buildSofa();

    //返回产品对象
    public Parlour getResult() {
        return product;
    }
}

//具体建造者：具体装修工人1
class ConcreteDecorator1 extends AbstractDecorator {
    public void buildWall() {
        product.setWall("wall 1");
    }

    public void buildTV() {
        product.setTV("TV 1");
    }

    public void buildSofa() {
        product.setSofa("sofa 1");
    }
}

//具体建造者：具体装修工人2
class ConcreteDecorator2 extends AbstractDecorator {
    public void buildWall() {
        product.setWall("wall 2");
    }

    public void buildTV() {
        product.setTV("TV 2");
    }

    public void buildSofa() {
        product.setSofa("sofa 2");
    }
}

//指挥者：项目经理
class ProjectManager {
    private AbstractDecorator decorator;

    public ProjectManager(AbstractDecorator decorator) {
        this.decorator = decorator;
    }

    //产品构建与组装方法
    public Parlour decorate() {
        decorator.buildWall();
        decorator.buildTV();
        decorator.buildSofa();
        return decorator.getResult();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("F:\\workspace\\sword-offer\\sword-offer-yuan\\src\\main\\java\\design-pattern\\src\\creation_patters\\builder\\config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "creation_patters.builder." + classNode.getNodeValue();
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


class ReadXML2 {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("F:\\workspace\\sword-offer\\sword-offer-yuan\\src\\main\\java\\design-pattern\\src\\creationpatter\\factory\\factorymethod\\config.xml"));
            NodeList nodelist = doc.getElementsByTagName("className2");
            Node node = nodelist.item(0).getFirstChild();
            String cName = "creation_patters.factory.factorymethod." + node.getNodeValue();
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}