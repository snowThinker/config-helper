package org.snowman.ch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration2.PropertiesConfiguration;

/**
 * <p>Property 配置文件工具类
 * @author Andrew
 *
 */
public class PropertyHelper  {
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PropertyHelper.class);

	private PropertyHelper() {}
	
	/**
	 * <p>获取 配置文件实例
	 * @return PropertiesConfiguration
	 */
	public static synchronized PropertiesConfiguration getInstance(String...fileName) {
		PropertiesConfiguration config = new PropertiesConfiguration();
		
		InputStream inputStream  = null;
		
		/*logger.info("Current path: {}", path);
		
		String unitTestPattern = "/test-classes/" + fileName;
		if(null != path && path.endsWith(unitTestPattern)) {
			String replacePattern = "/classes/" + fileName;
			path = path.replace(unitTestPattern, replacePattern);
		}*/
		
		try {
			for(String file : fileName) {
				inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
				
				Properties properties = new Properties();
				properties.load(inputStream);
				properties.keySet().forEach(key -> {
					config.addProperty((String) key, (Object)properties.get(key));
				});
			}
		} catch (Exception e) {
			logger.error("Load properties file error", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if(null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}

		return config;
	}
}
