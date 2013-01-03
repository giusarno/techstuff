package org.gsarno.spring.main;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
 

public class SpringMain
{


    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception
    {
        //FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("gsarnoSpringConfig.xml");
        
        XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("gsarnoSpringConfig.xml"));
        /* remove line below to use configurer.setLocation */
        URL propurl = (new File("gsarnoSpringConfig.properties")).toURI().toURL();
        InputStream in = propurl.openStream();
        Properties properties = new Properties();
        properties.load(in);
       
        Set<Object> keys = properties.keySet();
        for (Object p : keys)
        {
            System.out.println("KEY:"+p+" VALUE:"+properties.getProperty((String) p));
        }
        
        /* end of line to be removed*/
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();     
        
        /*
         * alternative to setProperties (NOTE: remove lines above)
         * configurer.setLocation(new FileSystemResource("gsarnoSpringConfig.properties"));
         */
        configurer.setProperties(properties);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.postProcessBeanFactory(factory);
        
        //Without getBean the init-method is not invoked (LAZY LOADING)
        DBExecutor bean = (DBExecutor) factory.getBean("main");

        
       // bring in some property values from a Properties file

       // now actually do the replacement
       /* context.addBeanFactoryPostProcessor(configurer);     
          context.refresh();   
          context.close();
        */        
    }

}
