import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Invoice} from '../invoice';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class InvoiceService {

  private apiUri = environment.apiBaseUrl + '/subinvoices';

  constructor(private http: HttpClient) {
  }

  getAllInvoices(): Observable<Invoice[]> {
    return this.http.get(this.apiUri).map(res => res as Invoice[]);
  }

  generateInvoices(): Observable<Invoice[]> {
    const url = `${this.apiUri}/generate`;
    return this.http.get(url).map(res => res as Invoice[]);
  }
}
