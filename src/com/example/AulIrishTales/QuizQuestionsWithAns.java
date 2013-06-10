package com.example.AulIrishTales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Zara
 * Date: 18/03/2013
 * Time: 19:34
 *
 * CREATED BY ZARA
 */
public class QuizQuestionsWithAns
{
    protected List<String> allAnswers;
    protected String answer;
    protected String question;
    protected String selectedAnswer;
    protected int selectedId = -1;

    public QuizQuestionsWithAns(String question, String answer, List<String> wrongAnswers)
    {
        this.question = question;
        this.answer = answer;
        allAnswers = new ArrayList<String>(wrongAnswers);

        // Add real answer to false answers and shuffle them around
        allAnswers.add(answer);
        Collections.shuffle(allAnswers);
    }//questionAndAnswer

}//class

