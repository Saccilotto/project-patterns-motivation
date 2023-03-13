public abstract class Carro {

    protected String modelo;
    protected Motor motor;
    protected TanqueCombustivel tanque;

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    public abstract int verificaSePodeViajar(int distancia);

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        tanque.abastece(tipoCombustivel, capacidadeLivre);
           return capacidadeLivre;
    }
    
    // Retorna true se conseguiu viajar
    public abstract boolean viaja(int distancia);

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
