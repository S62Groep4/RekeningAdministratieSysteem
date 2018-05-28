import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Invoice} from '../invoice';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class InvoiceService {

  private apiUri = 'http://localhost:8080/Java_Backend/api/subinvoices';

  constructor(private http: HttpClient) {
  }

  getAllInvoices(): Observable<Invoice[]> {
    return this.http.get(this.apiUri).map(res => res as Invoice[]);
  }

  generateInvoices(): Observable<Invoice[]> {
    // TO DO define url to generate Invoices
    const url = `${this.apiUri}/generate`;
    return this.http.get(url).map(res => res as Invoice[]);
  }
}
