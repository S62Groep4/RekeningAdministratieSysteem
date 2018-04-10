package interfaces;

public interface ISubInvoice {

    //Primary key for invoiceNumbers.
    String getInvoiceNumber();

    //Country where the SubInvoice has to be payed to.
    String getCountry();

    //Is this sub invoice payed already/
    boolean getPaymentStatus();

    //Date of the subinvoice
    String getInvoiceDate();

    //Price calculated by the country where the subinvoice is made and where the user has driven.
    double getPrice();
}
