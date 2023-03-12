public class App {
    public static void main(String[] args) throws Exception {

        CarroComum basico = new CarroComum("Basico", TipoCombustivel.GASOLINA, 10, 55);
        CarroComum esportivo = new CarroComum("Esportivo", TipoCombustivel.GASOLINA, 6, 45); 
        CarroComum utilitario = new CarroComum("Utilitario", TipoCombustivel.DIESEL, 5, 55); 
        CarroFlex suv = new CarroFlex("SUV", new TipoCombustivel[] { TipoCombustivel.GASOLINA }, new int[] { 8 }, 70);    
        CarroFlex suvFlex = new CarroFlex("SuvFlex", new TipoCombustivel[] { TipoCombustivel.GASOLINA, TipoCombustivel.ALCOOL }, new int[] { 8, 6 }, 65);
        CarroEcono econo = new CarroEcono("Econo", TipoCombustivel.GASOLINA, 20, 55);

        System.out.println("Tipos de veículos:");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);
        System.out.println(suv);
        System.out.println(suvFlex);


        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro básico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro básico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);


        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SuvFlex com gasolina");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro SuvFlex com gasolina");
        suvFlex.viaja(250);
        suvFlex.viaja(150);
        System.out.println(suvFlex);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastecendo carro econo");
        econo.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(econo);
        System.out.println("\nViajando com o carro econo");
        econo.viaja(250);
        System.out.println(econo);
        econo.viaja(150);
        System.out.println(econo);
    }
}
