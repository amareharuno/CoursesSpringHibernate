package by.netcracker.bsuir.pz3.courses.service.util;

public enum  RoleChecker {
    INSTANSE;

    private final String teacher = "teacher";
    private final String student = "student";

    public final boolean isTeacher(String role) {
        return role.equals(teacher);
    }

    public final boolean isStudent(String role) {
        return role.equals(student);
    }
}
