import {Component, OnInit} from '@angular/core';
import {Road} from '../road';
import {RoadService} from '../services/road.service';

@Component({
  selector: 'app-roads',
  templateUrl: './roads.component.html',
  styleUrls: ['./roads.component.css']
})
export class RoadsComponent implements OnInit {

  selectedRoad: Road = new Road(null, '', 0);
  roads: Road[] = [];

  constructor(private roadService: RoadService) {
  }

  ngOnInit() {
    this.getRoads();
  }

  getRoads(): void {
    this.roadService.getAllRoads().subscribe(res => this.roads = res);
  }

  onAdd(): void {
    this.roadService.insertRoad(this.selectedRoad).subscribe(res => {
      this.roads.push(res);
    });
  }

  onSave(): void {
    this.roadService.updateRoad(this.selectedRoad).subscribe(res => {
      // this.roads.push(res);
    });
  }

  onItemClick(road: Road) {
    if (this.selectedRoad === road) {
      this.selectedRoad = new Road(null, '', 0.00);
    } else {
      this.selectedRoad = road;
    }
  }
}
