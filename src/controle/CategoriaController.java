package controle;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Categoria;


public class CategoriaController extends ControladorMaster<Categoria>{
    public List localizar(){
        EntityManager em = getEM();
        List<Categoria> categoria = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Categoria c");
            categoria = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao Listar Categorias de Produtos: " +  e);
        }finally{
            em.close();
        }
        return categoria;
    }
    
    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Categoria> categoria = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            categoria = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return categoria;
    }

    public Categoria localizarPorCodigoBarras(String codBarras) {
        EntityManager em = getEM();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, codBarras);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Categoria não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return categoria;
    }
}
