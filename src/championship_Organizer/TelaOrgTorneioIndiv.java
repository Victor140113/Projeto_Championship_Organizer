package championship_Organizer;
import javax.swing.*;

import dados_controladores.*;

public class TelaOrgTorneioIndiv extends JPanel{

	JButton voltar;
	JButton tabelaDemo;
	JButton criarEstat;
	
	JTextField inNomeTorneio;
	
	Torneio infoTorneio;
	
	public TelaOrgTorneioIndiv(AppTelaPrincipal tela, TelaIndividual telaIndividual) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaIndividual);
		
		tabelaDemo = BotoesUI.botaoTabelasDemo(tela, 0);
		
		criarEstat = BotoesUI.botaoCriarEstat(tela);
		
		
		JLabel nomeTorneio = new JLabel("Nome do torneio: ");
		nomeTorneio.setBounds(550, 200, 100, 25);
		
		inNomeTorneio = new JTextField();
		inNomeTorneio.setBounds(650, 200, 150, 25);
		
		infoTorneio = tela.getTorneio();
		
		inNomeTorneio.addActionListener(e ->{
			
			String textoVerificar = inNomeTorneio.getText();
			if(textoVerificar.isEmpty()) return;
			
			infoTorneio.setNomeTorneio(inNomeTorneio.getText());
			System.out.println(infoTorneio.getNomeTorneio());
			
		});
		
		
		add(criarEstat);
		add(tabelaDemo);
		add(nomeTorneio);
		add(inNomeTorneio);
		add(voltar);
	}
}
