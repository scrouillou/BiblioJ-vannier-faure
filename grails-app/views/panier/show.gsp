<h1>Panier</h1>
<g:if test="${contenu.size == 0}">
	<h3>Votre panier est vide.</h3>
</g:if>
<g:else>
	<table>
		<tr>
			<th>Livre</th>
			<th>Quantité</th>
		</tr>
		<g:each in="${contenu }" var="ligne">
		<tr>
			<td>${ligne.livre }</td>
			<td>
				<a href="${createLink(
								controller: 'panier',
								action: 'enlever',
								params: [ livre: ligne.id ] )}">-</a>
				${ligne.quantite }
				<a href="${createLink(
								controller: 'panier',
								action: 'ajouter',
								params: [ livre: ligne.id ] )}">+</a>
			
				<a href="${createLink(
								controller: 'panier',
								action: 'supprimer',
								params: [ livre: ligne.id ] )}">\/</a>
			</td>
		</g:each>
	</table>
	<a href="${createLink(
				controller: 'panier',
				action: 'vider' )}">Vider le panier</a>
	<br/>
	<a href="">Commander</a>

</g:else>
