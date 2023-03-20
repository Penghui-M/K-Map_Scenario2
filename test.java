public class test {
    public static void main(String[] args) {
        Question bank = new Question();
        System.out.println(bank.getQuestions());
        System.out.println(bank.getAnswers());
        bank.addQuestion("A", "A");
        bank.save();
    }
}
