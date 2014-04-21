package bibliomicroustillant

import org.bouncycastle.asn1.isismtt.x509.Restriction;

class RechercheController {

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		
		def chercherDansTitre = (params.titre.isEmpty()) ? false: true
		def chercherDansAuteur = (params.auteur.isEmpty()) ? false: true
		def chercherDansType = (params.type.isEmpty()) ? false: true
		def champ = params.recherche

		def resultats = []

		if (chercherDansTitre || chercherDansAuteur || chercherDansType){
			resultats = Livre.createCriteria().list(params) {
				and {
					if(chercherDansType) {
						'in'("type", TypeDocument.findAllByIntituleLike("%" + params.type + "%"))
					}
					if(chercherDansAuteur) {
						auteurs {
							like("nom", "%" + params.auteur + "%")
						}
					}
					if(chercherDansTitre) {
						like("titre", "%" + params.titre + "%")
					}
				}
				order("titre","asc")
			}
		}

		[
			resultats: resultats,
			nbResultats: resultats.totalCount,
			auteur: params.auteur,
			titre: params.titre,
			type: params.type]
	}
}
