import {Injectable} from '@angular/core';
import {Road} from '../road';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class RoadService {

  private apiUri = 'http://localhost:8080/Java_Backend/api/';

  constructor(private http: HttpClient) {
  }

  getAllRoads(): Observable<Road[]> {
    const url = `${this.apiUri}roads`;
    return this.http.get(url).map(res => res as Road[]);
  }

  updateRoad(road: Road): Observable<Road> {
    return this.http.put<Road>(this.apiUri, road, httpOptions);
  }

  insertRoad(newRoad: Road): Observable<Road> {
    return this.http.post<Road>(this.apiUri, newRoad, httpOptions);
  }
}
