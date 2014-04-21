<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Commander</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div style="margin: 50px;">
			<h3>Liste des livres disponibles:</h3>
			<ul>
				<g:each in="${ aCommander }">
					<li>
						${it }
					</li>
				</g:each>
			</ul> 
			<br/> 
			<br/> 
			<br/>
			<h3>Liste des livres indisponibles:</h3>
			<ul>
				<g:each in="${ indisponibles }">
					<li>
						${it }
					</li>
				</g:each>
			</ul> 
			 
			<br/> 
			<br/> 
			<br/>
			<h4><b>Tout les livres ne sont pas disponibles.</b></h4>
			<p>
				<br/>
				<a href="${createLink(action: "commanderQuandMeme")}">Commander les livres disponibles</a>
				<br/>
				<a href="${ uri }">Modifier ma commande</a>
			</p>
		</div>
</body>
</html>