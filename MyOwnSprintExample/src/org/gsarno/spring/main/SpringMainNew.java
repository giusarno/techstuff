package org.gsarno.spring.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

 

public class SpringMainNew
{


    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception
    {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("gsarnoSpringConfigNew.xml");
        
        //context.refresh();   
        //context.close();
                
    }

}
