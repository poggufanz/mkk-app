/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.exceptions;

/**
 *
 * @author muhammad faiq
 */
public abstract class MKKException extends RuntimeException {
    private String errorCode;

    public MKKException(String message) {
        super(message);
    }

    public MKKException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
