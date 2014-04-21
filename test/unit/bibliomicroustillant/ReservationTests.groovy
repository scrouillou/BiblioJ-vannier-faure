package bibliomicroustillant



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reservation)
class ReservationTests {

	void testCreation() {
		Reservation res = new Reservation( code : "1", dateReservation : new Date("14/04/2014") )
		assert res != null
	}

	void testCreationBlank() {
		Reservation res = new Reservation( code : "", dateReservation: "" )
		assert res != null
		assert res.save() == null
	}

	void testToString() {
		Reservation res = new Reservation( code : "1", dateReservation : new Date("14/04/2014") )
		println res.toString()
		assert res.toString() == "1"
	}
}