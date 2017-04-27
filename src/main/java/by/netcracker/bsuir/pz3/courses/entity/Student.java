package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constantString.StudentTable;

import javax.persistence.*;

@Entity
@Table(name = StudentTable.STUDENT_TABLE)
public class Student {

    @Id
    @Column(name = StudentTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
