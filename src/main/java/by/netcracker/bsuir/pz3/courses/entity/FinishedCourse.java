package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constant.DatabaseTableInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = DatabaseTableInfo.FINISHED_COURSE_TABLE)
public class FinishedCourse implements Serializable {

    @Id
    @Column(name = DatabaseTableInfo.FINISHED_COURSE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = DatabaseTableInfo.FINISHED_COURSE_STUDENT_ID)
    private Student student;

    @Column(name = DatabaseTableInfo.ASSESSMENT)
    private int assessment;

    @Column(name = DatabaseTableInfo.REVIEW)
    private String review;

    public FinishedCourse() {
    }

    public FinishedCourse(int assessment, String review) {
        this.assessment = assessment;
        this.review = review;
    }

    public FinishedCourse(Student student, int assessment, String review) {
        this.student = student;
        this.assessment = assessment;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishedCourse that = (FinishedCourse) o;
        return id == that.id &&
                assessment == that.assessment &&
                Objects.equals(student, that.student) &&
                Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, assessment, review);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FinishedCourse{");
        sb.append("id=").append(id);
        sb.append(", student=").append(student);
        sb.append(", assessment=").append(assessment);
        sb.append(", review='").append(review).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
