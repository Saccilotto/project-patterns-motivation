public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new CarroComum("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new CarroComum("Esportivo", TipoCombustivel.GASOLINA, 6, 45); 
        Carro utilitario = new CarroComum("Utilitario", TipoCombustivel.DIESEL, 5, 55); 
        Carro suv = new CarroComum("SUV", TipoCombustivel.FLEX, 8, 70);    
        Carro suvFlex = new SuvFlex("SuvFlex", TipoCombustivel.FLEX, 8, 0, 65);


        System.out.println("Tipos de veiculos:");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);
        System.out.println(suv);
        System.out.println(suvFlex);


        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);


        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SuvFlex com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro basico");
        suvFlex.viaja(250);
        suvFlex.viaja(150);
        System.out.println(suvFlex);
    }
}
