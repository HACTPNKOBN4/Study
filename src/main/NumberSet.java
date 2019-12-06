package main;

import java.util.Random;

public class NumberSet {
    private static final int MIN_VALUE = -10;
    private static final int MAX_VALUE = 10;

    private int x,y;
    private static Random r = new Random();

    private int hash = hashCode();

    public NumberSet(){
        //generate();
    }

    public NumberSet(int x,int y){
        this.x=Integer.min(x,y);
        this.y=Integer.max(x,y);
    }

    public int getMin() {
        return x;
    }

    public void setMin(int x) {
        this.x = x;
    }

    public int getMax() {
        return y;
    }

    public void setMax(int y) {
        this.y = y;
    }

    public void generate(){
        NumberSet result = new NumberSet();
        int x,y;
        x = r.nextInt(MAX_VALUE - MIN_VALUE)+ MIN_VALUE;
        do {
            y = r.nextInt(MAX_VALUE - MIN_VALUE)+ MIN_VALUE;
        }
        while (x==y);
        this.x = Integer.min(x,y);
        this.y = Integer.max(x,y);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    @Override
    public boolean equals(Object object) {
        if(object.getClass() == NumberSet.class){
            NumberSet comparingObject = (NumberSet)object;
            if(comparingObject.x==x&&comparingObject.y==y){
                return true;
            }
        }
      return super.equals(object);
    }

    @Override
    public int hashCode() {
        return x*353+y*(-1234);
    }
}
