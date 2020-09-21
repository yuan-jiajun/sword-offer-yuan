package upup.jdktheory.setput;

import java.util.Objects;

/**
 * @author Yuan Jiajun
 * @date 2020/9/21 16:07
 * @description @link
 */
public class Student {
    private String sid;
    private String sname;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student(String sid, String sname) {
        super();
        this.sid = sid;
        this.sname = sname;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) &&
                Objects.equals(sname, student.sname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname);
    }
}