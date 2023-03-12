public class MotorFlex extends Motor {
    int consumoGasolina;
    int consumoAlcool;
    public MotorFlex(TipoCombustivel tipoMotor, int consumoGasolina, int consumoAlcool) {
        this.tipoMotor = tipoMotor;
        this.consumoGasolina = consumoGasolina;
        this.consumoAlcool = consumoAlcool;
    }
    
    public int getConsumoGasolina(){
        return this.consumoGasolina;
    };
    public int getConsumoAlcool(){
        return this.consumoAlcool;
    }
    public int combustivelNecessarioGasolina(int distancia){
            return distancia/this.consumoGasolina;
    }

    public int combustivelNecessarioAlcool(int distancia){
        return distancia/this.consumoAlcool;
    }
}
