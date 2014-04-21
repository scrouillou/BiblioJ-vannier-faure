package bibliomicroustillant

class PanierController {
	
	PanierService panierService
	
	def show() {
		def data = []
		
		panierService.contenu.each {
			data.add(
				id: it,
				livre: Livre.get( it ) )
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
	
	def commander() {
		if ( panierService.contenu.isEmpty() ) {
			redirect(uri: "/")
		}
		
		List<Integer> livresIndisponibles = new ArrayList<>()
		List<Integer> livresACommander = new ArrayList<>()
		
		panierService.contenu.each {
			def livre = Livre.get(it)
			if(livre.nbExemplairesDispo == 0 ) {
				livresIndisponibles.add( livre )
			}
			else {
				livresACommander.add( livre )
			}
		}
		
		if( livresIndisponibles.isEmpty() ) {
			def reserv = panierService.commander()
			panierService.vider()
			flash.message = "Votre réservation a bien été créée."
			redirect controller: "Reservation", action: "show", id: reserv.id
		}
		else if( livresACommander.isEmpty() ) {
			flash.message = "Aucun livre disponible, désolé."
			vider()
		}
		else {
			[
				uri: request.getHeader('referer'),
				aCommander: livresACommander,
				indisponibles: livresIndisponibles]
		}
	}
	
	def commanderQuandMeme() {
		def reserv = panierService.commander()
		panierService.vider()
		flash.message = "Votre réservation a bien été créée."
		redirect controller: "Reservation", action: "show", id: reserv.id
	}
	
	private def rediriger() {
		redirect(uri: request.getHeader('referer'))
	}
}
