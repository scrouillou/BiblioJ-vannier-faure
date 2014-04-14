package bibliomicroustillant

class Reservation {
	String code
	Date date
	
	static hasMany = [
		livres: Livre]

    static constraints = {
    }
	
	String toStirng() {
		code + "[" + date + "]"
	}
}
