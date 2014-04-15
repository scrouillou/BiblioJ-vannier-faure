package bibliomicroustillant

class PanierController {
	
	PanierService panierService
	
	def show() {
		def data = []
		
		panierService.contenu.each {
			data.add(
				id: it.key,
				livre: Livre.get(it.key),
				quantite: it.value)
		}
		[contenu: data]
	}

	def ajouter() {
		panierService.ajouter(params.livre.toInteger())
		rediriger()
	}
	
	def enlever() {
		panierService.enlever(params.livre.toInteger())
		rediriger()
	}
	
	def supprimer() {
		panierService.supprimer(params.livre.toInteger())
		rediriger()
	} 
	
	def vider() {
		panierService.vider();
		rediriger()
	}
	
	private def rediriger() {
		redirect(uri: request.getHeader('referer'))
	}
}
