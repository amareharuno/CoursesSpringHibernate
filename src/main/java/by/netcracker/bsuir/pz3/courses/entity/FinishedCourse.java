package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constantString.FinishedCourseTable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = FinishedCourseTable.FINISHED_COURSE_TABLE)
public class FinishedCourse {

    @Id
    @Column(name = FinishedCourseTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = FinishedCourseTable.ASSESSMENT)
    private int assessment;

    @Column(name = FinishedCourseTable.REVIEW)
    private String review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assessment, review);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FinishedCourse{");
        sb.append("id=").append(id);
        sb.append(", assessment=").append(assessment);
        sb.append(", review='").append(review).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
