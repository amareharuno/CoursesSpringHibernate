package by.netcracker.bsuir.pz3.courses.web.util;

public final class InputValidation {

    public static boolean validateInput(String firstField, String secondField) {
        boolean isValidateData = false;
        if(firstField != null && secondField != null) {
            if (firstField.length() <= 100 && secondField.length() <= 100) {
                isValidateData = true;
            }
        }
        return isValidateData;
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
