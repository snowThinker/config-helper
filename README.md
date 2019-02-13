###config-helper

支持读取jar包内的配置文件

用法

~~~java
PropertiesConfiguration propsConfig = PropertyHelper.getInstance("test1.properties", "test2.properties");
String test1String = propsConfig.getString("test1.string");
Integer test1Integer = propsConfig.getInteger("test1.integer", null);
~~~