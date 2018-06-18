import {Injectable} from '@angular/core';
import {Road} from '../road';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class RoadService {

  private apiUri = environment.apiBaseUrl + '/roads';

  constructor(private http: HttpClient) {
  }

  getAllRoads(): Observable<Road[]> {
    return this.http.get(this.apiUri).map(res => res as Road[]);
  }

  searchRoad(roadName: string): Observable<Road[]> {
    const url = `${this.apiUri}/${roadName}`;
    return this.http.get<Road[]>(url);
  }

  updateRoad(road: Road): Observable<Road> {
    return this.http.put<Road>(this.apiUri, road, httpOptions);
  }

  insertRoad(newRoad: Road): Observable<Road> {
    return this.http.post<Road>(this.apiUri, newRoad, httpOptions);
  }
}
