package com.example.spaceappchallenge.enums;

public enum State {
    EN_ESPERA("En Espera"),
    EN_PROGRESO("En Progreso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado");

    private final String descripcion;

    State(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
