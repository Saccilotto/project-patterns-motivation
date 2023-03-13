public abstract class Motor {
    protected int quilometragem;

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }
    
    @Override
    public String toString() {
        return "Motor:\n  quilometragem=" + quilometragem;
    }
}