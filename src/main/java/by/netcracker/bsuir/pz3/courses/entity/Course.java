package by.netcracker.bsuir.pz3.courses.entity;

import by.netcracker.bsuir.pz3.courses.dao.constant.DatabaseTableInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = DatabaseTableInfo.COURSE_TABLE)
public class Course implements Serializable {
    @Id
    @Column(name = DatabaseTableInfo.COURSE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = DatabaseTableInfo.SUBJECT)
    private String subject;

    @Column(name = DatabaseTableInfo.NAME)
    private String courseName;

    @Column(name = DatabaseTableInfo.LESSONS_COUNT)
    private int lessonsCount;

    @Column(name = DatabaseTableInfo.LESSON_DURATION)
    private int lessonDuration;

    @Column(name = DatabaseTableInfo.COURSE_DURATION)
    private int courseDuration;

    @ManyToOne
    @JoinColumn(name = DatabaseTableInfo.COURSE_TEACHER_ID)
    private Teacher teacher;

//    @ManyToMany
//    private List<Student> students;

    public Course() {
    }

    public Course(String subject, String courseName, int lessonsCount, int lessonDuration) {
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
        this.courseDuration = lessonsCount*lessonDuration;
    }

    public Course(String subject, String courseName, int lessonsCount,
                  int lessonDuration, Teacher teacher) {
        this.subject = subject;
        this.courseName = courseName;
        this.lessonsCount = lessonsCount;
        this.lessonDuration = lessonDuration;
        this.courseDuration = lessonsCount*lessonDuration;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

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
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(teacher, course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, courseName, lessonsCount, lessonDuration, courseDuration, teacher);
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
        sb.append(", teacher=").append(teacher);
        sb.append('}');
        return sb.toString();
    }
}
