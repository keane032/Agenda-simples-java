package cliente;

import java.util.List;

public interface ICadastro {
	
	//Inicia a agenda apagando qualquer contato que nela possua.
	//Também seta o limite da memória para adicionar contatos.
	boolean resetAgenda(int maxContatos);
	
	//Adiciona um contato a agenda passando nome e telefone
	//Nao podem existir duas entradas com o mesmo telefone
	//
	//O telefone deve ser composto apenas de digitos.
	//O nome não pode ser uma string vazia
	//
	//Se o contato foi adicionado com sucesso retorne true
	boolean adicionarContato(String telefone, String nome);
	
	//Função que retorna o nome do contato a partir do seu telefone
	//Se o telefone não existir retorne null
	IContato getContatoByTel(String telefone);
	
	//Atualiza o contato com esse Telefone
	//Retorne false caso telefone não seja encontrado ou
	//nao esteja de acordo com os requisitos para adicionar um novo contato
	boolean atualizarContato(String telefone, String nome);
	
	//Remove o contato desse telefone
	boolean removerContato(String telefone);
	
	//devolve todos os telefones da lista
	List<IContato> getContatos();
	
	//Dado o nome de um contato retorne a lista de telefones
	//que ele possui. Caso o contato não exista, retorne null.
	List<String> getTelefones(String contato);

	
}
