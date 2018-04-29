package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Cliente;


public class ClienteController extends ControladorMaster<Cliente> {
    
    public List localizar(){
        EntityManager em = getEM();
        List<Cliente> cliente = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Cliente c");
            cliente = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar a lista de Clientes: "+ e);
        }finally{
            em.close();
        }
        return cliente;
    }
    
    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Cliente> cliente = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            cliente = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente localizarPorCpf(String cpf) {
        EntityManager em = getEM();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, cpf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return cliente;
    }
    
}
