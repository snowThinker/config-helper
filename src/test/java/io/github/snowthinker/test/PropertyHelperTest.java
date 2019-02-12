package io.github.snowthinker.test;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.junit.Test;

import io.github.snowthinker.PropertyHelper;
import junit.framework.TestCase;

public class PropertyHelperTest extends TestCase {
	
	private PropertiesConfiguration propsConfig;

	@Test
	public void testLoad() {
		String test1String = propsConfig.getString("test1.string");
		Integer test1Integer = propsConfig.getInteger("test1.integer", null);
		
		String test2String = propsConfig.getString("test2.string");
		Integer test2Integer = propsConfig.getInteger("test2.integer", null);
		
		org.junit.Assert.assertEquals(test1String, test2String);
		org.junit.Assert.assertEquals(test1Integer, test2Integer);
	}

	@Override
	protected void setUp() throws Exception {
		propsConfig = PropertyHelper.getInstance("test1.properties", "test2.properties");
	}
}
