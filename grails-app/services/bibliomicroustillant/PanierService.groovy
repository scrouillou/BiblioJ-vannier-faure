package bibliomicroustillant

import java.util.Map;

class PanierService {
	static scope = "session"
	
	Map<Integer, Integer> contenu = new HashMap<>()

	void ajouter(Integer livreId) {
		def nouvelleQuantite = Math.min(
			(contenu.get(livreId)?:0) + 1,
			Livre.get(livreId).nbExemplairesDispo)
		
		contenu.put(livreId, nouvelleQuantite)
	}

	void enlever(Integer livreId) {
		def nouvelleQuantite = (contenu.get(livreId)?:0) - 1
		
		if(nouvelleQuantite > 0) {
			contenu.put(livreId, nouvelleQuantite)
		}
		else {
			supprimer(livreId)
		}
	}

	void supprimer(Integer livreId) {
		contenu.remove(livreId)
	}

	void vider() {
		contenu.clear()
	}

}
