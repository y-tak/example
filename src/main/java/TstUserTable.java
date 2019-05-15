import entity.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class TstUserTable {
    public static void main(String[] args) {

        ///---создается набор сущностей для базы
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrmExample");
        ///---менеджер управления сущностями
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        UserTable userTable=new UserTable();
       // userTable.setLogin("tyu");

       /// entityManager.persist(userTable);///передали , но не добавили объект класса в таблицу
        ////entityManager.getTransaction().rollback();//откат до предыдущей транзакции
        
        ///--получение пользователя----
        UserTable userTableFromDB=entityManager.find(UserTable.class,51);
        System.out.println("userTableFromDB = " + userTableFromDB);
        
        entityManager.getTransaction().commit();//подтверждение добавления объекта

        entityManager.close();
        entityManagerFactory.close();



    }
}
