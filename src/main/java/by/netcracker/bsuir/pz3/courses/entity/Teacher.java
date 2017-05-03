package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.bdTableInfo.TeacherTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = TeacherTable.TEACHER_TABLE)
public class Teacher implements Serializable {

    @Id
    @Column(name = TeacherTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Teacher() {
    }

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
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
