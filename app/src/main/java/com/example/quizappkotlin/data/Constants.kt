package com.example.quizappkotlin.data

object Constants {

    fun getQuestions(): ArrayList<QuestionModel>{
        val questionsList = ArrayList<QuestionModel>()

        val ques1 = QuestionModel(id = 1, question = "Constructors are used to"
            , answers =arrayListOf("To build a user interface",
                "Free Memory","Initialize new object","To create a sub-class")
            , correctAnswer = 2)
        val ques2 =QuestionModel(id = 2, question = "An object that has more than one form is referred to as"
        , answers = arrayListOf("Inheritance","Interface","Abstract class","Polymorphism")
        , correctAnswer = 3)
        val ques3 =QuestionModel(id = 3, question = "Information Hiding can also be termed as"
        , answers = arrayListOf("Data hiding","Encapsulation","Inheritance","Polymorphism")
        , correctAnswer = 1)
        val ques4 = QuestionModel(id = 4, question = "Pick the term that relates to polymorphism"
        , answers = arrayListOf("Data binding","Dynamic allocation","Static typing","Static allocation")
        , correctAnswer = 0)
        val ques5 = QuestionModel(id = 5, question = "The keyword which is used to access the method or member variables from the superclass"
        , answers = arrayListOf("Super","Using","Is_a","Has_a")
        , correctAnswer = 0)

        questionsList.add(ques1)
        questionsList.add(ques2)
        questionsList.add(ques3)
        questionsList.add(ques4)
        questionsList.add(ques5)
        return questionsList
    }
}