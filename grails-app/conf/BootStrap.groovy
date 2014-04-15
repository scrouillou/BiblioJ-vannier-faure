import bibliomicroustillant.Auteur
import bibliomicroustillant.Livre
import bibliomicroustillant.TypeDocument;

class BootStrap {

	def init = { servletContext ->
		def csv = new File("bestBooks.csv")
		def firstLine = true
		csv.splitEachLine(';') { row ->
			if(firstLine) {
				firstLine = false
			}
			else {
				//TYPE DE DOCUMENT
				TypeDocument.findByIntitule(row[1]) ?: new TypeDocument(intitule: row[1]).save()
				
				// LIVRE
				def livre = new Livre(
						type: TypeDocument.findByIntitule(row[1]),
						titre: row[3],
						nbExemplairesDispo: 10,
						nbExemplaires: 10)
				
				livre.save(flush:true)
				// AUTEUR
				if( row[4] ) {
					def rawAuteur = row[4].tokenize(", ");
					def prenomAuteur = rawAuteur[1]
					def nomAuteur = rawAuteur[0]
					def auteur = Auteur.findByNom(nomAuteur) ?: new Auteur( nom: nomAuteur, prenom: prenomAuteur )
					
					
					auteur.save()
					
					println auteur.id + ":" + auteur
					
					auteur.addToLivres(livre)
					
					auteur.save()
				}
				
				livre.save()
			}
		}
	}

	def destroy = {
	}
}
