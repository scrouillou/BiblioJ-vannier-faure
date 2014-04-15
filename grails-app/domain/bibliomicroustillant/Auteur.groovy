package bibliomicroustillant

class Auteur {
	String nom
	String prenom
	
	static hasMany = [
		livres: Livre]
	
	static belongsTo = Livre

    static constraints = {
		nom blank: false
		prenom nullable: true
    }
	
	String toString() {
		if(prenom) {
			prenom + " " + nom
		}
		else {
			nom
		}
	}
}
