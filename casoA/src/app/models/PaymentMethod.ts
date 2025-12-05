export interface PaymentMethod {
  id?: number;
  nameTitular: string;
  numberCard: number;
  cv: number;
  expiration: Date;
  price:number;
}
