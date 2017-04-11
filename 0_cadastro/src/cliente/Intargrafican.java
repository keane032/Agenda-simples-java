package cliente;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import aluno.Cadastro;
import aluno.Contato;
import jdk.nashorn.internal.scripts.JO;
import sun.management.resources.agent;


public class Intargrafican extends JFrame{

	/**
	 * public static void main(String[] args) {

	final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextPane textPane;
	Cadastro cadastro;
	JFrame frame = new JFrame("ew");



	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.setBounds(450,400,450,400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	frame.setContentPane(contentPane);
	contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS));
	frame.setVisible(true);
		}
	}
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private Cadastro cadastro;
	private Component cp;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intargrafican frame = new Intargrafican();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Intargrafican(){	
		cadastro = new Cadastro();
		cadastro.resetAgenda(10);
		cadastro.adicionarContato("12345","roy");
		cadastro.adicionarContato("123456", "roy");
		cp = this;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450,300,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS));
		
		
		Box boxAgenda = Box.createVerticalBox();
		contentPane.add(boxAgenda);


		JButton btRset = new JButton("reset");
		btRset.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(btRset);
		btRset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ resetAgenda(); }
		});

		JButton btAdicionar = new JButton("adicionar");
		btAdicionar.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(btAdicionar);
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { adcionar(); }
		});

		JButton btPbyT = new JButton("pegar por telefone");
		btPbyT.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(btPbyT);
		btPbyT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { PegerbyTel();}
		});
		
		JButton btAtualizar = new JButton("atualiza");
		btAtualizar.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(btAtualizar);
			btAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { atualizar();}
			});
		
		JButton btremover = new JButton("remover");	
		btremover.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(btremover);
		btremover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { remover();}
		});

		JButton getContos = new JButton("getContatos");
		getContos.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(getContos);
		getContos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { getContatos();}
		});
		
		JButton gTbyC = new JButton("pegar por contato");
		gTbyC.setAlignmentX(CENTER_ALIGNMENT);
		boxAgenda.add(gTbyC);
		gTbyC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { getPorContato(); }
		});
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		contentPane.add(textPane);
		ATnaTela();
		
	}

	
	protected void getPorContato() {
		String nome = JOptionPane.showInputDialog("Digite o nome do contato");
		JOptionPane.showMessageDialog(cp, cadastro.getTelefones(nome));
			
		
		// TODO Auto-generated method stub
		
	}

	protected void getContatos() {
		JOptionPane.showMessageDialog(cp,cadastro.getContatos());
		// TODO Auto-generated method stub
	}

	private void ATnaTela() {
		String Contato="AGENDA:\n";
		List<IContato> lista = cadastro.getContatos();
		for(IContato contato: lista){
			Contato += "Nome : " + contato.getNome() + " -> " + " Telefone : " + contato.getTelefone() + "\n";
		}
		textPane.setText(Contato);
	
	}
	
	protected void remover() {
		// TODO Auto-generated method stub
		String com = JOptionPane.showInputDialog("digite o telefone");
		try {
			cadastro.removerContato(com);
			JOptionPane.showMessageDialog(cp, "contato removido");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(cp, "remocao invalida");
			// TODO: handle exception
		}
		ATnaTela();
	}

	protected void atualizar() {
		String nome = JOptionPane.showInputDialog("Digite o novo contato");
		String numero = JOptionPane.showInputDialog("Digite o numero");
		try{
			if(cadastro.atualizarContato(numero, nome)){
				JOptionPane.showMessageDialog(cp, "Contato Atualizado");
			}else{
				JOptionPane.showMessageDialog(cp, "Contato nao existe");
			}
		}catch(Exception e2){
			JOptionPane.showMessageDialog(cp, "Contato nao existe !");
		}
		// TODO Auto-generated method stub	
		ATnaTela();
	}

	protected void PegerbyTel() {
		String res = JOptionPane.showInputDialog("Diginte o telefone");
		try {
			cadastro.getContatoByTel(res);
			JOptionPane.showMessageDialog(cp, cadastro.getContatoByTel(res).getNome());
		} catch (Exception e2) {
			// TODO: handle exception
		JOptionPane.showMessageDialog(cp, "contato nao exixte");
		}
		
		// TODO Auto-generated method stub
	}

	protected void adcionar() {
		String nome = JOptionPane.showInputDialog("digite o nome");
		String numero = JOptionPane.showInputDialog("digite o numero");
		try{	
			if(cadastro.adicionarContato(numero,nome)){
			JOptionPane.showMessageDialog(cp, "contato adicionado");
			}else{
				JOptionPane.showMessageDialog(cp, "nao foi posivel adicionar contato");
			}
		}catch(Exception e2){
			JOptionPane.showMessageDialog(cp, "nao foi posivel adicionar contato");
		}
		ATnaTela();
		// TODO Auto-generated method stub
	}

	protected void resetAgenda() {
		String res = JOptionPane.showInputDialog("digite novo limite");
		try{
			int max = Integer.parseInt(res);
			cadastro.resetAgenda(max);
			JOptionPane.showMessageDialog(cp,"limite adcionado");
		
		}catch(Exception e2){
			JOptionPane.showMessageDialog(cp,"nao foi posivel resetar agenda");
		}
		ATnaTela();
		// TODO Auto-generated method stub
	}
	
}
