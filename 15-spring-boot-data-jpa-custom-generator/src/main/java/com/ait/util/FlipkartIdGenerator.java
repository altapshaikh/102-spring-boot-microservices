package com.ait.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class FlipkartIdGenerator implements IdentifierGenerator{
private static final String PREFIX= "flipkart_";
private static  Long COUNTER= 100l;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		return PREFIX+(COUNTER++);
	}

}
