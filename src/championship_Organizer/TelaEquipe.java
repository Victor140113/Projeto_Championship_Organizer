package championship_Organizer;
import javax.swing.*;
import dados_controladores.BotoesUI;
import dados_controladores.Torneio.TipoDoTorneio;

public class TelaEquipe extends JPanel {

	JButton orgTorneio;
	JButton configPlayers;
	JButton classificacao;
	JButton voltar;
	
	public TelaEquipe(AppTelaPrincipal tela, TelaCriarTorneio telaCriarTorneio) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		orgTorneio = BotoesUI.botaoOrganizarTorneio(tela, this, new TelaOrgTorneioEquipes(tela, this));
		
		configPlayers = configPlayers = BotoesUI.botaoConfigPlayers(tela, this, new TelaConfigEditEquipes(tela, this), TipoDoTorneio.EQUIPES);
		configPlayers.setBounds(500, 470, 400, 100);
		
		classificacao = new JButton("Tabela de Classificação");
		classificacao.setBounds(500, 580, 400, 100);
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaCriarTorneio, 0);
		
		JLabel texto = new JLabel("Criando e organizando torneio em EQUIPES");
		texto.setBounds(580, 250, 1420, 100);
		
		add(texto);
		add(voltar);
		add(orgTorneio);
		add(configPlayers);
		add(classificacao);
	}
}
