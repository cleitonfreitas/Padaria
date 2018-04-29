package controle;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Fichas;
import modelo.Produto;


public class FichaController extends ControladorMaster<Fichas>{
    public List localizar(){
        EntityManager em = getEM();
        List<Fichas> ficha = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select f from Fichas f");
            ficha = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao Listar as Fichas: " +  e);
        }finally{
            em.close();
        }
        return ficha;
    }
    
    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Fichas> ficha = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            ficha = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return ficha;
    }

    public Fichas localizarPorBarras(String codBarras) {
        EntityManager em = getEM();
        Fichas ficha = null;
        try {
            ficha = em.find(Fichas.class, codBarras);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha não encontrada!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return ficha;
    }
}
