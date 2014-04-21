<%@ page import="bibliomicroustillant.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Recherche</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		
		
		<div id="list-livre" class="content scaffold-list" role="main">
			<h1>Recherche</h1>
			
			<form name="input" action="index" method="get" style="text-align:center;">
				<label for="auteur">Auteur
				<input type="text" id="auteur" name="auteur" value="${auteur }"/></label>
				<br/>
				<label for="titre">Titre
				<input type="text" id="titre" name="titre" value="${titre }"/></label>
				<br/>
				<label for="type">Type
					<select id="type" name="type">
						<g:each in="${ types }" var="t">
							<option <g:if test="${type == t}"></g:if>>${ t }</option>
						</g:each> 
					</select></label>
				<br/>
				<input type="submit" value="Rechercher" />
			</form>
			
			<g:if test="${resultats.size() != 0}">
			<h1>Résultats</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="auteurs" title="${message(code: 'livre.auteurs.label', default: 'Auteurs')}" />
					
						<g:sortableColumn property="nbExemplairesDispo" title="${message(code: 'livre.nbExemplairesDispo.label', default: 'Exemplaires')}" />
					
						<th><g:message code="livre.type.label" default="Type" /></th>
						
						<th>Panier</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${resultats}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="livre" action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
					
						<td>
							<g:each in="${livreInstance.auteurs}" var="auteur">
								<g:link controller="auteur" action="show" id="${auteur.id}">
									${auteur}
								</g:link>
							</g:each>
						</td>
					
						<td>${fieldValue(bean: livreInstance, field: "nbExemplairesDispo")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "type")}</td>
						
						<td><a href="${createLink(
							controller: 'panier',
							action: 'ajouter',
							params: [ livre: livreInstance.id] )}">Ajouter</a></td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${nbResultats}" params="${[titre: params.titre, auteur: params.auteur, type: params.type] }" />
			</div>
			</g:if>
			<g:else>
				<h1>Aucun résultat</h1>
			</g:else>
		</div>
	</body>
</html>
