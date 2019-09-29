import controller.CalculetteController;
import controller.CalculetteHistoriqueController;
import model.Calculette;
import view.ExampleView;
import view.View2_Historique;

public class Main {

    public static void main(String[] args){

        ExampleView CalculetteView = new ExampleView();
        View2_Historique CalculetteView2 = new View2_Historique();
        Calculette calculette = new Calculette();
        CalculetteController calculetteController = new CalculetteController(CalculetteView , calculette);
        CalculetteHistoriqueController calculetteHistoriqueController =
                new CalculetteHistoriqueController(CalculetteView2 , calculette);
        calculette.addObserver(CalculetteView);
        calculette.addObserver(CalculetteView2);
//        calculette.calculer();
    }
}