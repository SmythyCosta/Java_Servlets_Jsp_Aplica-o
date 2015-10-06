package br.com.smythycosta.teste;

import java.util.List;

import br.com.smythycosta.entidades.Usuario;
import br.com.smythycosta.jdbc.UsuarioDAO;

public class TestaUsuarioDAO {
	public static void main(String[] args){
		 
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		 //testBuscarTodos();
		//testAutenticar();
		testeBuscarPorId();
	}


	private static void testeCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Amaral Filho");
		usu.setLogin("amanral");
		usu.setSenha("brasil03");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}

	private static void testeAlterar() {
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("Amaral 02");
		usu.setLogin("amaral 2");
		usu.setSenha("brasil03");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
	}
	
	private static void testeExcluir() {
		Usuario usu = new Usuario();
		usu.setId(2);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
	}


	private static void testBuscarTodos(){
		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> listaResultado = usuDao.buscarTodos();
		
	
		for(Usuario u: listaResultado){
			System.out.println(u.getId() +" "+ u.getNome() + " "+ u.getLogin() + " "+u.getSenha());
		}
	}
	
	public static void testAutenticar(){
		Usuario usuario =  new Usuario();
		usuario.setLogin("jbrasil");
		usuario.setSenha("ju123");
		
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		System.out.println(usuarioDAO.autenticar(usuario));
		
	}


	//METODO QUE ESTA DANDO ERRO
	
	public static void testeBuscarPorId(){
		
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		//System.out.println(usuarioDAO.buscarPorId(1));
		
		Usuario usuRetorno = usuarioDAO.buscarPorId(3);
		if(usuRetorno!=null){
			System.out.println("nome:"+usuRetorno.getNome());
		}
	}


}