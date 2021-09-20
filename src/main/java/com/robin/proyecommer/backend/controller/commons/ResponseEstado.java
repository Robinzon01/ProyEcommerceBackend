package com.robin.proyecommer.backend.controller.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.robin.proyecommer.backend.controller.enums.ResponseEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@JsonPropertyOrder({"codigo","mensaje","detalle","estado","error","fechaHora"})
@Data
@Builder
public class ResponseEstado {

    @Builder.Default
    private Date fechaHora = new Date();
    private Integer estado;
    private String error;
    private ResponseEnum codigo;
    private Object mensaje;
    @JsonInclude(Include.NON_NULL)
    private Object detalle;

}
