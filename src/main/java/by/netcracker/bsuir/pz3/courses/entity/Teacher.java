package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constantString.TeacherTable;

import javax.persistence.*;

@Entity
@Table(name = TeacherTable.TEACHER_TABLE)
public class Teacher {

    @Id
    @Column(name = TeacherTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
