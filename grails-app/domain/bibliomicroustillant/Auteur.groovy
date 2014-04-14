package bibliomicroustillant

class Auteur {
	String nom
	String prenom
	
	static hasMany = [
		livres: Livre]
	
	static belongsTo = Livre

    static constraints = {
		nom blank: false
    }
	
	String toString() {
		if(prenom.isEmpty()) {
			nom
		}
		else {
			prenom + " " + nom
		}
	}
}
