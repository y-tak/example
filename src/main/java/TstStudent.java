import entity.Group;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstStudent {
    public static void main(String[] args) {
        Student qwe=new Student();
        qwe.setName("qwe");

        Student rew =new Student();
        rew.setName("rew");


        Group gr=new Group();
        gr.setGroupName("jjj");

        Group gr1=new Group();
        gr1.setGroupName("jjj1");


        qwe.getGroups().add(gr1);
        qwe.getGroups().add(gr);

        rew.getGroups().add(gr);

        gr.getStudents().add(qwe);
        gr.getStudents().add(rew);

        gr1.getStudents().add(rew);

        EntityManagerFactory factory= Persistence.createEntityManagerFactory("OrmExample");
        EntityManager manager=factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(qwe);
        manager.persist(rew);
      ///группы не надо добавлять они добавлятьс яавтоматичски как связная таблица
        manager.getTransaction().commit();

        System.out.println("студент ");
        List<Student> studentList=manager.find(Group.class,2).getStudents();
        for (Student st:studentList
             ) {
            System.out.println("st = " + st.getName());

        }

        System.out.println(" группа  ");
        List<Group> groups=manager.find(Student.class,1).getGroups();
        for (Group ggr:groups
        ) {
            System.out.println("group = " + ggr.getGroupName());

        }

        manager.close();
        factory.close();


    }
}
