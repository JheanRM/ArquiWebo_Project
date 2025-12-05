export interface Reconpensas {
  id?: number;
  titulo: string;
  descipcion: string;
  category: string;
  client?: {
    id: number;
    name: string;
  };
}
