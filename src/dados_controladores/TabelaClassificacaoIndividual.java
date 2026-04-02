package dados_controladores;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import championship_Organizer.*;

public class TabelaClassificacaoIndividual extends JFrame {

	private Torneio infoTorneio;
	
	private DefaultTableModel tabelaIndData;
	private JTable tabelaInd;
	private JScrollPane s;
	
	public TabelaClassificacaoIndividual(AppTelaPrincipal tela) {
		setTitle("Tabela de Classificação");
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		infoTorneio = tela.getTorneio();
		int i = 0;
		String [] colunas = {"ID Jogador", "Posição", "Nome do Jogador"};
		tabelaIndData = new DefaultTableModel(colunas, 0);
		for(Participante p : infoTorneio.getJogadores().values()) {
			
			String nome = p.getNome();
			Integer id = p.getId();
			Object[] data = {id, ++i + "º", nome};
			tabelaIndData.addRow(data);
		}
		
		tabelaInd = new JTable(tabelaIndData) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabelaInd.getTableHeader().setReorderingAllowed(false);
		
		s = new JScrollPane(tabelaInd);
		s.setBounds(0, 0, 500, 500);
		
		add(s);
		setVisible(true);
	}
}
