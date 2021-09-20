package com.robin.proyecommer.backend.controller.generic;

import com.robin.proyecommer.backend.controller.commons.ResponseEstado;
import com.robin.proyecommer.backend.controller.commons.ResponseRest;
import com.robin.proyecommer.backend.controller.constants.ResponseContants;
import com.robin.proyecommer.backend.controller.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericController {
    @Value("${api.version}")
    private String apiVersion;

    protected String formatMapMessage(BindingResult result){
        List<Map<String,String>> errros = result.getFieldErrors().stream().map(err ->{
            Map<String,String> error = new HashMap<>();
            error.put(err.getField(),err.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());
        return errros.toString();
    }

    protected ResponseEntity<ResponseRest> getBadRequest(BindingResult result){
        ResponseRest res = ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(ResponseEstado.builder()
                        .codigo(ResponseEnum.ALERTA)
                        .mensaje(ResponseContants.MSG_REG_ALERTA)
                        .estado(HttpStatus.BAD_REQUEST.value())
                        .error(HttpStatus.BAD_REQUEST.name())
                        .detalle(this.formatMapMessage(result)).build()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    protected ResponseEntity<ResponseRest> getBadRequest(String detalle){
        ResponseRest res= 	ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnum.ALERTA)
                                .mensaje(ResponseContants.MSG_REG_ALERTA)
                                .estado(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.name())
                                .detalle(detalle)
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    protected ResponseEntity<ResponseRest> getBadIdRequest(){
        return this.getBadRequest(ResponseContants.ID_ALERTA);
    }

    protected ResponseEntity<ResponseRest> getNotFoundRequest(){
        ResponseRest res= 	ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnum.ALERTA)
                                .mensaje(ResponseContants.MSG_CONS_SIN_CONT)
                                .estado(HttpStatus.NOT_FOUND.value())
                                .error(HttpStatus.NOT_FOUND.name())
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    protected ResponseEntity<ResponseRest> getCreated(Object obj){
        ResponseRest responseRest = ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                        .codigo(ResponseEnum.EXITO)
                                .mensaje(ResponseContants.MSG_REG_EXITO)
                                .estado(HttpStatus.OK.value())
                                .error(HttpStatus.OK.name())
                                .detalle(obj)
                                .build()).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseRest);
    }

    protected ResponseEntity<ResponseRest> getOKRegistroRequest(Object obj){
        ResponseRest responseRest = ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                        .codigo(ResponseEnum.ALERTA)
                        .mensaje(ResponseContants.MSG_REG_EXITO)
                        .estado(HttpStatus.OK.value())
                        .error(HttpStatus.OK.name())
                        .detalle(obj)
                        .build()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseRest);
    }

    protected ResponseEntity<ResponseRest> getOKConsultaRequest(Object obj){
        ResponseRest res= 	ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnum.ALERTA)
                                .mensaje(ResponseContants.MSG_CONS_EXITO)
                                .estado(HttpStatus.OK.value())
                                .error(HttpStatus.OK.name())
                                .build())
                .resultado(obj)
                .build();
        return ResponseEntity.ok(res);
    }

    protected ResponseEntity<ResponseRest> getExiteItemRequest(){
        ResponseRest res= 	ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnum.EXITO)
                                .mensaje(ResponseContants.MSG_REG_EXISTE)
                                .estado(HttpStatus.NOT_FOUND.value())
                                .error(HttpStatus.NOT_FOUND.name())
                                .build())
                //.resultado(obj)
                .build();
        return ResponseEntity.ok(res);
    }

    protected ResponseEntity<ResponseRest> getErrorRequest() {
        ResponseRest responseRest = ResponseRest.builder()
                .apiVerision(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnum.ERROR)
                                .mensaje(ResponseContants.MSG_ERR_GENE)
                                .estado(HttpStatus.INTERNAL_SERVER_ERROR.value() )
                                .error(HttpStatus.INTERNAL_SERVER_ERROR.name())
                                .build()
                ).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseRest);
    }
}
