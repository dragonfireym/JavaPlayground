package javacourse;

public interface SurveyGenerator {

	public default void addExample() {
		System.out.println("QuestionAdded");
	}
	
	public void RemoveExample();
}
