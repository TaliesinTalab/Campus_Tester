package bones.tester;

public class Question {
    private final String text;
    private final boolean answer;

    public Question(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }
    public String getText() {return text;}
    public boolean isAnswer() {return answer;}
}
