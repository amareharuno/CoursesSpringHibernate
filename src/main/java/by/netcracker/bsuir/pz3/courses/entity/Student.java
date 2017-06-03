package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.constant.DatabaseTableInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = DatabaseTableInfo.STUDENT_TABLE)
public class Student implements Serializable {

    private int id;

    public Student() {
    }

    @Id
    @Column(name = DatabaseTableInfo.STUDENT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
