<%@page import="br.com.smythycosta.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	
	<form action="usucontroller.do" method="post" >
	
		<label>ID:  </label>
		<input type="text" readonly="readonly"  name="txtid" value="" size="20"   /></br>
		
		
		<label> Nome:  </label>
		<input type="text"  name="txtnome" value="" size="20"  /></br>
		
		<label> Login:  </label>
		<input type="text" name="txtlogin" value="" size="20" /></br>
		
		<label> Senha:  </label>
		<input type="password" name="txtsenha" value="" maxlength="6" /></br>
	
	</br>
		<input type="submit" value="Salvar" />
	
	</form>



</body>
</html>