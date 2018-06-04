import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from '../person';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PersonService {

  private apiUri = 'http://localhost:8080/Java_Backend/api/persons';

  constructor(private http: HttpClient) {
  }

  getPerson(id: number): Observable<Person> {
    const url = `${this.apiUri}/${id}`
    return this.http.get(url).map(res => res as Person);
  }
}
