package dao;

import domain.SubInvoice;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface SubInvoiceDAO {

    SubInvoice getSubInvoice(String invoiceNumber) throws PersistenceException;

    List<SubInvoice> getAllSubInvoices() throws PersistenceException;

    SubInvoice updateSubInvoice(SubInvoice invoice) throws PersistenceException;

    void removeSubInvoice(String invoiceNumber) throws PersistenceException;

    SubInvoice insertSubInvoice(SubInvoice invoice) throws PersistenceException;

}
