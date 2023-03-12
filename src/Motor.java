public abstract class Motor {
    protected TipoCombustivel tipoMotor;
    protected int quilometragem;

    public TipoCombustivel getTipoMotor(){
        return this.tipoMotor;
    }
    
    public int getQuilometragem(){
        return this.quilometragem;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }
}