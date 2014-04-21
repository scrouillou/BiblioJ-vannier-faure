package bibliomicroustillant



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Auteur)
class AuteurTests {

   void testCreation() {
		Auteur auteur = new Auteur( nom : "Vian", prenom: "Boris" )
		assert auteur != null
		assert auteur.save() != null
    }

	void testCreationBlank() {
		Auteur auteur = new Auteur( nom : "", prenom: "" )
		assert auteur != null
		assert auteur.save() == null
	}

	void testCreationPrenomBlankable() {
		Auteur auteur = new Auteur( nom : "Vian")
		assert auteur != null
		assert auteur.save() != null
	}

	void testToString() {
		Auteur auteur = new Auteur( nom : "Vian", prenom: "Boris" )
		assert auteur.toString() == "Boris Vian"
	}

	void testToStringNom() {
		Auteur auteur = new Auteur( nom : "Vian" )
		assert auteur.toString() == "Vian"
	}
}