package com.robin.proyecommer.backend.entity.generic;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public class GenericEntity {
    @Size(min=1, max=1, message="El estado es requerido y debe ser 0 o 1")
    @Column(name="ESTADO")
    private String estado="1";
}
