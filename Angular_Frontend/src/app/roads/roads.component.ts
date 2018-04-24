import {Component, OnInit} from '@angular/core';
import {Road} from '../road';

@Component({
  selector: 'app-roads',
  templateUrl: './roads.component.html',
  styleUrls: ['./roads.component.css']
})
export class RoadsComponent implements OnInit {

  selectedRoad: Road = new Road(null, '', 0);
  roads: Road[] = [];

  constructor() {
    const road1 = new Road(1, 'A1', 1.20);
    const road2 = new Road(2, 'A2', 1.21);
    const road3 = new Road(3, 'A3', 1.18);
    this.roads.push(road1);
    this.roads.push(road2);
    this.roads.push(road3);
  }

  ngOnInit() {
  }

  onAdd(): void {
    this.roads.push(new Road(this.selectedRoad.id, this.selectedRoad.name, this.selectedRoad.rate));
  }

  onSave(): void {
    // Save to rest api
  }

  onItemClick(road: Road) {
    if (this.selectedRoad === road) {
      this.selectedRoad = new Road(null, '', 0.00);
    } else {
      this.selectedRoad = road;
    }
  }
}
