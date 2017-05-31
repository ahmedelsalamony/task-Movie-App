package com.example.ahmed.task_movie_app.model;

/**
 * Created by ahmed on 5/18/2017.
 */

public class MSG {

    private Integer status;
    private String message;

    /**
     * No args constructor for use in serialization
     */
    public MSG() {
    }

    /**
     * @param message
     * @param status
     */
    public MSG(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
