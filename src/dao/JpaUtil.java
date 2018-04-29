/*
 * Classe com variavel e metodos estáticos para conexão via JPA ao banco de dados 
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cleiton
 */
public class JpaUtil {
    
    private static EntityManagerFactory factory;
    
    static{
        factory = Persistence.createEntityManagerFactory("PadariaPU");
    }
    
    public static EntityManager getEm(){
        return factory.createEntityManager();
    }
    
    public static void close(){
        factory.close();
    }
    
}
