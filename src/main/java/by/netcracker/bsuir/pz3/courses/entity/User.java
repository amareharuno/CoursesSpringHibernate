package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.bdTableInfo.UserTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = UserTable.USER_TABLE)
public class User implements Serializable {

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

    public User() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(FirstName, user.FirstName) &&
                Objects.equals(LastName, user.LastName) &&
                Objects.equals(MiddleName, user.MiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, FirstName, LastName, MiddleName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", FirstName='").append(FirstName).append('\'');
        sb.append(", LastName='").append(LastName).append('\'');
        sb.append(", MiddleName='").append(MiddleName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
