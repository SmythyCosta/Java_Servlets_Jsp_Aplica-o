package br.com.smythycosta.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.smythycosta.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Usuario usuario){
		//sql que deve cadastrar o usuario no banco
		String sql = "INSERT INTO USUARIO(nome, login, senha) values(?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Usuario usuario){
		//sql que deve alterar o usuario no banco
		String sql = "UPDATE USUARIO SET nome=?, login=?, senha=? WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			
			System.out.println("Alterado com sucesso! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void excluir(Usuario usuario){
		//sql que deve EXCLUIR o usuario no banco
		String sql = "DELETE FROM USUARIO WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			
			
			preparador.execute();
			preparador.close();
			
			
			System.out.println("eXCLUIDO com sucesso! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	

	public List<Usuario> buscarTodos(){
		//Monta sQl
		String sql = "SELECT * FROM USUARIO";
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		//Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);		
				
			ResultSet resultado = preparador.executeQuery();
			
			
			
			while(resultado.next()){
				
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("id")); // valor da coluna id
				usu.setNome(resultado.getString("nome")); //valor da caluna nome
				usu.setLogin(resultado.getString("login")); //valor da caluna login
				usu.setSenha(resultado.getString("senha")); //valor da caluna senha
				
				lista.add(usu);
			}
			
			
			preparador.close();
			
			System.out.println("Lista com sucesso!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return lista;
	
	}
	
	public Usuario autenticar(Usuario usuario){
		String sql =  "SELECT * FROM Usuario WHERE login = ? and senha = ?";
		Usuario usuarioRetorno=null ;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){ // se foi para proximo
				
				usuarioRetorno =  new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
				
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return usuarioRetorno;
			
	}
	
	public List<Usuario> buscarPorNome(String nome){
		String sql =  "SELECT * FROM Usuario WHERE nome like ?";
		List<Usuario> lista =  new ArrayList<Usuario>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){ // se foi para proximo
				
				Usuario usuario =  new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
			}		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
		
	}

	public Usuario buscarPorId(Integer id){
		String sql = "SELECT * FROM USUARIO WHERE ID=?";
		Usuario usuario=null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setLogin(resultado.getString("Login"));
				usuario.setSenha(resultado.getString("Senha"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return usuario;
	
	}
	
	public Boolean existeUsuario(Usuario usuario){

		String sql = "SELECT * FROM USUARIO WHERE login = ? and senha = ?";
		
		boolean ret=false;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			return resultado.next();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	

		return false;
	}

}

         