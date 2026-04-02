package championship_Organizer;

import java.awt.Component;

import javax.swing.*;

public class MiniTela_CriarEstat extends JFrame {

	public MiniTela_CriarEstat(AppTelaPrincipal tela){
		setTitle("Criar Estatísticas");
		setSize(600, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		
		CriarEstat_Inicial mTelaInicial = new CriarEstat_Inicial(tela, this);
		
		add(mTelaInicial);
		setVisible(true);
	}
	
	public void trocarTelaConfig(Component removeItem, Component addItem) {
		remove(removeItem);
		add(addItem);
		revalidate();
		repaint();
	}
}
