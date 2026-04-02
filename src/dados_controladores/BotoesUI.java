package dados_controladores;
import javax.swing.*;
import championship_Organizer.*;
import dados_controladores.Torneio.TipoDoTorneio;

import java.awt.*;

public class BotoesUI {

	private static int optionSelected;
	
	public static JButton botaoVoltar(AppTelaPrincipal tela, Component removeItem, Component addItem) {
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0, 0, 150, 50);
		voltar.addActionListener(e ->{
			tela.trocarTelaConfig(removeItem, addItem);
		});
		return voltar;
	}
	
	public static JButton botaoVoltar(MiniTela_CriarEstat tela, Component removeItem, Component addItem) {
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0, 0, 75, 25);
		voltar.addActionListener(e ->{
			tela.trocarTelaConfig(removeItem, addItem);
		});
		return voltar;
	}
	
	public static JButton botaoVoltar(AppTelaPrincipal tela, Component removeItem, Component addItem, int withY_Or_Not) {
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(0, 0, 150, 50);
		voltar.addActionListener(e ->{
			optionSelected = JOptionPane.showConfirmDialog(removeItem, "Essa ação vai ocasionar na perda das configurações feitas no torneio anteriormente, deseja prosseguir?", "Confirmar ação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(optionSelected == JOptionPane.YES_OPTION) {
				tela.setTorneio(new Torneio());
				tela.trocarTelaConfig(removeItem, addItem);
			}
		});
		return voltar;
	}
	
	public static JButton botaoOrganizarTorneio(AppTelaPrincipal tela, Component removeItem, Component addItem) {
		JButton orgTorneio = new JButton("Organizar Torneio");
		orgTorneio.setBounds(500, 360, 400, 100);
		orgTorneio.addActionListener(e ->{
			tela.trocarTelaConfig(removeItem, addItem);
		});
		return orgTorneio;
	}
	
	public static JButton botaoConfigPlayers(AppTelaPrincipal tela, Component removeItem, Component addItem, TipoDoTorneio tipoDoTorneio) {
		JButton configPlayers = new JButton(tipoDoTorneio==TipoDoTorneio.INDIVIDUAL ? "Adicionar/Editar Jogadores":"Adicionar/Editar Equipes");
		configPlayers.setBounds(500, 470, 400, 100);
		configPlayers.addActionListener(e ->{
			tela.trocarTelaConfig(removeItem, addItem);
		});
		return configPlayers;
	}
	
	public static JButton botaoClassificacao(AppTelaPrincipal tela, Component removeItem, Component addItem) {
		JButton classificacao = new JButton("Tabela de Classificação");
		classificacao.setBounds(500, 360, 400, 100);
		classificacao.addActionListener(e ->{
			tela.trocarTelaConfig(removeItem, addItem);
		});
		return classificacao;
	}
	
	public static JButton botaoTabelasDemo(AppTelaPrincipal tela, int iTable) {
		JButton tabelaDemo = new JButton("Mostrar Tabela Demonstrativa");
		tabelaDemo.setBounds(540, 380, 280, 70);
		tabelaDemo.setToolTipText("Mostra uma tabela de demonstração com as configurações criadas.");
		tabelaDemo.addActionListener(e->{
			TabelasDemonstrativas tabela = new TabelasDemonstrativas(tela, iTable);
		});
		return tabelaDemo;
	}
	
	public static JButton botaoCriarEstat(AppTelaPrincipal tela) {
		
		JButton criarEstat = new JButton("Criar/Editar Estatísticas");
		criarEstat.setBounds(540, 300, 280, 70);
		criarEstat.setToolTipText("Cria as estatísticas que serão exibidas nas tabelas (pontos, vitórias, derrotas etc)");
		criarEstat.addActionListener(e->{
			MiniTela_CriarEstat telaCriarEstat = new MiniTela_CriarEstat(tela);
		});
		return criarEstat;
	}
	
}
