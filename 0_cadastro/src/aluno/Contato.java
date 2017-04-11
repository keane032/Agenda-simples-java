package aluno;

import cliente.IContato;

public class Contato implements IContato {

	private String nome;
	private String telefone;
		
	
	public Contato(String telefone ,String nome) {
	this.nome=nome;
	this.telefone=telefone;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome=nome;
		// TODO Auto-generated method stub

	}

	@Override
	public String getTelefone() {
		// TODO Auto-generated method stub
		return this.telefone;
	}

	@Override
	public void setTelefone(String telefone) {
		// TODO Auto-generated method stub
		this.telefone=telefone;
	}

	public String toString(){
		return this.nome+"->"+this.telefone;
	}
}
