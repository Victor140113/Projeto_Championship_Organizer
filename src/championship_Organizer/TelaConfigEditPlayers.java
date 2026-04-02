package championship_Organizer;
import dados_controladores.*;
import javax.swing.*;
public class TelaConfigEditPlayers extends JPanel {

	Torneio infoTorneio;
	
	JButton voltar;
	JButton deletePlayer;
	
	JLabel texto;
	JLabel texto2;
	
	JTextField addPlayer;
	
	DefaultComboBoxModel listaPlayersData;
	JComboBox listaPlayers;
	
	public TelaConfigEditPlayers(AppTelaPrincipal tela, TelaIndividual telaIndividual) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		ControladoresTelas.timeToolTipText(200, 100000, 300);
		
		infoTorneio = tela.getTorneio();
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaIndividual);
		
		deletePlayer = new JButton("Deletar Jogador");
		deletePlayer.setBounds(900, 350, 150, 50);
		deletePlayer.setEnabled(false);
		deletePlayer.setToolTipText("Deleta o jogador selecionado.");
		deletePlayer.addActionListener(e->{
			
			Participante player = (Participante) listaPlayers.getSelectedItem();
			DefaultComboBoxModel model = (DefaultComboBoxModel) listaPlayers.getModel();
			
			infoTorneio.getJogadores().remove(player.getId());
			model.removeAllElements();
			
			for(Participante p : infoTorneio.getJogadores().values()) {
				model.addElement(p);
			}
			
			deletePlayer.setEnabled(listaPlayersData.getSize()>0);
			
		});
		
		listaPlayersData = new DefaultComboBoxModel();
		
		listaPlayers = new JComboBox(listaPlayersData);
		listaPlayers.setBounds(680, 360, 180, 30);
		listaPlayers.setMaximumRowCount(12);
		
		texto = new JLabel("Adicionar Jogador:");
		texto.setBounds(490, 330, 150, 25);
		
		texto2 = new JLabel("Jogadores:");
		texto2.setBounds(730, 330, 100, 25);
		
		addPlayer = new JTextField();
		addPlayer.setBounds(460, 360, 180, 30);
		addPlayer.addActionListener(e->{
			
			String verif = addPlayer.getText().trim();
			if(verif.isEmpty()) return;
			
			Participante player = new Participante(addPlayer.getText(), infoTorneio.getIdInicialGlobal());
			infoTorneio.addJogadores(player.getId(), player);
			infoTorneio.setIdInicialGlobal(1);
			listaPlayersData.addElement(infoTorneio.getJogadores().get(player.getId()));
			listaPlayers.setSelectedIndex(0);
			deletePlayer.setEnabled(true);
			addPlayer.setText("");
			
		});
		
		
		add(deletePlayer);
		add(listaPlayers);
		add(texto);
		add(texto2);
		add(addPlayer);
		add(voltar);
	}
}
