package www.fillingform;

class QuestionsAndAnswers {
	private short counterQuestions;
	private List<String[]> questionsAndAnswers = new ArrayList<>();

	QuestionsAndAnswers() {
		counterQuestions = 0;
		questionsAndAnswers.add(String[]{"Вопрос1", null});
		questionsAndAnswers.add(String[]{"Вопрос2", null});
	}

	public void giveAnAnswer(String answer) {
		counterQuestions++;

		if(counterQuestions)
	}

	public String askTheQuestion() {
		new Message()
		         .from(group)
		         .to(message.authorId())
		         .text(questionsAndAnswers.get(counterQuestions)[0])
		         .send();
	}
}