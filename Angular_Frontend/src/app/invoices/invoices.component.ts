import {Component, OnInit} from '@angular/core';
import {Invoice} from '../invoice';
import {InvoiceService} from '../services/invoice.service';

@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.css']
})
export class InvoicesComponent implements OnInit {

  selectedInvoice: Invoice = new Invoice(null, '', '', '', '');
  invoices: Invoice[] = [];

  constructor(private invoiceService: InvoiceService) {
  }

  ngOnInit() {
    this.getInvoices();
  }

  getInvoices(): void {
    this.invoiceService.getAllInvoices().subscribe(res => this.invoices = res);
  }

  onItemClick(invoice: Invoice) {
    if (this.selectedInvoice === invoice) {
      this.selectedInvoice = new Invoice(null, '', '', '', '');
    } else {
      this.selectedInvoice = invoice;
    }
  }
}
