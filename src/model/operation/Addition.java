package model.operation;

public class Addition {

    private int exp1 ;
    private int exp2 ;
    private int sum ;

    public Addition() {
        this.exp1 = 0;
        this.exp2 = 0;
        this.sum = 0;
    }

    public void CalculerSomme (){
        this.sum = this.exp1 + this.exp2;
    }

    public int getExp1() {
        return exp1;
    }

    public void setExp1(int exp1) {
        this.exp1 = exp1;
    }

    public int getExp2() {
        return exp2;
    }

    public void setExp2(int exp2) {
        this.exp2 = exp2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}