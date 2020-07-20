package jvm.jvm_in_action._005;


import java.util.List;
import java.util.Vector;

/**
 * @author liyazhou1
 * @date 2020/4/13
 */
public class Student {

    private int id;

    private String name;

    private List<WebPage> history = new Vector<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebPage> getHistory() {
        return history;
    }

    public void setHistory(List<WebPage> history) {
        this.history = history;
    }

    public void visit(WebPage webPage) {
        history.add(webPage);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
