package bones.tester;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Controller {
    @FXML
    private Label currentTest;
    @FXML
    private Label questionText;
    @FXML
    private Label answerText;
    @FXML
    private Label currentScore;
    @FXML
    private Label currentQuestion;
    private boolean showCorrectAnswer = true;
    private boolean shuffleQuestions = true;
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;

    @FXML
    public void initialize() {
        answerText.setText("");
        questionText.setText("Please select a test.");
    }
    @FXML
    private void runDigiCom1() {
        runTest(1);
        currentTest.setText("Digital Communications Moodle Test 1");
    }
    @FXML
    private void runDigiCom2() {
        runTest(2);
        currentTest.setText("Digital Communications Moodle Test 2");
    }
    @FXML
    private void runDigiCom3() {
        runTest(3);
        currentTest.setText("Digital Communications Moodle Test 3");
    }
    @FXML
    private void runDigiCom4() {
        runTest(4);
        currentTest.setText("Digital Communications Moodle Test 4");
    }
    @FXML
    private void runDigiComSuper() {
        runTest(5);
        currentTest.setText("Digital Communications Super Moodle Test");
    }
    @FXML
    private void runDigiComCustom1() {
        runTest(6);
        currentTest.setText("Digital Communications Custom Test 1");
    }
    @FXML
    private void runDigiComCustom2() {
        runTest(7);
        currentTest.setText("Digital Communications Custom Test 2");
    }
    @FXML
    private void runDigiComCustom3() {
        runTest(8);
        currentTest.setText("Digital Communications Custom Test 3");
    }
    @FXML
    private void runDigiComCustomSuper() {
        runTest(9);
        currentTest.setText("Digital Communications Super Custom Test");
    }
    @FXML
    private void runTeamCustom1() {
        runTest(10);
        currentTest.setText("Teamarbeit Test | Slides 1-20");
    }
    @FXML
    private void runTeamCustom2() {
        runTest(11);
        currentTest.setText("Teamarbeit Test | Slides 21-40");
    }
    @FXML
    private void runTeamCustom3() {
        runTest(12);
        currentTest.setText("Teamarbeit Test | Slides 41-60");
    }
    @FXML
    private void runTeamCustom4() {
        runTest(13);
        currentTest.setText("Teamarbeit Test | Slides 61-80");
    }
    @FXML
    private void runTeamCustom5() {
        runTest(14);
        currentTest.setText("Teamarbeit Test | Slides 81-100");
    }
    @FXML
    private void runTeamSuper() {
        runTest(15);
        currentTest.setText("Teamarbeit Test | Slides 1-100");
    }
    @FXML
    private void toggleShowCorrectAnswer() {
        showCorrectAnswer = !showCorrectAnswer;
    }
    @FXML
    private void toggleShuffleQuestions() {
        shuffleQuestions = !shuffleQuestions;
    }
    @FXML
    private void shutDown() {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private void trueButtonClick() {
        checkAnswer(true);
    }
    @FXML
    private void falseButtonClick() {
        checkAnswer(false);
    }
    @FXML
    private void nextButtonClick() {
        if (currentQuestionIndex < questions.size()) {
            currentQuestionIndex++;
            showQuestion();
            if (showCorrectAnswer) {answerText.setText("Last question was skipped.");}
            if (!showCorrectAnswer) answerText.setText("");
        }
    }

    private void loadQuestions(String fileName) {
        currentQuestionIndex = 0;
        score = 0;
        questions = new ArrayList<>();
        answerText.setText("");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(fileName + ".txt"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String text = parts[0];
                    boolean answer = Boolean.parseBoolean(parts[1]);
                    questions.add(new Question(text, answer));
                }
            }
            if (questions.isEmpty()) {
                System.err.println("No questions found in file");
            } else if (shuffleQuestions) {
                Collections.shuffle(questions);
            }
        } catch (Exception e) {
            System.err.println("Error loading questions" + e.getMessage());
        }
    }
    private void showQuestion() {
        if (questions.isEmpty()) {
            questionText.setText("No questions available.");
            currentScore.setText("0/0");
            return;
        }
        if (currentQuestionIndex >= questions.size()) {
            questionText.setText("All questions answered.");
            return;
        }
        Question question = questions.get(currentQuestionIndex);
        questionText.setText(question.getText());
        currentQuestion.setText((currentQuestionIndex + 1) + "/" + questions.size());
        updateScore();
    }
    private void checkAnswer(boolean answer) {
        if (currentQuestionIndex >= questions.size()) {
            questionText.setText("No more questions.");
            return;
        }
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (currentQuestion.isAnswer() == answer) {score++;}
        if (showCorrectAnswer) {
            answerText.setText(
                "Previous question: " + currentQuestion.getText() +
                "\nYour last answer: " + answer + ".\n" +
                "Correct answer: " + currentQuestion.isAnswer() + ".");}
        if (!showCorrectAnswer) answerText.setText("");
        currentQuestionIndex++;
        updateScore();
        showQuestion();
    }
    private void updateScore() {
        currentScore.setText(score + "/" + questions.size());
    }
    protected void runTest(int i) {
        if (i == 1) loadQuestions("DigiCom/DigiComMoodle1");
        if (i == 2) loadQuestions("DigiCom/DigiComMoodle2");
        if (i == 3) loadQuestions("DigiCom/DigiComMoodle3");
        if (i == 4) loadQuestions("DigiCom/DigiComMoodle4");
        if (i == 5) loadQuestions("DigiCom/DigiComMoodleSuper");
        if (i == 6) loadQuestions("DigiCom/DigiComCustom1");
        if (i == 7) loadQuestions("DigiCom/DigiComCustom2");
        if (i == 8) loadQuestions("DigiCom/DigiComCustom3");
        if (i == 9) loadQuestions("DigiCom/DigiComCustomSuper");
        if (i == 10) loadQuestions("Teamarbeit/TeamCustom1");
        if (i == 11) loadQuestions("Teamarbeit/TeamCustom2");
        if (i == 12) loadQuestions("Teamarbeit/TeamCustom3");
        if (i == 13) loadQuestions("Teamarbeit/TeamCustom4");
        if (i == 14) loadQuestions("Teamarbeit/TeamCustom5");
        if (i == 15) loadQuestions("Teamarbeit/TeamSuper");

        showQuestion();
    }
}