package controle;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Produto;


public class ProdutoController extends ControladorMaster<Produto>{
    public List localizar(){
        EntityManager em = getEM();
        List<Produto> produto = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Produto p");
            produto = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao Listar Produtos: " +  e);
        }finally{
            em.close();
        }
        return produto;
    }
    
    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Produto> produto = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            produto = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return produto;
    }

    public Produto localizarPorCpf(String codBarras) {
        EntityManager em = getEM();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, codBarras);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return produto;
    }
}
