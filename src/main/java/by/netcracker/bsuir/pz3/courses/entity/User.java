package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constantString.UserTable;

import javax.persistence.*;

@Entity
@Table(name = UserTable.USER_TABLE)
public class User {

    @Id
    @Column(name = UserTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = UserTable.LOGIN)
    private String login;

    @Column(name = UserTable.PASSWORD)
    private String password;

    @Column(name = UserTable.FIRST_NAME)
    private String FirstName;

    @Column(name = UserTable.LAST_NAME)
    private String LastName;

    @Column(name = UserTable.MIDDLE_NAME)
    private String MiddleName;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }
}
