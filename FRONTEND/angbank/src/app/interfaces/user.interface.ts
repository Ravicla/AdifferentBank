import { Rol } from "./rol.interface";

export interface User {
  userId?: number;
  identificationNumber: string;
  firstName: string;
  lastName: string;
  birthdate: Date;
  emailAddress: string;
  phoneNumber: string;
  status: boolean;
  rol: Rol[];
}
