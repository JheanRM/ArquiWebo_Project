export interface Dispositivo {
  id?: number;
  name: string;
  instalationDate:number;
  typeDevice?: TypeDevice;

}
export interface TypeDevice {
  id: number;
  name: string;
}
