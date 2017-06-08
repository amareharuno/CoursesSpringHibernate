package by.netcracker.bsuir.pz3.courses.util;

public enum  RoleChecker {
    INSTANCE;

    public final boolean isTeacher(String role) {
        return role != null && role.equals("on");
    }

    public final boolean isStudent(String role) {
        return role == null || role.equals("");
    }
}
