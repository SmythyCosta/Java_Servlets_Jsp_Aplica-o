package br.com.smythycosta.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smythycosta.entidades.Usuario;
import br.com.smythycosta.jdbc.UsuarioDAO;


@WebServlet("/usucontroller.do")
public class UsuarioCoontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UsuarioCoontroller() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando get");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		PrintWriter saida = response.getWriter();
		saida.println(lista);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando post");
		//Recebe dados da tela
				String id =  request.getParameter("txtid");
				String nome =  request.getParameter("txtnome");
				String login =  request.getParameter("txtlogin");
				String senha =  request.getParameter("txtsenha");
				
		//cria objeto usuario e seta os valores vindos da tela
				Usuario usuario = new Usuario();	
				usuario.setNome(nome);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				//pede para o usuarioDAO cadatrar no banco de dados
				UsuarioDAO  usuarioDAO = new UsuarioDAO();
				usuarioDAO.cadastrar(usuario);
				
				//Saida ao Browser
				PrintWriter saida= response.getWriter();
				saida.print("Cadastrado com sucesso!");
				
	}

}
