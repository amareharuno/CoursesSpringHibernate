package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.constant.DatabaseTableInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = DatabaseTableInfo.COURSE_TABLE)
public class Course implements Serializable {
    private int id;
    private String subject;
    private String courseName;
    private int lessonsCount;
    private int lessonDuration;
    private int courseDuration;

    public Course() {
    }

    @Id
    @Column(name = DatabaseTableInfo.COURSE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = DatabaseTableInfo.SUBJECT)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = DatabaseTableInfo.NAME)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = DatabaseTableInfo.LESSONS_COUNT)
    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    @Column(name = DatabaseTableInfo.LESSON_DURATION)
    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    @Column(name = DatabaseTableInfo.COURSE_DURATION)
    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                lessonsCount == course.lessonsCount &&
                lessonDuration == course.lessonDuration &&
                courseDuration == course.courseDuration &&
                Objects.equals(subject, course.subject) &&
                Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, courseName, lessonsCount, lessonDuration, courseDuration);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", lessonsCount=").append(lessonsCount);
        sb.append(", lessonDuration=").append(lessonDuration);
        sb.append(", courseDuration=").append(courseDuration);
        sb.append('}');
        return sb.toString();
    }
}
