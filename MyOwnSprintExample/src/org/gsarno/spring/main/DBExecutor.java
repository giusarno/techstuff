package org.gsarno.spring.main;

import java.util.List;

import org.gsarno.spring.db.DbAccess;
import org.gsarno.spring.db.dao.Person;

public class DBExecutor
{
    DbAccess dao = null;

    public void setDbaccess(DbAccess access)
    {
        dao= access;
    }
    
    public void start()
    {
        System.out.println("START:");
        dao.drop();
        System.out.println("DROP:");

        dao.create();
        dao.insert("Giuseppe", "Sarno");
        dao.insert("Pippo", "Franco");
        dao.insert("Roberto", "Pippo");
        dao.insert("Spider", "Man");
        System.out.println("Now select and list all persons");
        List<Person> list = dao.selectAll();
        for (Person myPerson : list) {
          System.out.print(myPerson.getFirstName() + " ");
          System.out.println(myPerson.getLastName());
        }
        System.out
            .println("Now select and list all persons with have the firstname Giuseppe and lastname Sarno");
        list = dao.select("Giuseppe", "Sarno");
        for (Person myPerson : list) {
          System.out.print(myPerson.getFirstName() + " ");
          System.out.println(myPerson.getLastName());
        }

        // Clean-up
        dao.deleteAll();
        dao.drop();

    }
    
}
