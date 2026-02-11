package quizapp;
public class Validation {
	
    public static boolean isValidUsername(String username) {
        if (username==null || username.trim().isEmpty()) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_ ]{3,20}$");
    }

    public static boolean isValidPassword(String password) {
        if (password==null || password.trim().isEmpty()) {
            return false;
        }
        if(password.length()>=4) {
        	return true;
        }else {
        	return false;
        }
    }

    public static boolean isValidQuestionText(String questionText) {
        return questionText!=null && !questionText.trim().isEmpty();
    }

    public static boolean isValidOption(String option) {
        return option!=null && !option.trim().isEmpty();
    }

    public static boolean isValidCorrectOption(String option) {
        return option!=null && option.matches("^[A-D]$");
    }

    public static boolean isValidDifficulty(String difficulty) {
        return difficulty!=null && 
               (difficulty.equals("Beginner") || 
                difficulty.equals("Intermediate") || 
                difficulty.equals("Advanced"));
    }

    public static boolean isNumeric(String str) {
        if (str==null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String validateQuestion(String questionText, String optionA, String optionB, 
                                         String optionC, String optionD, String correctOption, 
                                         String difficulty) {
        if (!isValidQuestionText(questionText)) {
            return "Question text cannot be empty";
        }
        if (!isValidOption(optionA)) {
            return "Option A cannot be empty";
        }
        if (!isValidOption(optionB)) {
            return "Option B cannot be empty";
        }
        if (!isValidOption(optionC)) {
            return "Option C cannot be empty";
        }
        if (!isValidOption(optionD)) {
            return "Option D cannot be empty";
        }
        if (!isValidCorrectOption(correctOption)) {
            return "Correct option must be A, B, C, or D";
        }
        if (!isValidDifficulty(difficulty)) {
            return "Difficulty must be Beginner, Intermediate, or Advanced";
        }
        return null;
    }
}