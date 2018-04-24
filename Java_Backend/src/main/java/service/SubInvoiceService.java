package service;

import dao.SubInvoiceDAO;
import domain.SubInvoice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class SubInvoiceService {

    @Inject
    SubInvoiceDAO subinvoiceDao;

    private static final Logger LOGGER = Logger.getLogger(SubInvoiceService.class.getName());

    public SubInvoiceService() {
    }

    public SubInvoice getSubInvoice(String invoiceNumber) throws PersistenceException {
        try {
            return subinvoiceDao.getSubInvoice(invoiceNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<SubInvoice> getAllSubInvoices() throws PersistenceException {
        try {
            return subinvoiceDao.getAllSubInvoices();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllSubInvoices operation; {0}", pe.getMessage());
            return null;
        }
    }

    public SubInvoice updateSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.updateSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeSubInvoice(String invoiceNumber) throws PersistenceException {
        try {
            subinvoiceDao.removeSubInvoice(invoiceNumber);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeSubInvoice operation; {0}", pe.getMessage());
        }
    }

    public SubInvoice insertSubInvoice(SubInvoice invoice) throws PersistenceException {
        try {
            return subinvoiceDao.insertSubInvoice(invoice);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertSubInvoice operation; {0}", pe.getMessage());
            return null;
        }
    }
}
