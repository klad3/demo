import { Usuario } from "./usuario";

export interface Profesor {
    idProfesor: number;
    correo:     string;
    usuario:    Usuario;
}