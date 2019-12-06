package main;

import java.util.Set;

public class MathLogic {
    private static NumberSet set1 = new NumberSet();
    private static NumberSet set2 = new NumberSet();
    private static Operation operation = Operation.generate();

    private static Set<NumberSet> result;

    public static void generateNewExercise(){
        set1.generate();
        set2.generate();
        operation = Operation.generate();
        result = Operation.caculateResult(set1,set2,operation);

        /////////////////////////////
        System.out.println("("+set1.getMin()+","+set1.getMax()+")");
        System.out.println("("+set2.getMin()+","+set2.getMax()+")");
        System.out.println(getOperation());
        for (NumberSet n: result){
            System.out.print("("+n.getMin()+","+n.getMax()+") ");
        }
        //////////////////////////////////
    }


    public static Operation getOperation() {
        return operation;
    }

    public static NumberSet getSet1() {return set1;}

    public static NumberSet getSet2() {return set2;}

    public static Set<NumberSet> getResult(){
        return result;
    }
}
