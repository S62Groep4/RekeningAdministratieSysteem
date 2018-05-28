import {Component, OnInit} from '@angular/core';
import {Invoice} from '../invoice';
import {InvoiceService} from '../services/invoice.service';

@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.css']
})
export class InvoicesComponent implements OnInit {

  model;
  selectedInvoice: Invoice = new Invoice(null, '', '', '', '', '');
  selectedInvoiceOwnerLink: string;
  invoices: Invoice[] = [];

  constructor(private invoiceService: InvoiceService) {
  }

  ngOnInit() {
    this.getInvoices();
  }

  getInvoices(): void {
    this.invoiceService.getAllInvoices().subscribe(res => this.invoices = res);
  }

  generateInvoices(): void {
    this.invoices = null;
    this.invoiceService.generateInvoices().subscribe(res => {
      this.getInvoices();
    });
  }

  searchInvoices(invoiceDate: string): void {
    // this.invoiceService.searchInvoices(invoiceDate).subscribe(res => this.invoices = res);
  }

  clearCalendar(): void {
    this.model = '';
  }

  onItemClick(invoice: Invoice) {
    if (this.selectedInvoice === invoice) {
      this.selectedInvoice = new Invoice(null, '', '', '', '', '');
    } else {
      this.selectedInvoice = invoice;
      this.selectedInvoiceOwnerLink = invoice.ownerUri.substring(invoice.ownerUri.lastIndexOf('/'));
    }
  }
}
