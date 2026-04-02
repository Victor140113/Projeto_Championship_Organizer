package championship_Organizer;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {

	JButton createButton;
	
	public TelaInicial(AppTelaPrincipal tela){
		setBounds(0, 0, 1440, 960);
		setLayout(null);
		
		createButton = new JButton("Criar Torneio");
		createButton.setBounds(500, 360, 400, 100);
		createButton.addActionListener(e -> {
			tela.trocarTelaConfig(this, new TelaCriarTorneio(tela, this));
		});
		
		add(createButton);
		
	}
}
