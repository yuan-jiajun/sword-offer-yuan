package structure_patters.decorator;

/**
 * @author Yuan Jiajun
 * @date 2020/9/24 10:36
 * @description @link
 */
//Component 英雄接口
interface Hero {
    //学习技能
    void learnSkills();
}

//ConcreteComponent 具体英雄盲僧
class BlindMonk implements Hero {

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}

//Decorator 技能栏
class Skills implements Hero {

    //持有一个英雄对象接口
    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null)
            hero.learnSkills();
    }
}

//ConreteDecorator 技能：Q
class Skill_Q extends Skills {

    private String skillName;

    public Skill_Q(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能Q:" + skillName);
        super.learnSkills();
    }
}

//ConreteDecorator 技能：W
class Skill_W extends Skills {

    private String skillName;

    public Skill_W(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能W:" + skillName);
        super.learnSkills();
    }
}

//ConreteDecorator 技能：E
class Skill_E extends Skills {

    private String skillName;

    public Skill_E(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能E:" + skillName);
        super.learnSkills();
    }
}

//ConreteDecorator 技能：R
class Skill_R extends Skills {

    private String skillName;

    public Skill_R(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能R:" + skillName);
        super.learnSkills();
    }
}

//客户端：召唤师
public class Player {
    public static void main(String[] args) {
        //选择英雄
        Hero hero = new BlindMonk("李青");

        Skills skills = new Skills(hero);
        Skills r = new Skill_R(skills, "猛龙摆尾");
        Skills e = new Skill_E(r, "天雷破/摧筋断骨");
        Skills w = new Skill_W(e, "金钟罩/铁布衫");
        Skills q = new Skill_Q(w, "天音波/回音击");
        //学习技能
        q.learnSkills();
    }
}