<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Cliente</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
        <!-- Container Principal -->
        <div id="main" class="container">
        <form action="EnviarEmailController" method="post">
            <h3 class="page-header">Visualizar Cliente #${cliente.id}</h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        ${cliente.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Email</strong>
                    </p>
                    <p>
                        ${cliente.email}
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Senha</strong>
                    </p>
                    <p>
                        ${cliente.senha}
                    </p>
                </div>
            </div>
                <div class="col-md-6">
                    <p><strong>Cidade</strong>
                    </p>
                    <p>
                        ${cliente.cidade}
                    </p>
                </div>
                
                <input type="hidden" name="id" value="${cliente.id }" />
                <div class="row">
	                <div class="form-group col-md-6">
	                    <label for="cidade">Destino ${cliente.id }</label>
	                    <input type="text" class="form-control" name="cidade2" id="cidade2"  placeholder="Opcional">
	                </div>
            	</div>
            	<hr/>
            	<div id="actions" class="row">
                <div class="col-md-12">
                    <a href="Login.do?acao=Enviar&id=${cliente.id}" class="btn btn-primary">Enviar</a>
                    <a href="Login.jsp" class="btn btn-default">Log Out</a>
                    <a href="Logado.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
            </form>
                <!--  <div class="col-md-6">
                    <p><strong>Destino</strong>
                    </p>
                    <p>
                        ${cliente.cidade2}
                    </p>
                </div>-->
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>