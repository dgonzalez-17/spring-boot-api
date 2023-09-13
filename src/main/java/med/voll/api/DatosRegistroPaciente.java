package med.voll.api;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroPaciente(String nombre, String email, String telefono, String documento, DatosDireccion direccion) {
}
