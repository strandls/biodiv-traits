/**
 * 
 */
package com.strandls.traits.services;

import java.util.List;

import com.strandls.traits.pojo.FactValuePair;

/**
 * @author Abhishek Rudra
 *
 */
public interface TraitsServices {
	
	public List<FactValuePair> getFacts(Long id);
	
	public FactValuePair getFactIbp(Long id);

}
