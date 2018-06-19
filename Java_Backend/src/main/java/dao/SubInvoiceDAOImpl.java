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

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public SubInvoice getSubInvoice(Long invoiceNumber) throws PersistenceException {
        SubInvoice invoice = (SubInvoice) em.createNamedQuery("SubInvoice.findByInvoiceNumber").setParameter("invoiceNumber", invoiceNumber).getSingleResult();
        if (invoice != null) {
            return invoice;
        }
        return new SubInvoice();
    }

    @Override
    public List<SubInvoice> getAllSubInvoices() throws PersistenceException {
        return em.createNamedQuery("SubInvoice.findAll").getResultList();
    }

    @Override
    public SubInvoice updateSubInvoice(SubInvoice invoice) throws PersistenceException {
        return em.merge(invoice);
    }

    @Override
    public void removeSubInvoice(Long invoiceNumber) throws PersistenceException {
        em.remove(em.find(SubInvoice.class, invoiceNumber));
    }

    @Override
    public SubInvoice insertSubInvoice(SubInvoice invoice) throws PersistenceException {
        em.persist(invoice);
        return invoice;
    }

    @Override
    public void flush() {
        em.flush();
    } 

    @Override
    public void truncate() {
        em.createNativeQuery("DELETE FROM SUBINVOICE").executeUpdate();
    }
}
