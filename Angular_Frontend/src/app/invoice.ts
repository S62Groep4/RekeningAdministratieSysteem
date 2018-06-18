export class Invoice {
  invoiceNumber: number;
  country: string;
  paymentStatus: string;
  invoiceDate: string;
  price: string;
  ownerUri: string;
  carTrackerId: string;

  constructor(invoiceNumber: number, country: string, paymentStatus: string, invoiceDate: string,
              price: string, ownerUri: string, carTrackerId: string) {
    this.invoiceNumber = invoiceNumber;
    this.country = country;
    this.paymentStatus = paymentStatus;
    this.invoiceDate = invoiceDate;
    this.price = price;
    this.ownerUri = ownerUri;
    this.carTrackerId = carTrackerId;
  }
}
