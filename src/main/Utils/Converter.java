package main.Utils;

import main.NumberSet;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Converter {
    public static Set<NumberSet> convertStringToNumberSets(String answer) {

        Set<String> diapasonsAsStrings = separateIntoDiapasons(answer);    //Разбиваем строку ответа на группы диапазонов

        Set<NumberSet> result = new HashSet<>();
        for (String s : diapasonsAsStrings) {
            if(!s.equals("")) result.add(diapasonToNumberSet(s));     //Каждый диапазон мы конвертируем в NumberSet и складываем в сет.
        }
        return result;
    }

    private static Set<String> separateIntoDiapasons(String answer) {
        char[] chars = answer.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<String> diapasons = new HashSet<>();
        //stage 1 - поиск "(" или конца строки. Если попалась ")" - выдаём ошибку.
        //stage 2 - добавляем все символы в StringBuilder, пока не найдём ")". Если попалась "(" - выдаём ошибку. Если нашли ")" - добавляем всё что в стрингбилбере в сет и переходим в stage 1.
        int stage = 1;

        for (int i = 0; i < chars.length; i++) {
            //stage 1
            if (stage == 1) {
                if (chars[i] == '(') {
                    stage = 2;
                    continue;
                }
                if (chars[i] == ')') {
                    ErrorAlarm(1);
                    break;
                }
            }
            //stage 2
            if (stage == 2) {
                if (chars[i] == '(') {
                    ErrorAlarm(2);
                    break;
                }
                if (chars[i] == ')') {
                    diapasons.add(sb.toString());
                    sb.delete(0, sb.length());
                    stage = 1;
                } else {
                    sb.append(chars[i]);
                }
            }

        }
        if (stage == 2) {
            ErrorAlarm(3);
            return null;
        }
        return diapasons;
    }

    private static NumberSet diapasonToNumberSet(String s) {
        NumberSet result = new NumberSet();

        if (s.matches("-?\\d+(,|;)-?\\d+")) {
            String[] flag = s.split(",|;");
            result = new NumberSet(Integer.parseInt(flag[0]), Integer.parseInt(flag[1]));
        }
        else if (s.matches("-?\\d+")) {
            result = new NumberSet(Integer.parseInt(s), Integer.parseInt(s));
        }
        else ErrorAlarm(6);
        return result;
    }

    private static void ErrorAlarm(int i) {
        JOptionPane.showMessageDialog(null, "Неверно введены данные! " + i, "Ошибка", 1);
    }

    public static void main(String[] args) {
        Set<NumberSet> set1 = new HashSet<>();
        Set<NumberSet> set2 = new HashSet<>();

        System.out.println("Создание Первого NumberSet:");
        set1.add(new NumberSet(1,2));
        System.out.println("Создание Второго NumberSet:");
        set2.add(new NumberSet(1,2));
        System.out.println(set1.containsAll(set2));
    }
}
