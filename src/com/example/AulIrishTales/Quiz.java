package com.example.AulIrishTales;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//CREATED BY ZARA


public class Quiz extends Activity implements OnClickListener
{
    private RadioGroup answerRadioGroup;
    private Button submitButton;
    private TextView questionTextView,scoreTextView,remainingQuestionTextView, correctOrIncorrectTextView;
    private boolean correct = false;
    private int totalGuesses =1;
    private int currentQuestion = 1;
    private int score = 0;
    private double percentage=0;

    private List<QuizQuestionsWithAns> quiz = new ArrayList<QuizQuestionsWithAns>();

    //setting up the questions, correct answers and false answers.
    private String[] question = {"What did the faries steal?",
            "What was wrong with the fairy babies?",
            "What was St Patrick real name?",
            "At what age was St Patrick Kidnapped?",
            "What did the Banshee do when people saw her?",
            "What omen did the Banshee carry with her?",
            "What do leprechauns usually take the form of?",
            "What happens when your gaze is taken off a leprechaun?"};

    private String [] answer = {"Babies", "Deformed",  "Maewyn", "16", "let out a cry", "Death",
            "Old Men", "He Vanishes"};

    private String[] wrongAnswer = {"Cats","Dogs","Birds","Fish", "Evil", "Hated", "Unwanted", "Sick",
            "Cats","Dogs","Birds","Fish","Cats","Dogs","Birds","Fish","Cats","Dogs","Birds","Fish","Cats","Dogs","Birds","Fish",
            "Cats","Dogs","Birds","Fish","Cats","Dogs","Birds","Fish"};

    //creating an array list using the false answer array
    private List<String> falseList = Arrays.asList(wrongAnswer);

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        //adding the question and score text view and answer radio group which is displayed on the main page
        questionTextView = (TextView) findViewById(R.id.quizQuestions);
        answerRadioGroup = (RadioGroup) findViewById(R.id.answersGroup);
        submitButton = (Button) findViewById(R.id.bSubmit);
        scoreTextView = (TextView) findViewById(R.id.totalScore);
        remainingQuestionTextView = (TextView) findViewById(R.id.remainingQuesiontextView);
        correctOrIncorrectTextView = (TextView) findViewById(R.id.correctincorrecttextView);

        //setting a listener to the submit button to obtain result and move to next question
        submitButton.setOnClickListener(this);


        remainingQuestionTextView.setText(
                getResources().getString(R.string.question) + " 1 " +
                        getResources().getString(R.string.of) + " 8");


        getQuestion();

    }//onCreate



    public void getQuestion()
    {

        answerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId > -1)
                {
                    QuizQuestionsWithAns questionsWithAns = quiz.get(currentQuestion);
                    questionsWithAns.selectedAnswer = ((RadioButton) group.findViewById(checkedId)).getText().toString();
                    questionsWithAns.selectedId = checkedId;


                    //check to see if the selected answer by the user is the same as the correct.
                    correct = questionsWithAns.selectedAnswer.equals(questionsWithAns.answer);
                }//if
            }//onCheckedChanged
        });

        //getting the length of the question array
        int length = question.length;

        //while i is less than the length of the question array then
        for(int count = 0; count < length; count++)
        {
            quiz.add(new QuizQuestionsWithAns(question[count], answer[count], falseList.subList(count * 3, (count + 1) * 3)));
        }//for

        //
        QuizQuestionsWithAns questionWithAnswers = quiz.get(currentQuestion);

        //setting the text view to display the question
        questionTextView.setText(questionWithAnswers.question);

        // set all of the answers in the RadioButtons
        int count = answerRadioGroup.getChildCount();

        for(int times = 0; times < count; times++)
        {
            ((RadioButton) answerRadioGroup.getChildAt(times)).setText(questionWithAnswers.allAnswers.get(times));
        }//for

        // Restore selected answer if exists otherwise clear previous question's choice
        if(questionWithAnswers.selectedId > -1)
        {
            answerRadioGroup.check(questionWithAnswers.selectedId);
        }//if

        else
        {
            answerRadioGroup.clearCheck();
        }//else

    }//fillInQuestion


    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.bSubmit:
            {
                //++ the number of guesses taken
                totalGuesses++;

                remainingQuestionTextView.setText(
                        getResources().getString(R.string.question) + " " +
                                (totalGuesses) + " " +
                                getResources().getString(R.string.of) + " 8");

                if(correct)
                {
                    //incrementing the score
                    score++;

                    percentage++;

                    //display "Correct!" in green text
                    correctOrIncorrectTextView.setText(R.string.correct);
                    correctOrIncorrectTextView.setTextColor(
                            getResources().getColor(R.color.correct_answer));

                }//if

                else //answer is not correct
                {
                    //animation?

                    //display "incorrect!" in red
                    correctOrIncorrectTextView.setText(R.string.incorrect);
                    correctOrIncorrectTextView.setTextColor(
                            getResources().getColor(R.color.incorrect_answer));

                }//else

                //when the correct answer reaches a certain point end
                if (totalGuesses==9)
                {
                    //create an alert dialog builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setTitle(R.string.finished_quiz); //title bar

                    //setting the alert dialog to display message and result
                    builder.setMessage(getResources().getString(R.string.correct)+ " "+ (percentage/8*100) + "%"
                            + "\n" +getResources().getString(R.string.score)+ " " + (score));

                    //so that it cannot be x out of
                    builder.setCancelable(false);


                    //adding the go to main menu button
                    builder.setPositiveButton(R.string.main_menu,
                            new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    //setting it so it goes to the main menu again
                                    Intent goToMainMenu = new Intent(Quiz.this, MainMenu.class);
                                    startActivity(goToMainMenu);
                                }//onclick
                            }//anonymous inner class
                    );//setPositiveButton

                    //restart quiz button
                    builder.setNegativeButton(R.string.restart_quiz,
                            new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    Intent restartQuiz = new Intent(Quiz.this, Quiz.class);
                                    startActivity(restartQuiz);
                                }//onclick
                            }//anonymous inner class
                    );//setNegativeButton

                    //exit button
                    builder.setNeutralButton(R.string.exit,
                            new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    Intent exitapp = new Intent(Quiz.this, CreditPage.class);
                                    startActivity(exitapp);
                                }//onClick
                            }//Anonymous inner class
                    );//setNegativeButton

                    //create AlertDialog from the builder
                    AlertDialog alertdialog = builder.create();

                    //display the dialog
                    alertdialog.show();
                }//if
                scoreTextView.setText("Score: "+ score);

                //DO I NEED THIS HERE
                currentQuestion++;

                //Clearing the buttons
                answerRadioGroup.clearCheck();

                //calling methods
                getQuestion();
            }//case
            break;

        }//switch
    }//onClick

}//class