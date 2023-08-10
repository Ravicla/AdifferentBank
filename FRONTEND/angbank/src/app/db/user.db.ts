import { User } from "../interfaces/user.interface";

export const USERS: User[] = [
  {
    id: 1,
    cedula: 1234567890,
    nombre: 'Thalia',
    apellido: 'Alcivar Zambrano',
    email: 'thalia@g.com',
    telefono: '+593098765432',
    rol: 'administrador'
  },
  {
    id: 2,
    cedula: 1223467890,
    nombre: 'Lincoln',
    apellido: 'Santander Alcivar',
    email: 'santa@g.com',
    telefono: '+593098555432',
    rol: 'loq sea'
  },
  {
    id: 3,
    cedula: 1234444444,
    nombre: 'Silvia',
    apellido: 'Zambrano Mendoza',
    email: 'silvi@g.com',
    telefono: '+593088765432',
    rol: 'administrador'
  }
]