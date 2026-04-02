package championship_Organizer;
import javax.swing.*;
import dados_controladores.*;
import dados_controladores.BotoesUI;
import dados_controladores.Torneio.TipoDoTorneio;

public class TelaIndividual extends JPanel {

	JButton orgTorneio;
	JButton configPlayers;
	JButton classificacao;
	JButton voltar;
	
	public TelaIndividual(AppTelaPrincipal tela, TelaCriarTorneio telaCriarTorneio) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		orgTorneio = BotoesUI.botaoOrganizarTorneio(tela, this, new TelaOrgTorneioIndiv(tela, this));
		
		configPlayers = BotoesUI.botaoConfigPlayers(tela, this, new TelaConfigEditPlayers(tela, this), TipoDoTorneio.INDIVIDUAL);
		configPlayers.setBounds(500, 470, 400, 100);
		
		classificacao = new JButton("Tabela de Classificação");
		classificacao.setBounds(500, 580, 400, 100);
		classificacao.addActionListener(e->{
			TabelaClassificacaoIndividual tabelaClassificacao = new TabelaClassificacaoIndividual(tela);
		});
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaCriarTorneio, 0);
		
		JLabel texto = new JLabel("Criando e organizando torneio INDIVIDUAL");
		texto.setBounds(590,250, 400,100);
		
		add(texto);
		add(voltar);
		add(orgTorneio);
		add(configPlayers);
		add(classificacao);
		
	}
}
