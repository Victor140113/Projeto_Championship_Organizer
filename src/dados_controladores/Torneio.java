package dados_controladores;
import java.util.*;
import dados_controladores.*;

public class Torneio {

	public enum TipoDoTorneio {
		INDIVIDUAL,
		EQUIPES
	}
	
	private String nomeTorneio;
	private Integer idInicialGlobal = 1352;
	private List<Estatisticas_Config> statistics;
	private Map<Integer, Participante> jogadores;
	private List<Equipe> equipes;
	private TipoDoTorneio tipoDoTorneio;
	private boolean estatsCriado;
	
	public Torneio() {
		statistics = new ArrayList<Estatisticas_Config>();
		jogadores = new HashMap();
		equipes = new ArrayList<Equipe>();
		estatsCriado = false;
		tipoDoTorneio = null;
	}

	public String getNomeTorneio() {
		return nomeTorneio;
	}

	public void setNomeTorneio(String nomeTorneio) {
		this.nomeTorneio = nomeTorneio;
	}

	public List<Estatisticas_Config> getStatistics() {
		return statistics;
	}

	public void addStatistics(Estatisticas_Config statistics) {
		this.statistics.add(statistics);
	}

	public boolean isEstatsCriado() {
		return estatsCriado;
	}

	public void setEstatsCriado(boolean estatsCriado) {
		this.estatsCriado = estatsCriado;
	}

	public TipoDoTorneio getTipoDoTorneio() {
		return tipoDoTorneio;
	}

	public void setTipoDoTorneio(TipoDoTorneio tipoDoTorneio) {
		this.tipoDoTorneio = tipoDoTorneio;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Integer getIdInicialGlobal() {
		return idInicialGlobal;
	}

	public void setIdInicialGlobal(Integer idInicial) {
		this.idInicialGlobal += idInicial;
	}

	public Map<Integer, Participante> getJogadores() {
		return jogadores;
	}

	public void addJogadores(Integer id, Participante player) {
		jogadores.put(id, player);
	}
	
}
