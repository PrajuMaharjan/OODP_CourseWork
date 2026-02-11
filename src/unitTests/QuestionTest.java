package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quizapp.Question;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    
    private Question questionWithId;
    private Question questionWithoutId;
    
    @BeforeEach
    public void setUp() {
        questionWithId = new Question(
            1, 
            "What is Java?", 
            "A coffee brand", 
            "A programming language", 
            "A country", 
            "An island", 
            "B", 
            "Beginner"
        );
        
        questionWithoutId = new Question(
            "What is Python?", 
            "A snake", 
            "A programming language", 
            "A movie", 
            "A game", 
            "B", 
            "Beginner"
        );
    }
    
    @Test
    public void testQuestionConstructorWithId() {
        assertEquals(1, questionWithId.getQuestionId());
        assertEquals("What is Java?", questionWithId.getQuestionText());
        assertEquals("A coffee brand", questionWithId.getOptionA());
        assertEquals("A programming language", questionWithId.getOptionB());
        assertEquals("A country", questionWithId.getOptionC());
        assertEquals("An island", questionWithId.getOptionD());
        assertEquals("B", questionWithId.getCorrectOption());
        assertEquals("Beginner", questionWithId.getDifficulty());
    }
    
    @Test
    public void testQuestionConstructorWithoutId() {
        assertEquals("What is Python?", questionWithoutId.getQuestionText());
        assertEquals("A snake", questionWithoutId.getOptionA());
        assertEquals("A programming language", questionWithoutId.getOptionB());
        assertEquals("A movie", questionWithoutId.getOptionC());
        assertEquals("A game", questionWithoutId.getOptionD());
        assertEquals("B", questionWithoutId.getCorrectOption());
        assertEquals("Beginner", questionWithoutId.getDifficulty());
    }
    
    @Test
    public void testSetQuestionId() {
        questionWithId.setQuestionId(100);
        assertEquals(100, questionWithId.getQuestionId());
    }
    
    @Test
    public void testSetQuestionText() {
        questionWithId.setQuestionText("Updated question?");
        assertEquals("Updated question?", questionWithId.getQuestionText());
    }
    
    @Test
    public void testSetOptionA() {
        questionWithId.setOptionA("New Option A");
        assertEquals("New Option A", questionWithId.getOptionA());
    }
    
    @Test
    public void testSetOptionB() {
        questionWithId.setOptionB("New Option B");
        assertEquals("New Option B", questionWithId.getOptionB());
    }
    
    @Test
    public void testSetOptionC() {
        questionWithId.setOptionC("New Option C");
        assertEquals("New Option C", questionWithId.getOptionC());
    }
    
    @Test
    public void testSetOptionD() {
        questionWithId.setOptionD("New Option D");
        assertEquals("New Option D", questionWithId.getOptionD());
    }
    
    @Test
    public void testSetCorrectOption() {
        questionWithId.setCorrectOption("A");
        assertEquals("A", questionWithId.getCorrectOption());
    }
    
    @Test
    public void testSetDifficultyIntermediate() {
        questionWithId.setDifficulty("Intermediate");
        assertEquals("Intermediate", questionWithId.getDifficulty());
    }
    
    @Test
    public void testSetDifficultyAdvanced() {
        questionWithId.setDifficulty("Advanced");
        assertEquals("Advanced", questionWithId.getDifficulty());
    }
    
    @Test
    public void testAllOptionsAreDifferent() {
        assertNotEquals(questionWithId.getOptionA(), questionWithId.getOptionB());
        assertNotEquals(questionWithId.getOptionB(), questionWithId.getOptionC());
        assertNotEquals(questionWithId.getOptionC(), questionWithId.getOptionD());
    }
    
    @Test
    public void testQuestionWithEmptyText() {
        Question emptyQuestion = new Question(
            "", "A", "B", "C", "D", "A", "Beginner"
        );
        assertEquals("", emptyQuestion.getQuestionText());
    }
    
    @Test
    public void testCorrectAnswerA() {
        Question question = new Question(1, "Test?", "Correct", "Wrong", "Wrong", "Wrong", "A", "Beginner");
        assertEquals("A", question.getCorrectOption());
    }
    
    @Test
    public void testCorrectAnswerD() {
        Question question = new Question(1, "Test?", "Wrong", "Wrong", "Wrong", "Correct", "D", "Beginner");
        assertEquals("D", question.getCorrectOption());
    }
}
