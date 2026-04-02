package championship_Organizer;
import java.awt.Component;
import dados_controladores.*;
import javax.swing.*;

public class AppTelaPrincipal extends JFrame{

	private Torneio torneio;
	private boolean existeEstatisticas = false;
	
	public AppTelaPrincipal() {
		
		torneio = new Torneio();
		
		
		
		setTitle("Championship Organizer");
		setSize(1440, 960);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		

		
		add(new TelaInicial(this));
		
	}
	
	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	/*public boolean isTipoTorneioEscolhido() {
		return tipoTorneioEscolhido;
	}

	public void setTipoTorneioEscolhido(boolean tipoTorneioEscolhido) {
		this.tipoTorneioEscolhido = tipoTorneioEscolhido;
	}*/
	
	public boolean isExisteEstatisticas() {
		return existeEstatisticas;
	}

	public void setExisteEstatisticas(boolean existeEstatisticas) {
		this.existeEstatisticas = existeEstatisticas;
	}

	public void trocarTelaConfig(Component removeItem, Component addItem) {
		remove(removeItem);
		add(addItem);
		revalidate();
		repaint();
	}
	
}
