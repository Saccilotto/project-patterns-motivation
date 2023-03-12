public class CarroComum extends Carro {
    
    private TanqueMonoCombustivel tanque;

    public CarroComum(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, 
                        int capacidadeTanque) {
        this.modelo = modelo;
        motor = new MotorComum(tipoCombustivel, consumoMotor);
        tanque = new TanqueMonoCombustivel(tipoCombustivel, capacidadeTanque);
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
