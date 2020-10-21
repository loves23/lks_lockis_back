package com.lksback.springboot.dto.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tree.Yip on 11/02/2020.
 */
public class LksException extends RuntimeException {

    private static final long serialVersionUID = -7440479244526424143L;
    private LksErrors error;
    private Integer code;
    private List<Object> dto;
    private List<String> hints;

    public LksException(LksErrors error) {
        super(error.name());
        this.error = error;
        this.code = error.getCode();
    }

    public LksErrors getError() {
        return error;
    }

    public void setError(LksErrors error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public LksException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public List<Object> getDto() {
        return dto;
    }

    public LksException setDto(Object dto) {
        if (this.dto == null) {
            this.dto = new ArrayList<Object>();
        }
        this.dto.add(dto);
        return this;
    }

    public List<String> getHints() {
        return hints;
    }

    public LksException setHint(String hint) {
        if (this.hints == null) {
            this.hints = new ArrayList<String>();
        }
        this.hints.add(hint);
        return this;
    }
}
