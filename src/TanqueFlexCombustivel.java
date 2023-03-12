public class TanqueFlexCombustivel extends TanqueCombustivel {
    
    private TipoCombustivel[] tiposCombustiveis;
    private TipoCombustivel tipoCombustivelAtual;

    public TanqueFlexCombustivel(TipoCombustivel[] tiposCombustivels, int capacidade) {
        super(capacidade);
        this.tipoCombustivelAtual = tiposCombustiveis[0];
        this.combustivelDisponivel = 0;
    }

    public TipoCombustivel[] getTiposCombustiveis() {
        return tiposCombustiveis;
    }

    public TipoCombustivel getTipoCombustivelAtual() {
        return tipoCombustivelAtual;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        if (!verificarSeCombustivelAceito(tipoCombustivel)) {
            return false;
        }

        if (getCombustivelDisponivel() + quantidade > getCapacidade()) {
            return false;
        } else {
            this.tipoCombustivelAtual = tipoCombustivel;
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

    public boolean verificarSeCombustivelAceito(TipoCombustivel tipoEmTeste) {
        for (TipoCombustivel tipo: tiposCombustiveis)
            if (tipoEmTeste == tipo) return true;
        return false;
    }

    @Override
    public String toString() {
        String saida = "TanqueFlexCombustivel [capacidade=" + capacidade + ", combustivelDisponivel=" + combustivelDisponivel
                + ", tiposCombustiveis=";
        for (int indice = 0; indice < tiposCombustiveis.length - 1; indice++)
            saida += tiposCombustiveis[indice] + ", ";
        saida += tiposCombustiveis[tiposCombustiveis.length - 1];
        saida += "] ]";
        return  saida;
    }
    
}
