
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import hashproject.exception.FullArrayException;
import hashproject.exception.NotFoundException;
import hashproject.hp.Hash;

public class MySteps extends Steps{
	
	private Hash hash;
	private Exception exc = null;
	
	@Given("create new hash array")
	public void createNewHash() {
		hash = new Hash();
		exc = null;
	}
	
	@When("add $x to hash array")
	public void addXToHashArray(Integer x) {
		hash.addInt(x);
	}
	
	@Then("add $x to hash array throws exception")
	public void addXToHashArrayThrowException(Integer x) {
		try {
			hash.addInt(x);
		} catch (FullArrayException exc) {
			assertTrue(true);
		}
	}
	
	@Then("try add null to hash array throws exception") 
	public void addNullToHashArrayThrowsException() {
		try {
			hash.addInt(null);
		} catch (NullPointerException exc) {
			assertTrue(true);
		}
	}
	
	@Then("try delete null from hash array throws exception") 
	public void deleteNullToHashArrayThrowsException() {
		try {
			hash.delInt(null);
		} catch (NullPointerException exc) {
			assertTrue(true);
		}
	}
	
	
	
	@Then("hash array contains $x")
	public void hashArrayContainsX(Integer x) {
		assertThat(hash.searchInt(x), is(equalTo(true)));
	}
	
	@When("delete $x from hash array")
	public void deleteXFromHashArray(Integer x) {
		hash.delInt(x);
	}
	
	@Then("delete $x from hash array return false")
	public void deleteXFromHashArrayThrowException(Integer x) {
		assertEquals(hash.delInt(x), false);
	}
	
	@Then("try search null in hash array throws exception")
	public void searchNullInHashArrayThrowException() {
		try {
			hash.searchInt(null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	@Then("hash array do not contain $x") 
	public void hashArrayDoNotContainX(Integer x) {
		assertThat(hash.searchInt(x), is(equalTo(false)));
	}
}