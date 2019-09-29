package model;

import model.operation.Addition;
import model.operation.Soustraction;

import javax.management.OperationsException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import static view.ExampleView.*;

public class Calculette extends Observable {
    // -----
    private int Resultat ;
    private int opr;
    private int opr2;
    private int operation;
    private String Expression ;
    private int operationEnCours = 0 ;

    // -----
    private ArrayList<Observer> viewArrayList;

    // -----
    public Calculette() {
        this.Resultat = 0;
        this.opr = 0;
        this.opr2 = 0;
    }

    public void calculer (int digit , int num){
        if (digit == EQUAL){
            setOpr2(num);
            switch (getOperation()){
                case PLUS :
                    Addition operationAddition = new Addition();
                    operationAddition.setExp1(this.opr);
                    operationAddition.setExp2(this.opr2);
                    operationAddition.CalculerSomme();
                    this.Resultat = operationAddition.getSum();
                    break;
                case MINUS :
                    Soustraction operationSoustraction  = new Soustraction();
                    operationSoustraction.setExp1(this.opr);
                    operationSoustraction.setExp2(this.opr2);
                    operationSoustraction.CalculerSoustraction();
                    this.Resultat = operationSoustraction.getSoustraction();
                    break;
            }
            System.out.println(Expression);
            Expression = Expression + " " + num + " = " + this.Resultat;
            System.out.println(Expression);
            setChanged();
            notifyObservers();
        }else
        {
            if (operationEnCours == 0){
                setOpr(num);
                setOperation(digit);
                if (digit==PLUS)
                Expression = String.valueOf(num) +" + ";
                else
                    Expression = String.valueOf(num) +" - ";
            }else {
                setOpr2(num);
                switch (getOperation()){
                    case PLUS :
                        Addition operationAddition = new Addition();
                        operationAddition.setExp1(this.opr);
                        operationAddition.setExp2(this.opr2);
                        operationAddition.CalculerSomme();
                        this.Resultat = operationAddition.getSum();
                        setOpr(this.Resultat);
                        setOperation(digit);
                        Expression.concat(" " + num + " = " + this.Resultat);
                        setChanged();
                        notifyObservers();
                        break;
                    case MINUS :
                        Soustraction operationSoustraction  = new Soustraction();
                        operationSoustraction.setExp1(this.opr);
                        operationSoustraction.setExp2(this.opr2);
                        operationSoustraction.CalculerSoustraction();
                        this.Resultat = operationSoustraction.getSoustraction();
                        setOpr(this.Resultat);
                        setOperation(digit);
                        Expression.concat(" " + num + " = " + this.Resultat);
                        setChanged();
                        notifyObservers();
                        break;
                }
            }

        }

    }

    public void setOpr(int opr) {
        this.opr = opr;
    }

    public void setOpr2(int opr2) {
        this.opr2 = opr2;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    public int getResultat() {
        return Resultat;
    }

    public void setResultat(int resultat) {
        Resultat = resultat;
    }

    public String getExpression() {
        return Expression;
    }
}