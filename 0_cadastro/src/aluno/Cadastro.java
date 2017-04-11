package aluno;

import java.util.ArrayList;
import cliente.ICadastro;
import cliente.IContato;

public class Cadastro implements ICadastro{

	private ArrayList<IContato> agenda = new ArrayList<IContato>();
	private int maxContatos;
	
	@Override
	public boolean resetAgenda(int maxContatos) {
		this.maxContatos=maxContatos;
		agenda.clear();
		return true;
	}

	@Override
	public boolean adicionarContato(String telefone, String nome) {
		if (agenda.size() == maxContatos){
			return false;
		}
		
		for (IContato cont : agenda) {
			if(cont.getTelefone().equals(telefone)){
				return false;
			}
		}
		
		if(nome == null || nome == "" || telefone == null || telefone == ""){
			return false;
		}
		
		for (int i = 0; i < telefone.length(); i++ ) {
			char c = telefone.charAt(i);
			if(c < 48 || c > 57){
				return false;
				}
			}
		
		Contato contato = new Contato(nome, nome);
		contato.setNome(nome);
		contato.setTelefone(telefone);
		agenda.add(contato);
		return true;
		
}

	@Override
	public IContato getContatoByTel(String telefone) {
		if(telefone != null){
		for (IContato contato : agenda) {
			if(telefone.equals(contato.getTelefone())){
			return contato;	
		}
			}
				}
		return null;
					}
	
 // TODO Auto-generated method stub
	

	@Override
	public boolean atualizarContato(String telefone, String nome) {
		for (IContato contato : agenda) {
			if(contato.getTelefone().equals(telefone) && nome != ""){
				contato.setNome(nome);
				return true;
			}
		
		}
		for (int i = 0; i < telefone.length(); i++) {
			char c = telefone.charAt(i);
			if(c < 48 || c > 57 ){
				return false;
			}
		}
		return false;
		
		// TODO Auto-generated method stub
	}

	@Override
	public boolean removerContato(String telefone) {
		for (IContato contato : agenda) {
			if(contato.getTelefone().equals(telefone)){
				agenda.remove(contato);
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<IContato> getContatos() {
		return agenda;
	}

	
	
	
	@Override
	public ArrayList<String> getTelefones(String contato) {
		ArrayList<String> numeros = new ArrayList<String>();
		for (IContato Contato : agenda) {
			if(Contato.getNome().equals(contato)){
				numeros.add(contato);
			}
					}
		return numeros;
	}	
}
