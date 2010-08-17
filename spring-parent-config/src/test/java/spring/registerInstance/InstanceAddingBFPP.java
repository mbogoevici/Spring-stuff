package spring.registerInstance;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class InstanceAddingBFPP implements BeanFactoryPostProcessor {

	/* lets Spring do the instantiation */
	/*public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Service.class);
		builder.addConstructorArgValue("setup by extension");
		((BeanDefinitionRegistry)beanFactory).registerBeanDefinition("someBean", builder.getBeanDefinition());
	}*/
	
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder
				.rootBeanDefinition(CustomFactoryBean.class);
		builder.addConstructorArgValue(new Service("setup by extension"));
		builder.addConstructorArgValue(Service.class);
		((BeanDefinitionRegistry) beanFactory).registerBeanDefinition(
				"someBean", builder.getBeanDefinition());
	}
	
}
