package main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public enum Operation {
    INTERSECTION,
    UNION,
    DIFFERENCE,
    SIMETRICAL_DIFFERENCE;

    private static Random random = new Random();

    public static Operation generate(){
       // random = new Random();
        return Operation.values()[random.nextInt(Operation.values().length)];
    }

    public static Set<NumberSet> caculateResult(NumberSet n1, NumberSet n2, Operation operation){

        Set<NumberSet> result=new HashSet<NumberSet>();

        switch (operation){
            case UNION:
                result=union(n1, n2);
                break;
            case INTERSECTION:
                result=intersection(n1, n2);
                break;
            case DIFFERENCE:
                result=difference(n1, n2);
                break;
            case SIMETRICAL_DIFFERENCE:
                result=simetricalDifference(n1, n2);
                break;
        }
        return result;
    }

    //Метод Объединение
    private static Set<NumberSet> union(NumberSet n1, NumberSet n2){
        Set<NumberSet> result = new HashSet<NumberSet>();
        if( (n1.getMax()<n2.getMin()) || (n1.getMin()>n2.getMax()) ){
            result.add(n1);
            result.add(n2);
            return result;
        }
        else {
            int min = Integer.min(n1.getMin(),n2.getMin());
            int max = Integer.max(n1.getMax(),n2.getMax());
            result.add(new NumberSet(min,max));
            return result;
        }
    }

    //Метод Пересечение
    private static Set<NumberSet> intersection(NumberSet n1, NumberSet n2){
        Set<NumberSet> result = new HashSet<NumberSet>();
        int leftSide,rightSide;
        leftSide = Integer.max(n1.getMin(),n2.getMin());
        rightSide = Integer.min(n1.getMax(),n2.getMax());
        if (leftSide>rightSide) return result;
        else {
            result.add(new NumberSet(leftSide,rightSide));
            return result;
        }
    }

    //Метод Разность
    private static Set<NumberSet> difference(NumberSet n1, NumberSet n2){
        Set<NumberSet> result = new HashSet<NumberSet>();
        //множества не пересекаются
        if( (n1.getMax()<n2.getMin()) || (n1.getMin()>n2.getMax()) ){
            result.add(n1);
            return result;
        }
        //вычитаемое множество содержит уменьшаемое
        if( (n1.getMin()>=n2.getMin())&& (n1.getMax()<=n2.getMax()) ){
            return result;
        }
        //уменьшаемое множество содержит вычитаемое
        if ( (n1.getMin()<n2.getMin()) && (n1.getMax()>n2.getMax()) ){
            NumberSet left = new NumberSet(n1.getMin(),n2.getMin()-1);
            NumberSet right = new NumberSet(n2.getMax()+1,n1.getMax());
            result.add(left);
            result.add(right);
            return result;
        }
        if(n1.getMin()<n2.getMin()){
            result.add(new NumberSet(n1.getMin(),n2.getMin()-1));
            return result;
        }
        else{
            result.add(new NumberSet(n2.getMax()+1,n1.getMax()));
            return result;
        }
    }

    //Метод Симетричная разность
    private static Set<NumberSet> simetricalDifference(NumberSet n1, NumberSet n2) {
        Set<NumberSet> result = new HashSet<NumberSet>();
        if((n1.getMin()==n2.getMax()-1)|| (n1.getMax()==n2.getMin()+1) ){
            result.add(new NumberSet(Integer.min(n1.getMin(),n2.getMin()),Integer.max(n1.getMax(),n2.getMax())));
            return result;
        }
        result = difference(n1, n2);
        result.addAll(difference(n2,n1));
        return result;
    }
}
