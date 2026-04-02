package dados_controladores;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

	private String nomeEquipe;
	private List<Participante> playersEquipe;
	private List<Integer> statisticsInt;
	private List<Boolean> statisticsBool;
	private List<Double> statisticsDouble;
	
	public Equipe() {
		playersEquipe = new ArrayList<Participante>();
		statisticsInt = new ArrayList<Integer>();
		statisticsBool = new ArrayList<Boolean>();
		statisticsDouble = new ArrayList<Double>();
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
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

	public List<Participante> getPlayersEquipe() {
		return playersEquipe;
	}

	public void setPlayersEquipe(List<Participante> playersEquipe) {
		this.playersEquipe = playersEquipe;
	}
	
}
