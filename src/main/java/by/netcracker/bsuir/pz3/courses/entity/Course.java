package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.constant.CourseTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = CourseTable.COURSE_TABLE)
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
    @Column(name = CourseTable.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = CourseTable.SUBJECT)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = CourseTable.NAME)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = CourseTable.LESSONS_COUNT)
    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    @Column(name = CourseTable.LESSON_DURATION)
    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    @Column(name = CourseTable.COURSE_DURATION)
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
