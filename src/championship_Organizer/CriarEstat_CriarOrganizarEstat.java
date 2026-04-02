package championship_Organizer;
import javax.swing.*;
import dados_controladores.*;
import dados_controladores.Estatisticas_Config.TipoDaEstat;
import java.awt.*;
import java.awt.event.ItemEvent;

public class CriarEstat_CriarOrganizarEstat extends JPanel{
	
	boolean atualizandoTela = false;
	
	JButton criar;
	JButton voltar;
	
	JLabel texto1;
	JLabel texto2;
	JLabel texto3;
	
	
	DefaultComboBoxModel<String> dadosEstats;
	DefaultComboBoxModel<Estatisticas_Config.RegraDaEstat> regras;
	
	JComboBox estatsCriadas;
	JComboBox tipoEstat;
	JComboBox regraEstat;
	
	
	public CriarEstat_CriarOrganizarEstat(MiniTela_CriarEstat tela, CriarEstat_Inicial criarEstat_Inicial, Torneio infoTorneio) {
		setBounds(0, 0, 600, 400);
		setLayout(null);
		
		ControladoresTelas.timeToolTipText(200, 20000, 350);

		voltar = BotoesUI.botaoVoltar(tela, this, criarEstat_Inicial);
		
		criar = new JButton("Criar");
		criar.setBounds(200, 220, 180, 50);
		criar.addActionListener(e->{
			
			infoTorneio.setEstatsCriado(true);
			tela.dispose();
			
		});
		
		texto1 = new JLabel("Estatística:");
		texto1.setBounds(50, 55, 75, 25);
		
		texto2 = new JLabel("Tipo da Estatística:");
		texto2.setBounds(220, 55, 120, 25);
		
		texto3 = new JLabel("Regra da Estatística:");
		texto3.setBounds(390, 55, 150, 25);
		
		dadosEstats = new DefaultComboBoxModel<>();
		
		for(Estatisticas_Config a : infoTorneio.getStatistics()) {
			dadosEstats.addElement(a.getNome());
		}
		
		estatsCriadas = new JComboBox(dadosEstats);
		estatsCriadas.setBounds(50, 80, 150, 40);
		estatsCriadas.addActionListener(e->{
			
			atualizandoTela = true;
			
			estatsCriadas.setSelectedItem(0);
			Estatisticas_Config estat = infoTorneio.getStatistics().get(estatsCriadas.getSelectedIndex());
			int index = estatsCriadas.getSelectedIndex();
			Estatisticas_Config estatistica = infoTorneio.getStatistics().get(index);
			if(infoTorneio.getStatistics().get(estatsCriadas.getSelectedIndex()).isTemTipo()) {
				regraEstat.setEnabled(true);
			}else {
				regraEstat.setEnabled(false);
			}
			
			tipoEstat.setSelectedItem(estatistica.getTipo());
			
			DefaultComboBoxModel<Estatisticas_Config.RegraDaEstat> model =
					(DefaultComboBoxModel<Estatisticas_Config.RegraDaEstat>) regraEstat.getModel();

				model.removeAllElements();

				if (estat.isTemTipo()) {
					for (Estatisticas_Config.RegraDaEstat r : estat.getTipo().getRegrasPermitidas()) {
						model.addElement(r);
					}
					regraEstat.setEnabled(true);
					regraEstat.setSelectedItem(estat.getRegraTipo());
				} else {
					regraEstat.setEnabled(false);
				}
			
			atualizandoTela = false;
		});
		
		tipoEstat = new JComboBox(Estatisticas_Config.TipoDaEstat.values());
		tipoEstat.setBounds(220, 80, 150, 40);
		tipoEstat.setToolTipText("Num. Natural = 1, 2, 3...  Num. Decimal = 1.1, 1.2, 1.3...  "
				+ "V ou F = alternância de estados (vivo/morto, Competindo/Desclassificado)");
		tipoEstat.addActionListener(e->{
			
			if(atualizandoTela) return;
			
			Estatisticas_Config estat = infoTorneio.getStatistics().get(estatsCriadas.getSelectedIndex());
			DefaultComboBoxModel<Estatisticas_Config.RegraDaEstat> model = (DefaultComboBoxModel<Estatisticas_Config.RegraDaEstat>) regraEstat.getModel();
			
			estat.setTipo((Estatisticas_Config.TipoDaEstat) tipoEstat.getSelectedItem());
			TipoDaEstat tipo = estat.getTipo();
			estat.setTemTipo(true);
			if(estat.isTemTipo()) regraEstat.setEnabled(true);
			
				model.removeAllElements();
				for (Estatisticas_Config.RegraDaEstat r : tipo.getRegrasPermitidas()) {
					model.addElement(r);
				}
			
		});
		
		regras = new DefaultComboBoxModel<>();
		
		regraEstat = new JComboBox(regras);
		regraEstat.setBounds(390, 80, 150, 40);
		regraEstat.setEnabled(false);
		regraEstat.setToolTipText("Maior é melhor: Ex. 'Mais gols/kills/pontos melhor'."
				+ " Menor é melhor: Ex. 'Menos Faltas/Mortes/Derrotas melhor'."
				+ " Verdadeiro ou Falso: Ex. 'Vivo é melhor/pior' ou 'Morto é melhor/pior'.");
		regraEstat.addActionListener(e->{
			
			if(atualizandoTela) return;
			
			Estatisticas_Config estat = infoTorneio.getStatistics().get(estatsCriadas.getSelectedIndex());
			estat.setRegraTipo((Estatisticas_Config.RegraDaEstat) regraEstat.getSelectedItem());
			
		});
		
		add(texto1);
		add(texto2);
		add(texto3);
		add(voltar);
		add(regraEstat);
		add(estatsCriadas);
		add(tipoEstat);
		add(criar);
	}


	public JButton getCriar() {
		return criar;
	}


	public void setCriar(JButton criar) {
		this.criar = criar;
	}

	public JComboBox getEstatsCriadas() {
		return estatsCriadas;
	}


	public void setEstatsCriadas(JComboBox estatsCriadas) {
		this.estatsCriadas = estatsCriadas;
	}


	public JComboBox getTipoEstat() {
		return tipoEstat;
	}


	public void setTipoEstat(JComboBox tipoEstat) {
		this.tipoEstat = tipoEstat;
	}


	public JComboBox getRegraEstat() {
		return regraEstat;
	}


	public void setRegraEstat(JComboBox regraEstat) {
		this.regraEstat = regraEstat;
	}
	
	
	
}
