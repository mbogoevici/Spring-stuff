package spring.parent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.Assert;

/**
 * Created by IntelliJ IDEA.
 * User: marius
 * Date: 30-Mar-2010
 * Time: 6:22:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParentBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
   private BeanFactoryLocator beanFactoryLocator;

   private String beanFactoryName;

   public void setBeanFactoryLocator(BeanFactoryLocator beanFactoryLocator)
   {
      this.beanFactoryLocator = beanFactoryLocator;
   }


   public void setBeanFactoryName(String beanFactoryName)
   {
      this.beanFactoryName = beanFactoryName;
   }

   public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException
   {
      Assert.isNull(configurableListableBeanFactory, "Cannot set parent");

      configurableListableBeanFactory
            .setParentBeanFactory(beanFactoryLocator.useBeanFactory(beanFactoryName).getFactory());  
   }
}
