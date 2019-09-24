import controller.CalculetteController;
import model.Calculette;
import view.ExampleView;

public class Main {

    public static void main(String[] args){

        ExampleView CalculetteView = new ExampleView();
        Calculette calculette = new Calculette();
        CalculetteController calculetteController = new CalculetteController(CalculetteView , calculette);
//        calculette.calculer();
    }
}