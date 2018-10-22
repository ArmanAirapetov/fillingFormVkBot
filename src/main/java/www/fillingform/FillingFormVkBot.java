package www.fillingform;

import com.petersamokhin.bots.sdk.*;
import com.petersamokhin.bots.sdk.clients.*;
import com.petersamokhin.bots.sdk.objects.*;

public class FillingFormVkBot {
	private Group group = new Group();
	private UsersManager usersManager = new UsersManager();

	public static void main(String[] args) {
		new FillingFormVkBot().run();
	}

	public void run() {
		group.onSimpleTextMessage(message -> {
			Integer authorId = message.authorId();
			QuestionsAndAnswers questionsAndAnswersUser = usersManager.get(authorId);
			
			if(questionsAndAnswersUser == null) {
				new Message()
		         .from(group)
		         .to(message.authorId())
		         .text("Пожалуйста, введите команду \"start\"")
		         .send();
			} else {
				questionsAndAnswersUser.askTheQuestion();
			}
		});

		group.onCommand("start", message -> {
			Integer authorId = message.authorId();
			usersManager.add(authorId, new QuestionsAndAnswers());		
			usersManager.get(authorId).askTheQuestion();
		});

		group.onPhotoMessage(message ->
		    new Message()
				         .from(group)
				         .to(message.authorId())
				         .text("Уже лучше. Но я тоже так могу. Что дальше?")
				         .send()
		);

		group.onVoiceMessage(message ->
    		new Message()
				         .from(group)
				         .to(message.authorId())
				         .text("Не охота мне голосовые твои слушать.")
				         .send()
		);	
	}
}