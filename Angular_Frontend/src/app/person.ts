export class Person {
  id: number;
  firstName: string;
  lastName: string;
  vehiclesUri: string;

  constructor(id: number, firstName: string, lastName: string, vehiclesUri: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.vehiclesUri = vehiclesUri;
  }
}
