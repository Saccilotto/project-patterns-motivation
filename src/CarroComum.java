public class CarroComum extends Carro {
    
    public CarroComum(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, 
                        int capacidadeTanque) {
        this.modelo = modelo;
        motor = new MotorComum(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }
    public int verificaSePodeViajar(int distancia) {
        MotorComum motorComum = (MotorComum) motor;
        int combustivelNecessario = motorComum.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motorComum.getConsumo();
        }
    }
    public boolean viaja(int distancia) {
        MotorComum motorComum = (MotorComum) motor;
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motorComum.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }
}
