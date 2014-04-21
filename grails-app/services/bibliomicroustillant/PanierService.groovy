package bibliomicroustillant

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

class PanierService {
	static scope = "session"
	
	List<Integer> contenu = new ArrayList<>()

	void ajouter(Integer livreId) {
		if( ! contenu.contains( livreId ) ) {
			contenu.add( livreId )
		}
	}

	void supprimer(Integer livreId) {
		contenu.remove( (Object) livreId )
	}

	void vider() {
		contenu.clear()
	}
	
	def commander() {
		Reservation reserv = new Reservation()
		reserv.code = Reservation.list().size() + 1
		reserv.date = new Date() + 1
		
		reserv.save()
		
		def livre
		contenu.each {
			livre = Livre.get( it )
			if(livre.nbExemplairesDispo > 0) {
				livre.addToReservations( reserv )
				livre.nbExemplairesDispo --
				livre.save()
			}
		}
		
		reserv.save()
		
		reserv
	}
}
