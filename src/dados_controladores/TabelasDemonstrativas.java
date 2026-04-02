package dados_controladores;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import championship_Organizer.*;

import championship_Organizer.CriarEstat_CriarOrganizarEstat;

public class TabelasDemonstrativas extends JFrame{

	Torneio infoTorneio;
	
	public TabelasDemonstrativas(AppTelaPrincipal tela, int iTable) {
		setTitle("Tabela Demonstrativa");
		setBounds(670, 450, 500, 500);
		
		infoTorneio = tela.getTorneio();
		String[] nomesEstats = new String[infoTorneio.getStatistics().size()+3];

		for(int i = 0; i<infoTorneio.getStatistics().size()+3; i++) {
			
			if(i==0) {
				nomesEstats[0] = iTable==0 ? "ID Jogador":"ID Equipe";
			}else if(i==1) {
			nomesEstats[1] = "Classificação";
			}else if(i==2) {
			nomesEstats[2] = iTable==0 ? "Nome do Jogador":"Nome da Equipe";
			}else {
			nomesEstats[i] = infoTorneio.getStatistics().get(i-3).getNome();
			}
		}
		
		switch(iTable) {
		
		case 0:
			
			String[] colunaInd = {"ID Jogador", "Classificação", "Nome do Jogador", "Estatistica 1"};
			DefaultTableModel tabelaInd = new DefaultTableModel(infoTorneio.isEstatsCriado() ? nomesEstats:colunaInd, 0){
				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			
			fillTableDemo(tabelaInd);
			
			JTable outTabelaInd = new JTable(tabelaInd);
			outTabelaInd.getTableHeader().setReorderingAllowed(false);
			JScrollPane sInd = new JScrollPane(outTabelaInd);
			sInd.setBounds(0, 0, 500, 500);
			
			add(sInd);
			break;
			
		case 1:
			
			String[] colunaEquipe = {"ID Equipe", "Classificação", "Nome da Equipe", "Estatística1"};
			DefaultTableModel tabelaEquipe = new DefaultTableModel(infoTorneio.isEstatsCriado() ? nomesEstats:colunaEquipe, 0){
				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			
			fillTableDemo(tabelaEquipe);
			
			JTable outTabela = new JTable(tabelaEquipe);
			outTabela.getTableHeader().setReorderingAllowed(false);
			JScrollPane sEquipe = new JScrollPane(outTabela);
			sEquipe.setBounds(0, 0, 500, 500);
			
			add(sEquipe);
			break;
			
		default:
			System.out.println("Erro no programa");
		}
		
		setVisible(true);
	}
	
	public void fillTableDemo(DefaultTableModel tabelaAlvo) {
		
		String nome = "NomeExemplo";
		for(int i = 1; i<30; i++) {
			tabelaAlvo.addRow(new Object[] {
					i+1315, i, nome+i, 1000-(i*10)
			});
		}
	}
	
}
