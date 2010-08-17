package spring.registerInstance;

import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean<T> implements FactoryBean<T> {

	private Class<T> clazz;
	
	private T instance;
	
	
	
	public CustomFactoryBean(T instance, Class<T> clazz) {
		super();
		this.instance = instance;
		this.clazz = clazz;
	}

	public T getObject() throws Exception {
		// TODO Auto-generated method stub
		return instance;
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return clazz;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
