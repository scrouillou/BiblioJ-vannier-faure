package bibliomicroustillant

class Livre {
	String titre
	int nbExemplaires
	int nbExemplairesDispo
	
	TypeDocument type
	
	static hasMany = [
		auteurs: Auteur,
		reservations: Reservation]
	
	static belongsTo = Reservation

    static constraints = {
		titre blank: false
		nbExemplaires min:0
		nbExemplairesDispo min:0
		type nullable: true
    }
	
	static mapping = {
		auteurs lazy : false
	}
	
	String toString() {
		titre
	}
}
