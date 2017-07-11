package configs;
import rede.SPNNPesosConfig;
import util.banco.bancoGeral.TipoProblema;
import util.otimizacao.io.Config;
import util.redeneural.base.FuncaoAtivacao;


public class SPNNConfig extends Config{

	private int[] qtNeuroniosPorCamada;
	private int qtInicialPontos;
	private boolean quadInscrito;
	private FuncaoAtivacao funcaoUltimaCamada;
	private FuncaoAtivacao funcaoDemaisCamadas;
	private TipoProblema tipoProblema;
	private SPNNPesosConfig pesosConfig;
	private int randPesos, randEstrutura;
	private boolean normaliza;
	private int qtRedesComite;

	private boolean camadaSaida, crossEntropy;

	boolean ativaInibicaoLateral,normalizaSaidaInibitoria;
	double pesoInibitorio,raioInibitorio;
	
	
	public SPNNConfig(String fileTeste, String file, boolean ehTeste, int qtInicialPontos,int[] qtNeuroniosPorCamada,
			boolean quadInscrito,FuncaoAtivacao funcaoUltimaCamada, FuncaoAtivacao funcaoDemaisCamadas,
			TipoProblema tipoProblema, SPNNPesosConfig pesosConfig, int randPesos, int randEstrutura, boolean normaliza,
			int qtRedesComite, boolean camadaSaida, boolean crossEntropy, 
			boolean ativaInibicaoLateral, boolean normalizaSaidaInibitoria, double pesoInibitorio, double raioInibitorio) {
		super(fileTeste, file, ehTeste);
		this.qtNeuroniosPorCamada = qtNeuroniosPorCamada;
		this.qtInicialPontos = qtInicialPontos;
		this.quadInscrito = quadInscrito;
		this.funcaoUltimaCamada = funcaoUltimaCamada;
		this.funcaoDemaisCamadas = funcaoDemaisCamadas;
		this.tipoProblema = tipoProblema;
		this.pesosConfig = pesosConfig;
		this.randPesos = randPesos;
		this.randEstrutura = randEstrutura;
		this.normaliza = normaliza;
		this.qtRedesComite = qtRedesComite;
		this.camadaSaida = camadaSaida;
		this.crossEntropy = crossEntropy;

		this.ativaInibicaoLateral = ativaInibicaoLateral;
		this.normalizaSaidaInibitoria = normalizaSaidaInibitoria;
		this.pesoInibitorio = pesoInibitorio;
		this.raioInibitorio = raioInibitorio;
	}


	@Override
	public String toStringConfig() {
		String separador = "\r\n";
		
		String retorno = "SPNN"+separador+"======= CONFIGURA��ES DA OTIMIZA��O ========" +separador;
		
		retorno += "quantidadeSimulacoes="+Constantes.OTIMIZACAO_QUANTIDADE_SIMULACOES + separador;
	
		retorno += "Base=" + Constantes.BANCO;
		
		retorno += " (Treino = "+toString(Constantes.treino)+", Valida��o = "+toString(Constantes.validacao)+", Teste = "+toString(Constantes.teste)+")"+separador;
		
		retorno += "Split Treino = "+Constantes.splitTreino+" , SplitTeste = "+Constantes.splitTeste+separador;

		retorno += "Quantidade de imagens treino por �poca = "+ Constantes.qtImagensTreinoPorEpoca + separador;
		
		retorno += "Normaliza��o=" + Constantes.NORMALIZACAO_IMAGEM_INICIO + " - " +Constantes.NORMALIZACAO_IMAGEM_FIM + separador;
		
		retorno += "TipoProblema=" + this.tipoProblema + separador;
		
		retorno += "Qt redes Comit�="+this.qtRedesComite + separador;
		
		retorno += "======= CONFIGURA��ES DA REDE NEURAL ========"+separador;
		
		retorno += "qtInicialPontos=" + qtInicialPontos + separador;
		
		if(camadaSaida){
			
			int[] vetor = new int[qtNeuroniosPorCamada.length+1];
			for (int i = 0; i < vetor.length-1; i++) {
				vetor[i] = qtNeuroniosPorCamada[i];
			}
			vetor[vetor.length-1] = 2;			
			
			retorno += "qtd neur�nios por camada=" + toString(vetor) + separador;
		}else{
			retorno += "qtd neur�nios por camada=" + toString(qtNeuroniosPorCamada) + separador;
		}
		
		retorno += "ativa inibi��o lateral=" + ativaInibicaoLateral +  separador;
		
		if(ativaInibicaoLateral){
			retorno += "normaliza inibi��o lateral="+normalizaSaidaInibitoria + separador;
			retorno += "peso inibit�rio="+pesoInibitorio + separador;
			retorno += "raio inibit�rio="+raioInibitorio + separador;
		}
		
		retorno += "cross entropy=" + crossEntropy + separador; 
				
		retorno += "quadrado inscrito = "+ this.quadInscrito + separador;
		
		retorno += "fun��o de Ativa��o Ultima Camada=" + this.funcaoUltimaCamada + separador;
		
		retorno += "fun��o de Ativa��o Demais Camadas=" + this.funcaoDemaisCamadas + separador;
		
		retorno += "Quantidade de �pocas=" + Constantes.QUANTIDADE_EPOCAS + separador;
		
		retorno += "Inicializa��o de Pesos = \n" + this.pesosConfig.toString() + separador;
		
		retorno += "RandPesos=" +this.randPesos + separador;
		
		retorno += "RandEstrutura (kmeans e gerador)=" +this.randEstrutura + separador;
		
		retorno += "Normaliza Sa�da Campo Receptivo ="+this.normaliza + separador;
		
		return retorno;
	}

	public String toString(int vetor){
		return toString(new int[]{vetor});
	}
	
	public String toString(int[] vetor){
		String s = null;
		if(vetor != null)
		{
			s = "[";
			for (int i : vetor) {
				s += i+" ";
			}
			s += "]";
		}
		return s;
	}
	
	
	
}
