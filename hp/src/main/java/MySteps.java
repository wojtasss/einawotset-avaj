import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import org.junit.Test;
import static org.junit.Assert.*;

import hashproject.hp.Hash;

public class MySteps extends Steps{
	
	private Hash hash;
	
	@Given("create new hash array")
	public void createNewHash() {
		hash = new Hash();
	}
	
	@When("add $x to hash array")
	public void addXToHashArray(Integer x) {
		hash.addInt(x);
	}
	
	@Then("hash array contains $x")
	public void hashArrayContainsX(Integer x) {
		assertEquals(true, hash.searchInt(x));
	}
}