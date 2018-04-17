import { Component, OnInit } from '@angular/core';
import {Road} from '../road';

@Component({
  selector: 'app-roads',
  templateUrl: './roads.component.html',
  styleUrls: ['./roads.component.css']
})
export class RoadsComponent implements OnInit {

  selectedRoad: Road = new Road(null, '', 0);

  constructor() { }

  ngOnInit() {
  }

}
