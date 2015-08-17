/**
 * 
 */
package com.manicure.keystone.event;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Barrie
 *
 */
public abstract class Event {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public String execute(Map<String, String> requestMap) {
		return null;
	}
}
