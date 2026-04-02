package championship_Organizer;
import javax.swing.*;
import java.util.*;
import dados_controladores.*;

public class CriarEstat_Inicial extends JPanel{
	
	
	
	Torneio infoTorneio;
	
	JButton criarEstat;
	JButton deleteEstat;
	
	JTextArea sorterText;
	
	JTextField inAddEstat;
	
	public CriarEstat_Inicial(AppTelaPrincipal telaPrincipal, MiniTela_CriarEstat tela) {
		setBounds(0, 0, 600, 400);
		setLayout(null);
		
		infoTorneio = telaPrincipal.getTorneio();
		
		
		JLabel text2 = new JLabel("Estatísticas adicionadas:");
		text2.setBounds(230, 100, 250, 25);
		
		sorterText = new JTextArea();
		sorterText.setBounds(150, 130, 300, 80);
		sorterText.setWrapStyleWord(true);
		sorterText.setLineWrap(true);
		sorterText.setEditable(false);
		sorterText.setCursor(null);
		sorterText.setFocusable(false);
		sorterText.setText(setString(infoTorneio.getStatistics()));
		
		
		JLabel text = new JLabel("Digite as estatísticas a serem criadas: ");
		text.setBounds(10, 0, 250, 25);
		
		inAddEstat = new JTextField();
		inAddEstat.setBounds(240, 0, 250, 25);
		inAddEstat.addActionListener(e->{
			
			String textoVerificar = inAddEstat.getText();
			if(textoVerificar.isEmpty()) return;
			
			infoTorneio.addStatistics(new Estatisticas_Config(inAddEstat.getText()));
			sorterText.setText(setString(infoTorneio.getStatistics()));
			inAddEstat.setText("");
			criarEstat.setEnabled(true);
			deleteEstat.setEnabled(true);
			telaPrincipal.setExisteEstatisticas(true);
			
		});
		
		
		criarEstat = new JButton("Criar e Configurar");
		criarEstat.setBounds(200, 240, 200, 50);
		criarEstat.setEnabled(false);
		if(telaPrincipal.isExisteEstatisticas()) criarEstat.setEnabled(true);
		criarEstat.addActionListener(e->{
			tela.trocarTelaConfig(this, new CriarEstat_CriarOrganizarEstat(tela, this, infoTorneio));
		});
		
		deleteEstat = new JButton("Deletar Estatísticas");
		deleteEstat.setBounds(200, 300, 200, 50);
		deleteEstat.setEnabled(false);
		if(telaPrincipal.isExisteEstatisticas()) deleteEstat.setEnabled(true);
		deleteEstat.addActionListener(e->{
			
			int confirm = JOptionPane.showConfirmDialog(this, "Deletar todas as estatísticas?", "Deletar Estatísticas", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION) {
				infoTorneio.getStatistics().clear();
				sorterText.setText(setString(infoTorneio.getStatistics()));
				infoTorneio.setEstatsCriado(false);
				telaPrincipal.setExisteEstatisticas(false);
				tela.dispose();
			}
			
		});
		
		add(deleteEstat);
		add(sorterText);
		add(text2);
		add(criarEstat);
		add(inAddEstat);
		add(text);
	}
	
	String setString(List<Estatisticas_Config> listAlvo) {
		
		int i = 0;
		String stringAlvo = new String();
		for(Estatisticas_Config a : listAlvo) {
			stringAlvo += a.getNome()+", ";
			++i;
			if(i == listAlvo.size() && stringAlvo.endsWith(", ")){
				stringAlvo = stringAlvo.substring(0, stringAlvo.length()-2);
			}
		}
		return stringAlvo;
	}
	
	
	
}
