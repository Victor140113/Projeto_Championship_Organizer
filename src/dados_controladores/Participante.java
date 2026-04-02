package dados_controladores;
import java.util.*;

public class Participante {

	private String nome;
	private Integer id;
	private List<Integer> statisticsInt;
	private List<Boolean> statisticsBool;
	private List<Double> statisticsDouble;
	
	public Participante(String nome, Integer id) {
		statisticsInt = new ArrayList<Integer>();
		statisticsBool = new ArrayList<Boolean>();
		statisticsDouble = new ArrayList<Double>();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Integer> getStatisticsInt() {
		return statisticsInt;
	}

	public void setStatisticsInt(List<Integer> statisticsInt) {
		this.statisticsInt = statisticsInt;
	}

	public List<Boolean> getStatisticsBool() {
		return statisticsBool;
	}

	public void setStatisticsBool(List<Boolean> statisticsBool) {
		this.statisticsBool = statisticsBool;
	}

	public List<Double> getStatisticsDouble() {
		return statisticsDouble;
	}

	public void setStatisticsDouble(List<Double> statisticsDouble) {
		this.statisticsDouble = statisticsDouble;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.nome;
	}
}
