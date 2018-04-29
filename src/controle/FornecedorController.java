package controle;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Fornecedor;


public class FornecedorController extends ControladorMaster<Fornecedor>{
    public List localizar(){
        EntityManager em = getEM();
        List<Fornecedor> fornecedor = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select f from Fornecedor f");
            fornecedor = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao Listar fornecedores: " +  e);
        }finally{
            em.close();
        }
        return fornecedor;
    }
    
    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Fornecedor> fornecedor = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            fornecedor = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public Fornecedor localizarPorCpf(String cpf) {
        EntityManager em = getEM();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, cpf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return fornecedor;
    }
}
