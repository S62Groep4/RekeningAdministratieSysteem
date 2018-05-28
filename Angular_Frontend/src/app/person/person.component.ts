import {Component, OnInit} from '@angular/core';
import {PersonService} from '../services/person.service';
import {Person} from '../person';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  person: Person;
  personId: number;

  constructor(private personService: PersonService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.personId = params['id'];
    });
    this.personService.getPerson(this.personId).subscribe(res => this.person = res);
  }
}
