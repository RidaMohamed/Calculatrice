package controller;

import model.Calculette;
import view.ExampleView;
import view.View2_Historique;

public class CalculetteHistoriqueController {

    public View2_Historique CalculetteView ;
    public Calculette CalculetteModele ;

    public CalculetteHistoriqueController(View2_Historique calculetteView, Calculette calculetteModele) {
        this.CalculetteView = calculetteView;
        this.CalculetteModele = calculetteModele;
        this.CalculetteView.AddListener(this);

    }

    public void OnSymboleOperationClicked (int Digit , int opr) {
        this.CalculetteModele.calculer(Digit , opr);
    }

}
