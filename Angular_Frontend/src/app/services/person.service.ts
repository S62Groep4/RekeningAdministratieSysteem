import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../person';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../environments/environment';

@Injectable()
export class PersonService {

  private apiUri = environment.apiBaseUrl + '/persons';

  constructor(private http: HttpClient) {
  }

  getPerson(id: number): Observable<Person> {
    const url = `${this.apiUri}/${id}`;
    return this.http.get(url).map(res => res as Person);
  }
}
