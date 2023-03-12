public abstract class TanqueCombustivel {

    protected int capacidade;
    protected int combustivelDisponivel;

    public TanqueCombustivel(int capacidade) {
        this.capacidade = capacidade;
        this.combustivelDisponivel = 0;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    public abstract boolean abastece(TipoCombustivel tipoCombustivel, int quantidade);

    public boolean gasta(int quantidade) {
        if (getCombustivelDisponivel() - quantidade < 0) {
            return false;
        } else {
            combustivelDisponivel -= quantidade;
            return true;
        }
    }

}
