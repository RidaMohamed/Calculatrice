package controller;

import model.Calculette;
import view.ExampleView;

import java.util.Observable;
import java.util.Observer;

public class CalculetteController {

    public ExampleView CalculetteView ;
    public Calculette CalculetteModele ;

    public CalculetteController(ExampleView calculetteView, Calculette calculetteModele) {
        this.CalculetteView = calculetteView;
        this.CalculetteModele = calculetteModele;
        this.CalculetteView.AddListener(this);

    }

    public int OnSymboleOperationClicked (int Digit , int opr) {
        return this.CalculetteModele.calculer(Digit , opr);
    }

}
