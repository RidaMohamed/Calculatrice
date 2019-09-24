package model;

import model.operation.Addition;
import model.operation.Soustraction;

import javax.management.OperationsException;
import java.util.Scanner;

import static view.ExampleView.*;

public class Calculette {
    private int Resultat ;
    private int ChosenOperation;

    public Calculette() {
        this.Resultat = 0;
        this.ChosenOperation = 0;
    }

    public int calculer (int digit , int num){
        int OperationOuNonOperation = 0;
        String typed ;
        int exp1 = 0;
        int exp2;


         //   Scanner sc = new Scanner(System.in);
//            typed = sc.nextLine();
                switch (digit) {
                    case PLUS :
                        this.Resultat = num;
                        exp1 = this.Resultat;
                        this.ChosenOperation = 1;
//                        Addition OperationAddition = new Addition();
//                        OperationAddition.setExp1(exp1);
//                        typed = sc.nextLine();
//                        exp2 = Integer.parseInt(typed);
//                        OperationAddition.setExp2(Integer.parseInt(typed));
//                        OperationAddition.CalculerSomme();
//                        this.Resultat = OperationAddition.getSum();
//                        System.out.println(exp1 + "+" + exp2 + " = " + OperationAddition.getSum());
//                        System.out.println("Si vous voulez mettre fin a la calculatrice tapez 1 \n" +
//                                "sinon tapez n'importe quel num");
                       // OperationOuNonOperation = sc.nextInt();

                        break;
                    case MINUS :
                        this.Resultat = num;
                        exp1 = this.Resultat;
                        this.ChosenOperation = -1 ;
//                        Soustraction OperationSoustraction = new Soustraction();
//                        OperationSoustraction.setExp1(exp1);
//                        typed = sc.nextLine();
//                        exp2 = Integer.parseInt(typed);
//                        OperationSoustraction.setExp2(Integer.parseInt(typed));
//                        OperationSoustraction.CalculerSoustraction();
//                        this.Resultat = OperationSoustraction.getSoustraction();
//                        System.out.println(exp1 + "-" + exp2 + " = " + OperationSoustraction.getSoustraction());
//                        System.out.println("Si vous voulez mettre fin a la calculatrice tapez 1 \n" +
//                                "sinon tapez n'importe quel num");
                        //OperationOuNonOperation = sc.nextInt();
                        break;
                    case EQUAL :
                        if (this.ChosenOperation == 1){
                            exp2 = num;
                            Addition OperationAddition = new Addition();
                            OperationAddition.setExp1(exp1);
                            OperationAddition.setExp2(exp2);
                            OperationAddition.CalculerSomme();
                            this.Resultat = OperationAddition.getSum();
                            return this.Resultat;
                        }
                        break;

                }


//        System.out.println("Au revoir !!");

        return Integer.MIN_VALUE;
    }

    public int getResultat() {
        return Resultat;
    }

    public void setResultat(int resultat) {
        this.Resultat = resultat;
    }
}