public class TanqueMonoCombustivel extends TanqueCombustivel {

    private TipoCombustivel tipoCombustivel;
    protected int capacidade;
    protected int combustivelDisponivel;

    public TanqueMonoCombustivel(TipoCombustivel tipoCombustivel, int capacidade) {
        super(capacidade);
        this.tipoCombustivel = tipoCombustivel;
        this.combustivelDisponivel = 0;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        if (tipoCombustivel != this.tipoCombustivel) {
            return false;
        }

        if (getCombustivelDisponivel() + quantidade > getCapacidade()) {
            return false;
        } else {
            this.tipoCombustivel = tipoCombustivel;
            combustivelDisponivel += quantidade;
            return true;
        }
    }

    public boolean gasta(int quantidade) {
        if (getCombustivelDisponivel() - quantidade < 0) {
            return false;
        } else {
            combustivelDisponivel -= quantidade;
            return true;
        }
    }

    @Override
    public String toString() {
        return "TanqueCombustivel [capacidade=" + capacidade + ", combustivelDisponivel=" + combustivelDisponivel
                + ", tipoCombustivel=" + tipoCombustivel + "]";
    }

}
