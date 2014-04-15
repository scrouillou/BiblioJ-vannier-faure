package bibliomicroustillant

import org.bouncycastle.asn1.isismtt.x509.Restriction;

class RechercheController {

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		
		def chercherDansTitre = (params.titre == "on") ? true: false
		def chercherDansAuteur = (params.auteur == "on") ? true: false
		def chercherDansType = (params.type == "on") ? true: false
		def champ = params.recherche

		def resultats = Livre.createCriteria().list(params) {
			or {
				if(chercherDansType) {
					'in'("type", TypeDocument.findAllByIntituleLike("%" + champ + "%"))
				}
				if(chercherDansAuteur) {
					auteurs {
						like("nom", "%" + champ + "%")
					}
				}
				if(chercherDansTitre) {
					like("titre", "%"+champ+"%")
				}
			}
			order("titre","asc")
		}

		[
			resultats: resultats,
			nbResultats: resultats.totalCount,
			champ: champ,
			chercherDansAuteur: chercherDansAuteur,
			chercherDansTitre: chercherDansTitre,
			chercherDansType: chercherDansType]
	}
}
