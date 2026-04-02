package championship_Organizer;
import javax.swing.*;
import dados_controladores.*;
import dados_controladores.BotoesUI;
import dados_controladores.Torneio.TipoDoTorneio;

import java.awt.*;

public class TelaCriarTorneio extends JPanel{

	Torneio infoTorneio;
	
	JButton individual;
	JButton equipes;
	JButton voltar;
	
	
	public TelaCriarTorneio(AppTelaPrincipal tela, TelaInicial telaInicial) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		infoTorneio = tela.getTorneio();
		
		individual = new JButton("Individual");
		individual.setBounds(500, 360, 400, 100);
		individual.addActionListener(e ->{
			infoTorneio.setTipoDoTorneio(TipoDoTorneio.INDIVIDUAL);
			tela.trocarTelaConfig(this, new TelaIndividual(tela, this));
		});
		
		equipes = new JButton("Equipes");
		equipes.setBounds(500, 470, 400, 100);
		equipes.addActionListener(e ->{
			infoTorneio.setTipoDoTorneio(TipoDoTorneio.EQUIPES);
			tela.trocarTelaConfig(this, new TelaEquipe(tela, this));
		});
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaInicial);
		
		add(individual);
		add(equipes);
		add(voltar);
	}
	
}
