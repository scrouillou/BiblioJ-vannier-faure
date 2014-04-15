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
				<input type="text" name="recherche" value="${champ }"/> <br />
		
				
				
		       <input type="checkbox" name="auteur" id="auteur" <g:if test="${chercherDansAuteur == true}">checked</g:if>/> 
		       <label for="auteur">Auteur</label>
					&nbsp;
		       <input type="checkbox" name="titre" id="titre" <g:if test="${chercherDansTitre == true}">checked</g:if>/> 
		       <label for="titre">Titre</label>
					&nbsp;
		       <input type="checkbox" name="type" id="type" <g:if test="${chercherDansType == true}">checked</g:if>/> 
		       <label for="type">Type de document</label>
					<br /> 
					
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
					
						<g:sortableColumn property="nbExemplaires" title="${message(code: 'livre.nbExemplaires.label', default: 'Nb Exemplaires')}" />
					
						<g:sortableColumn property="nbExemplairesDispo" title="${message(code: 'livre.nbExemplairesDispo.label', default: 'Nb Exemplaires Dispo')}" />
					
						<th><g:message code="livre.type.label" default="Type" /></th>
						
						<th>Panier</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${resultats}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="livre" action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: livreInstance, field: "nbExemplaires")}</td>
					
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
				<g:paginate total="${nbResultats}" params="${[titre: params.titre, auteur: params.auteur, type: params.type, recherche: params.recherche].findAll {it.value} }" />
			</div>
			</g:if>
			<g:else>
				<h1>Aucun résultat</h1>
			</g:else>
		</div>
	</body>
</html>
