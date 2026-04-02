package dados_controladores;

public class Estatisticas_Config {

	public enum TipoDaEstat {INTEIRO("Num. Natural", RegraDaEstat.MAIOR_MELHOR, RegraDaEstat.MENOR_MELHOR),
							 DOUBLE("Num. Decimal", RegraDaEstat.MAIOR_MELHOR, RegraDaEstat.MENOR_MELHOR),
							 BOOLEANO("Verdadeiro ou Falso", RegraDaEstat.TRUE_MELHOR, RegraDaEstat.FALSE_MELHOR);
		
		private final String text;
		private final RegraDaEstat[] regrasPermitidas;
		
		TipoDaEstat(String text, RegraDaEstat... regrasPermitidas){
			this.text = text;
			this.regrasPermitidas = regrasPermitidas;
		}
		
		@Override
		public String toString() {
			return text;
		}
		
		public RegraDaEstat[] getRegrasPermitidas() {
			return regrasPermitidas;
		}
	}
	
	public enum RegraDaEstat {MAIOR_MELHOR("Maior é Melhor"),
							  MENOR_MELHOR("Menor é Melhor"),
							  TRUE_MELHOR("Verdadeiro é Melhor"),
							  FALSE_MELHOR("Falso é Melhor");
		
		private final String texto;
		
		RegraDaEstat(String texto) {
			this.texto = texto;
		}
		
		@Override
		public String toString() {
			return texto;
		}
		
	}
	
	private String nome;
	private TipoDaEstat tipo;
	private boolean temTipo = false;
	private RegraDaEstat regraTipo;
	
	public Estatisticas_Config(String nome) {
		
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDaEstat getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaEstat tipo) {
		this.tipo = tipo;
	}

	public RegraDaEstat getRegraTipo() {
		return regraTipo;
	}

	public void setRegraTipo(RegraDaEstat regraTipo) {
		this.regraTipo = regraTipo;
	}

	public boolean isTemTipo() {
		return temTipo;
	}

	public void setTemTipo(boolean temTipo) {
		this.temTipo = temTipo;
	}
	
}
