package by.netcracker.bsuir.pz3.courses.web.util;

public final class InputValidation {

    public static boolean validateCourseInput(String courseName, String subject, String lessonsCount,
                                              String lessonDuration, String teacherId) {
        boolean isValidData = false;
        if(validateInput(courseName, subject, lessonsCount, lessonDuration, teacherId)) { // строки не пусты и меньше 100 символов
            try {
                int lessonsCountNum = Integer.parseInt(lessonsCount);
                int lessonDurationNum = Integer.parseInt(lessonDuration);
                if (lessonsCountNum <= 0 || lessonDurationNum <=0) {
                    return false;
                }
                int number = Integer.parseInt(teacherId);
                isValidData = true;
            } catch (NumberFormatException exception) {
                isValidData = false;
            }
        }
        return isValidData;
    }

    public static boolean validateInput(String firstField, String secondField) {
        boolean isValidData = false;
        if(firstField != null && secondField != null) {
            if (firstField.length() <= 100 && secondField.length() <= 100) {
                isValidData = true;
            }
        }
        return isValidData;
    }

    public static boolean validateInput(String firstField, String secondField, String thirdField) {
        boolean isValidateData = false;
        if(validateInput(firstField, secondField)
                && thirdField != null && thirdField.length() <= 100) {
            isValidateData = true;
        }
        return isValidateData;
    }

    public static boolean validateInput(String firstField, String secondField, String thirdField, String forthField) {
        boolean isValidateData = false;
        if(validateInput(firstField, secondField, thirdField)
                && forthField != null && forthField.length() <= 100) {
            isValidateData = true;
        }
        return isValidateData;
    }

    public static boolean validateInput(
            String firstField,
            String secondField,
            String thirdField,
            String forthField,
            String fifthField) {
        boolean isValidateData = false;
        if(validateInput(firstField, secondField, thirdField, forthField)
                && fifthField != null && fifthField.length() <= 100) {
            isValidateData = true;
        }
        return isValidateData;
    }
}
