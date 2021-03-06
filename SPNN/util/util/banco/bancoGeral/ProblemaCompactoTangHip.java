package util.banco.bancoGeral;

public class ProblemaCompactoTangHip extends TipoProblema {

	
	
	public ProblemaCompactoTangHip(int qtClasses) {
		super(qtClasses);
	}

	@Override
	public double[] geraSaida(int classe, int rodada) {
		
		if(qtClasses == 2){
			if(classe == 0){
				return new double[]{1};
			}
			else{
				return new double[]{-1};
			}
		}
		return null;
	}

	@Override
	public int getTamanhoSaida() {
		return 1;
	}
	
	@Override
	public int getQuantidadeSaidas() {
		return 2;
	}

	@Override
	public int getQuantidadeTotalRodadas() {
		return 1;
	}

	@Override
	public int geraTipoSaida(int classe, int rodada) {
		if(qtClasses == 2){
			if(classe == 0){
				return 0;
			}
			else{
				return 1;
			}
		}
		return -1;
	}
	
	public String toString(){
		return "Problema compacto 1 -1";
	}

	@Override
	public boolean getCrossEntropy() {
		return false;
	}

	@Override
	public int classifica(double[][] outputs) {
		if(getQuantidadeTotalRodadas() != outputs.length)
			return -1;
		
		if(outputs[0][0] >= 0)
			return 0;
		else
			return 1;
		
		
	}

}
