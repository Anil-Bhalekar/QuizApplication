package oopsdemo;

import java.util.Scanner;

public class QuizApplication {

	public static void main(String[] args) {
	
		
		 Quiz quiz = new Quiz();
	        quiz.begin();

	    }
	}

	class Quiz
	{
	    void begin()
	    {
	        Question[] questions = new Question[5];

	        questions[0] = new Question("1.Number of primitive data types in Java are?","Six","Five","Seven","Eight", new Answer("Eight"));
	        questions[1] = new Question("2.Automatic type conversion is possible in which of the possible cases?","Byte to int","Int to long","Long to int","Short to int", new Answer("Int to long"));
	        questions[2] = new Question("3.Select the valid statement.","char[]ch=new char[5]","char[]ch=new char(5)","char[]ch=new char()","char[]ch=new char[]", new Answer("char[]ch=new char[5]"));
	        questions[3] = new Question(" \r\n"
	        		+ "4.When is the object created with new keyword?","At compile time","depends on code","At run time","None", new Answer("At run time"));
	        questions[4] = new Question(" \r\n"
	        		+ "5.Identify the corrected definition of a package","Apackage is a collection of editing tools","A package is a collection of edition tools","A package is a collection of interfaces","A package is a collection of class and interfaces", new Answer("A package is a collection of class and interfaces"));

	        int countTotal = 0;
	        int countRight = 0;
	        int countWrong = 0;

	        for(Question q: questions)
	        {
	            System.out.println(q.getQuestion());
	            System.out.println("a : " +q.getOption1());
	            System.out.println("b : " +q.getOption2());
	            System.out.println("c : " +q.getOption3());
	            System.out.println("d : " +q.getOption4());

	            String answer = "";

	            char ans;
	            System.out.println("Enter your answer");
	            Scanner scan = new Scanner(System.in);
	            ans = scan.next().charAt(0);

	            switch(ans)
	            {
	                case 'a':
	                    answer = q.getOption1();
	                    break;
	                case 'b':
	                    answer = q.getOption2();
	                    break;
	                case 'c':
	                    answer = q.getOption3();
	                    break;
	                case 'd':
	                    answer = q.getOption4();
	                    break;
	                default:break;
	            }
	            System.out.println("Your answer " + answer + " " + q.getAnswer());
	            if(answer.equals(q.getAnswer().getAnswer()))
	            {
	                System.out.println("------------------------------------------------------");
	                System.out.println("                  Correct Answer                      ");
	                System.out.println("------------------------------------------------------");
	                countRight++;
	            }
	            else
	            {
	                System.out.println("------------------------------------------------------");
	                System.out.println("                  Wrong Answer                      ");
	                System.out.println("------------------------------------------------------");
	                countWrong++;
	            }
	            System.out.println("============================================================================================");
	            countTotal++;
	        }

	        Result result = new Result(countTotal,countRight,countWrong);
	        result.showResult();
	    }
	}

	class Question
	{

	    String question;
	    String option1;
	    String option2;
	    String option3;
	    String option4;
	    Answer answer;

	    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
	        this.question = question;
	        this.option1 = option1;
	        this.option2 = option2;
	        this.option3 = option3;
	        this.option4 = option4;
	        this.answer = answer;
	    }

	    public String getQuestion() {
	        return question;
	    }

	    public String getOption1() {
	        return option1;
	    }

	    public String getOption2() {
	        return option2;
	    }

	    public String getOption3() {
	        return option3;
	    }

	    public String getOption4() {
	        return option4;
	    }

	    public Answer getAnswer() {
	        return answer;
	    }
	}

	class Answer
	{
	    String answer;

	    public Answer(String answer) {
	        this.answer = answer;
	    }

	    public String getAnswer() {
	        return answer;
	    }
	}

	interface IResult
	{
	    void showResult();
	    double showPercentage(int correctAnswers,int totalQuestions);
	    String showPerformance(double percentage);
	}

	class Result implements IResult
	{
	    int totalQuestions;
	    int correctAnswers;
	    int wrongAnswers;

	    public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
	        this.totalQuestions = totalQuestions;
	        this.correctAnswers = correctAnswers;
	        this.wrongAnswers = wrongAnswers;
	    }

	    @Override
	    public void showResult() {
	        System.out.println("Your results!");
	        System.out.println("Total Questions " + totalQuestions);
	        System.out.println("Number of correct answers " + correctAnswers);
	        System.out.println("Number of wrong answers " + wrongAnswers);
	        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
	        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));

	    }

	    @Override
	    public double showPercentage(int correctAnswers, int totalQuestions) {
	        //System.out.println(correctAnswers + " " + totalQuestions);
	        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
	    }

	    @Override
	    public String showPerformance(double percentage) {
	        String performance = "";

	        if(percentage > 60)
	        {
	            performance = "Good";
	        }
	        else if(percentage < 40)
	        {
	            performance = "Poor";
	        }

	        return performance;
		}

}
