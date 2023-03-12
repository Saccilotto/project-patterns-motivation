public class MotorComum extends Motor{
    private TipoCombustivel tipoCombustivel;
    private int consumo;

    public MotorComum(TipoCombustivel tipoCombustivel, int consumo){
        this.tipoCombustivel = tipoCombustivel;
        this.consumo = consumo;
    }
    public int getConsumo() {
        return this.consumo;
    }
    public int combustivelNecessario(int distancia) {
        return distancia / consumo;
    }
}
