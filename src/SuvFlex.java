public class SuvFlex extends Carro{
    public SuvFlex(String modelo, TipoCombustivel tipoCombustivel, int consumoGasolina, 
                        int consumoAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new MotorFlex(tipoCombustivel, consumoGasolina, consumoAlcool);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }
    public int verificaSePodeViajar(int distancia) {
        MotorFlex motorFlex = (MotorFlex) motor;
        if(tanque.getTipoCombustivelCorrente()==TipoCombustivel.GASOLINA){
            int combustivelNecessario = motorFlex.combustivelNecessarioGasolina(distancia);
            if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
                return distancia;
            } else {
                return tanque.getCombustivelDisponivel() * motorFlex.getConsumoGasolina();
            }
        }else{
            int combustivelNecessario = motorFlex.combustivelNecessarioAlcool(distancia);
            if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
                return distancia;
            } else {
                return tanque.getCombustivelDisponivel() * motorFlex.getConsumoAlcool();
            }
        }
    }
    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia){
        MotorFlex motorFlex = (MotorFlex) motor;
        if(verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            if(tanque.getTipoCombustivelCorrente()==TipoCombustivel.GASOLINA){
                tanque.gasta(motorFlex.combustivelNecessarioGasolina(distancia));
                return true;
            }else{
                tanque.gasta(motorFlex.combustivelNecessarioAlcool(distancia));
                return true;
            }
        }
        return false;
    }
}
