package dao;

import domain.SubInvoice;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface SubInvoiceDAO {

    SubInvoice getSubInvoice(Long invoiceNumber) throws PersistenceException;

    List<SubInvoice> getAllSubInvoices() throws PersistenceException;

    SubInvoice updateSubInvoice(SubInvoice invoice) throws PersistenceException;

    void removeSubInvoice(Long invoiceNumber) throws PersistenceException;

    SubInvoice insertSubInvoice(SubInvoice invoice) throws PersistenceException;

}
