export interface Puntos {
  id?: number;
  points: string;
  typeTransactions: number;
  client?: {
    id: number;
    name: string;
  };
}
