import java.util.HashMap;

public class MotorFlex extends Motor {
    private HashMap<TipoCombustivel, Integer> tiposEConsumos = new HashMap<>();

    public MotorFlex(TipoCombustivel[] tiposCombustiveis, int[] consumos) {
        for (int indice = 0; indice < tiposCombustiveis.length; indice++)
            this.tiposEConsumos.put(tiposCombustiveis[indice], consumos[indice]);
    }
    
    public int getConsumoGasolina(){
        return tiposEConsumos.get(TipoCombustivel.GASOLINA);
    }

    public int getConsumoAlcool(){
        return tiposEConsumos.get(TipoCombustivel.ALCOOL);
    }

    public int combustivelNecessarioGasolina(int distancia){
            return distancia / getConsumoGasolina();
    }

    public int combustivelNecessarioAlcool(int distancia){
        return distancia / getConsumoAlcool();
    }
}
