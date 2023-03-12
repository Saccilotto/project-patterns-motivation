import java.util.HashMap;

public class CarroFlex extends Carro{

    private TanqueFlexCombustivel tanque;
    private HashMap<TipoCombustivel, Integer> tiposEConsumos = new HashMap<>();

    public CarroFlex(String modelo, TipoCombustivel[] tiposCombustiveis, int[] consumos, int capacidadeTanque) {
        this.modelo = modelo;

        for (int indice = 0; indice < tiposCombustiveis.length; indice++){
            this.tiposEConsumos.put(tiposCombustiveis[indice], consumos[indice]);
        }

        motor = new MotorFlex(tiposCombustiveis, consumos);
        tanque = new TanqueFlexCombustivel(tiposCombustiveis, capacidadeTanque);
    }

    public int verificaSePodeViajar(int distancia) {
        MotorFlex motorFlex = (MotorFlex) motor;
        int combustivelNecessario;

        switch (tanque.getTipoCombustivelAtual()){
            case GASOLINA:
                combustivelNecessario = motorFlex.combustivelNecessarioGasolina(distancia);
                if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
                    return distancia;
                } else {
                    return tanque.getCombustivelDisponivel() * motorFlex.getConsumoGasolina();
                }
            case ALCOOL:
                combustivelNecessario = motorFlex.combustivelNecessarioAlcool(distancia);
                if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
                    return distancia;
                } else {
                    return tanque.getCombustivelDisponivel() * motorFlex.getConsumoAlcool();
                }
            default:
                return -1;
        }
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia){
        MotorFlex motorFlex = (MotorFlex) motor;

        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);

            switch (tanque.getTipoCombustivelAtual()) {
                case GASOLINA:
                    tanque.gasta(motorFlex.combustivelNecessarioGasolina(distancia));
                    return true;
                case ALCOOL:
                    tanque.gasta(motorFlex.combustivelNecessarioAlcool(distancia));
                    return true;
                default:
                    return false;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
