package championship_Organizer;
import dados_controladores.*;
import javax.swing.*;

public class TelaConfigEditEquipes extends JPanel {

	JButton voltar;
	
	
	public TelaConfigEditEquipes(AppTelaPrincipal tela, TelaEquipe telaEquipe) {
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		voltar = BotoesUI.botaoVoltar(tela, this, telaEquipe);
		
		add(voltar);
	}
}
