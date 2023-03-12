public class CarroEcono extends CarroComum {
    
    private int kilometragem;
    private MotorComum motor;

    public CarroEcono(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, 
                    int capacidadeTanque){
        super(modelo, tipoCombustivel, consumoMotor, capacidadeTanque);
        this.kilometragem = 0;
    }

    @Override
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            this.tanque.gasta(motor.combustivelNecessario(distancia));

            this.kilometragem += distancia;
            if (kilometragem % 5000 > 0 && motor.getConsumo() > 10)
                this.motor.setConsumo(motor.getConsumo() - 1);

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
