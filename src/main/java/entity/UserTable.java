package entity;

import javax.persistence.*;

@Entity
@Table
public class UserTable {
    ///1 варинант
    //  @Id
    //  @GeneratedValue(strategy=GenerationType.AUTO)

    //2 варинант
   // @Id
  //  @TableGenerator(name = "tgenerator", allocationSize = 1, initialValue = 1)
  //  @GeneratedValue(strategy=GenerationType.TABLE,generator = "tgenerator")
     //Todo: проверить разные варианты генерации
     //Todo: как генерируются SQL запросы,условия WHERE,  по нескольким таблицам
    //3 варинант
//    @Id
//    @SequenceGenerator(name ="sgen",allocationSize = 1)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "sgen")
    private int id;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
