package bibliomicroustillant



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Livre)
@Mock([Livre, Reservation])
class LivreTests {

     void testCreation() {
		TypeDocument type = new TypeDocument( intitule : "Type de test" )
		Livre livre = new Livre( titre : "LivreTest", type : type, nombreExemplaires : 7, nombreExemplairesDisponibles : 3 )
		assert livre != null
		assert livre.save() != null
    }

	void testCreationBlank() {
		TypeDocument type = new TypeDocument( intitule : "Type de test" )
		Livre livre = new Livre( titre : "", type : "", nombreExemplaires : "", nombreExemplairesDisponibles :"" )

		assert livre != null
		assert livre.save() == null
	}

	void testToString() {
		TypeDocument type = new TypeDocument( intitule : "Type de test" )
		Livre livre = new Livre( titre : "LivreTest", type : type, nombreExemplaires : 5, nombreExemplairesDisponibles : 5 )

		assert livre.toString() == "LivreTest"
	}
}
