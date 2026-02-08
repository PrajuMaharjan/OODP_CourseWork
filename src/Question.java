public class Question {
    private int questionId;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
    private String difficulty;

    public Question(int questionId, String questionText, String optionA, String optionB, 
                   String optionC, String optionD, String correctOption, String difficulty) {
        this.questionId=questionId;
        this.questionText=questionText;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.correctOption=correctOption;
        this.difficulty=difficulty;
    }

    public Question(String questionText, String optionA, String optionB, 
                   String optionC, String optionD, String correctOption, String difficulty) {
        this.questionText=questionText;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.correctOption=correctOption;
        this.difficulty=difficulty;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setQuestionId(int questionId) {
        this.questionId=questionId;
    }

    public void setQuestionText(String questionText) {
        this.questionText=questionText;
    }

    public void setOptionA(String optionA) {
        this.optionA=optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB=optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC=optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD=optionD;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption=correctOption;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty=difficulty;
    }
}