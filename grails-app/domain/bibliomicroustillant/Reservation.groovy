package bibliomicroustillant

class Reservation {
	String code
	Date date
	
	static hasMany = [
		livres: Livre]

    static constraints = {
		code blank: false
		date blank: false
    }
	
	String toString() {
		code
	}
}
