public class MotorComum extends Motor{
    public int consumo;
    public MotorComum(TipoCombustivel tipoMotor, int consumo){
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }
    public int getConsumo() {
        return this.consumo;
    }
    public int combustivelNecessario(int distancia) {
        return distancia / consumo;
    }
}
