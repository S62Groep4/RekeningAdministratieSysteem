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

    boolean updateSubInvoice(SubInvoice invoice) throws PersistenceException;

    boolean removeSubInvoice(SubInvoice invoice) throws PersistenceException;

    boolean insertSubInvoice(SubInvoice invoice) throws PersistenceException;

}
