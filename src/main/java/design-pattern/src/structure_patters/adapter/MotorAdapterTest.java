package structure_patters.adapter;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 21:55
 * @description @link
 */


//目标：发动机
interface Engine {
    public void engine();
}

//适配者1：电能发动机
class ElectricEngine {
    public void electricEngine() {
        System.out.println("电能发动机驱动汽车！");
    }
}

//适配者2：光能发动机
class OpticalEngine {
    public void opticalEngine() {
        System.out.println("光能发动机驱动汽车！");
    }
}

//电能适配器
class ElectricAdapter implements Engine {
    private ElectricEngine electricEngine;

    public ElectricAdapter() {
        electricEngine = new ElectricEngine();
    }

    public void engine() {
        electricEngine.electricEngine();
    }
}

//光能适配器
class OpticalAdapter implements Engine {
    private OpticalEngine opticalEngine;

    public OpticalAdapter() {
        opticalEngine = new OpticalEngine();
    }

    public void engine() {
        opticalEngine.opticalEngine();
    }
}

//客户端代码
public class MotorAdapterTest {
    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        Engine engine = (Engine) ReadXML.getObject();
        assert engine != null;
        engine.engine();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            return new OpticalAdapter();
//            return new ElectricAdapter();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}