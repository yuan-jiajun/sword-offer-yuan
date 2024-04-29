package principle;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 11:24
 * @description @link http://c.biancheng.net/view/1331.html
 * 迪米特法则要求限制软件实体之间通信的宽度和深度，正确使用迪米特法则将有以下两个优点。
 * 降低了类之间的耦合度，提高了模块的相对独立性。
 * 由于亲合度降低，从而提高了类的可复用率和系统的扩展性。
 */
public class LawOfDemeter {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setStar(new Star("star"));
        agent.setFans(new Fans("fan"));
        agent.setCompany(new Company("company"));
        agent.meeting();
        agent.business();
    }
}

//经纪人
class Agent {
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public void setStar(Star myStar) {
        this.myStar = myStar;
    }

    public void setFans(Fans myFans) {
        this.myFans = myFans;
    }

    public void setCompany(Company myCompany) {
        this.myCompany = myCompany;
    }

    public void meeting() {
        System.out.println(myFans.getName() + "与明星" + myStar.getName() + "见面了。");
    }

    public void business() {
        System.out.println(myCompany.getName() + "与明星" + myStar.getName() + "洽淡业务。");
    }
}

//明星
class Star {
    private String name;

    Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//粉丝
class Fans {
    private String name;

    Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//媒体公司
class Company {
    private String name;

    Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
