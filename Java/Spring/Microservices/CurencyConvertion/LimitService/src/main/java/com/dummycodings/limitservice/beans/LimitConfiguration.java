package com.dummycodings.limitservice.beans;

import org.springframework.context.annotation.Configuration;

/**
 * @author KarthickRaj
 *
 */

public class LimitConfiguration {
	private int minimum;
	private int maximum;

	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	

	public LimitConfiguration() {
		super();
	}


	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
