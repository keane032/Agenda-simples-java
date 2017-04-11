package cliente;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import aluno.Cadastro;
import aluno.Contato;

public class UserInterface extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private Cadastro cadastro;
	Component parent;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UserInterface() {
		cadastro = new Cadastro();
		cadastro.resetAgenda(10);
		parent = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		JButton btnReset = new JButton("Resetar Agenda");
		btnReset.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { resetAgenda(); }
		});
		
		JButton btnAdd = new JButton("Adicionar Contato");
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { adicionarContato(); }
		});
		
				
		JButton btnGetBy = new JButton("Buscar por Telefone");
		btnGetBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnGetBy);
		btnGetBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { getContatoByTel(); }
		});
		
		/*
		JButton btnAtualizar = new JButton("Atualizar Contato");
		btnAtualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { atualizarContato(); }
		});
		
		JButton btnRemover = new JButton("Remover Contato");
		btnRemover.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { removerContato(); }
		});
		
		JButton btn = new JButton("Buscar Telefones por Contato");
		btnGet.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnGet);
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { getTelefones(); }
		});
*/
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		contentPane.add(textPane);
		
		atualizarAgenda();
	}
	
	public void resetAgenda() {
		String res = JOptionPane.showInputDialog("Diginte o novo Limite da Agenda");
		
		try {
			int valor = Integer.parseInt(res);
			cadastro.resetAgenda(valor);
				JOptionPane.showMessageDialog(parent, "Agenda Resetada!");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(parent, "Não foi possível resetar a agenda!");
		}
		
		// Atualizando o extrato em tela
	}
	public void adicionarContato() {
		String resNome = JOptionPane.showInputDialog("Diginte o nome do Contato");
		String resTel = JOptionPane.showInputDialog("Diginte o numero do Contato");
		try {
			cadastro.adicionarContato( resTel,resNome);
				JOptionPane.showMessageDialog(parent, "Contato Adicionado!");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(parent, "Algo errado! tente outra vez!");
		}
		
		// Atualizando o extrato em tela
		atualizarAgenda();
	}
	public void atualizarAgenda() {
		String Contato = "";
		List<IContato> ex = cadastro.getContatos();
		for(IContato contato: ex){
			Contato += "Nome : " + contato.getNome() + " -> " + " Telefone : " + contato.getTelefone() + "\n";
		}
		textPane.setText(Contato);
	
	}
	public void getContatoByTel() {
		String res = JOptionPane.showInputDialog("Diginte o telefone");
		if(res == "" ){
			JOptionPane.showMessageDialog(parent, " invalido");
		}
		List<IContato> conte = cadastro.getContatos();
		for (IContato iContato : conte) {
			if(iContato.getTelefone().equals(res)){
				 JOptionPane.showMessageDialog(parent, iContato.getNome());
			}
		} 
		
	}

}
	