<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastramento de Usuários</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Usuários</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action="/usuario/incluir" method="post">
	    <div class="mb-3 mt-3">
	    
	   	  <label>Acesso:</label>
			<select class="form-control" name="acesso">
				<c:forEach var="r" items="${roles}">
					<option value="${r.id}">${r.nome}</option>
				</c:forEach>
			</select>
			
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o nome do usuário" 
	      		name="nome" value="${usuario.nome}">
	      		
	      <label>Email:</label>
	      <input type="text" class="form-control" placeholder="Entre com o email do usuário" 
	      		name="email" value="${usuario.email}">
	      
	      <label>Senha:</label>
	      <input type="text" class="form-control" placeholder="Entre com a senha do usuário" 
	      		name="senha" value="${usuario.senha}">
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	  
	</div>

</body>
</html>