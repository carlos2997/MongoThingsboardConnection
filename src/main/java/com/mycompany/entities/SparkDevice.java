/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author carlos
 */
public class SparkDevice {
    private String id, idCrop,topic;

    public SparkDevice() {
    }

    public SparkDevice(String id, String idCrop, String topic) {
        this.id = id;
        this.idCrop = idCrop;
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(String idCrop) {
        this.idCrop = idCrop;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
}