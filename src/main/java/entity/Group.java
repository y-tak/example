package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "some_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String groupName;

    @ManyToMany(mappedBy = "groups") /// c каким полем мы будем связывать поле студенты с полем группа
    private List<Student> students=new ArrayList<Student>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
