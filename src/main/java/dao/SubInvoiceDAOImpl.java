package dao;

import domain.SubInvoice;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class SubInvoiceDAOImpl implements SubInvoiceDAO {

    @PersistenceContext(name = "groep4.ptt_PU")
    EntityManager em;

    @Override
    public List<SubInvoice> getSubInvoice(String invoiceNumber) throws PersistenceException {
        return em.createNamedQuery("SubInvoice.findByInvoiceNumber").setParameter("invoiceNumber", invoiceNumber).getResultList();
    }

    @Override
    public List<SubInvoice> getAllSubInvoices() throws PersistenceException {
        return em.createNamedQuery("SubInvoice.findAll").getResultList();
    }

    @Override
    public boolean updateSubInvoice(SubInvoice invoice) throws PersistenceException {
        em.merge(invoice);
        return true;
    }

    @Override
    public boolean removeSubInvoice(SubInvoice invoice) throws PersistenceException {
        em.remove(invoice);
        return true;
    }

    @Override
    public boolean insertSubInvoice(SubInvoice invoice) throws PersistenceException {
        em.persist(invoice);
        return true;
    }

}
