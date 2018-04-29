package controle;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.EntidadeBase;

public class ControladorMaster<T extends EntidadeBase> {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PadariaPU");
        return factory.createEntityManager();
    }

    public T salvar(T t) throws Exception {
        EntityManager em = getEM();

        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);  // executa o insert
            } else {
                if (!em.contains(t)) {  // se vc não conhece a entidade
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao atualizar");
                    }
                }
                t = em.merge(t); // executa o update
            }
            em.getTransaction().commit();
            
        } finally {
            em.close();
            
        }
        return t;
        
    }

    public void remover(Class<T> clazz, Integer id) {
        EntityManager em = getEM();
        T t = em.find(clazz, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T consultarPorId(Class<T> clazz, Integer id) {
        EntityManager em = getEM();
        T t = null;
        try {
            t = em.find(clazz, id); // aqui vc passa a classe que vc quer que busca 
        } finally {
            em.close();
        }
        return t;
    }

}