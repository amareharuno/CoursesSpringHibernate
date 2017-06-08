package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constant.DatabaseTableInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = DatabaseTableInfo.STUDENT_TABLE)
public class Student implements Serializable {

    @Id
    @Column(name = DatabaseTableInfo.STUDENT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = DatabaseTableInfo.STUDENT_USER_ID)
    private User user;

//    @ManyToMany
//    private List<Course> courses;

//    @OneToMany
//    private List<FinishedCourse> finishedCourses;

    public Student() {
    }

    public Student(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }
//
//    public List<FinishedCourse> getFinishedCourses() {
//        return finishedCourses;
//    }
//
//    public void setFinishedCourses(List<FinishedCourse> finishedCourses) {
//        this.finishedCourses = finishedCourses;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(user, student.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
