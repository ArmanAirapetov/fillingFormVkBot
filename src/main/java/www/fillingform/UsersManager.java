package www.fillingform;

class UsersManager implements Runnable {
	private Map<Integer, QuestionsAndAnswers> users = new HashMap<>();

	public void run() {

	}

	synchronized void add(User user) {
		users.add(user);
	}

	synchronized  get
}