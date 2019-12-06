package main;


import main.Utils.Converter;

import java.util.Set;

public class AnswerChecher {

    public static boolean check(String answer, Set<NumberSet> correctResult){
        Set<NumberSet> convertedAnswer = Converter.convertStringToNumberSets(answer);

        System.out.println("Сгенерированный правильный ответ: " + correctResult +" размер: "+correctResult.size() +"\nВведенные данные: " + convertedAnswer + "размер: " + convertedAnswer.size()+"\n");
        System.out.println("");

        return correctResult.containsAll(convertedAnswer)&&convertedAnswer.containsAll(correctResult);
    }



}
