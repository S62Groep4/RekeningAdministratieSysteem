export class Road {
  id: number;
  shortName: string;
  longName: string;
  rate: number;

  constructor(id: number, shortName: string, longName: string, rate: number) {
    this.id = id;
    this.shortName = shortName;
    this.longName = longName;
    this.rate = rate;
  }
}
