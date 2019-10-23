/**
 * 
 */
package com.strandls.traits.pojo;

import java.util.List;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsValuePair {

	private Traits traits;
	private List<TraitsValue> values;

	/**
	 * @param traits
	 * @param values
	 */
	public TraitsValuePair(Traits traits, List<TraitsValue> values) {
		super();
		this.traits = traits;
		this.values = values;
	}

	public Traits getTraits() {
		return traits;
	}

	public void setTraits(Traits traits) {
		this.traits = traits;
	}

	public List<TraitsValue> getValues() {
		return values;
	}

	public void setValues(List<TraitsValue> values) {
		this.values = values;
	}

}
