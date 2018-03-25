/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connection;

import com.mycompany.entities.SpatialCrop;
import com.mycompany.entities.SpatialDevice;
import com.mycompany.entities.SpatialFarm;

/**
 *
 * @author Sonia
 */
public interface SpatialIndexes {
    
    public SpatialFarm findFarmsByDeviceId(String device_id) throws MongoDBException;
    
    public SpatialCrop findCropsByDeviceId(String device_id) throws MongoDBException;
    
    public SpatialDevice getCoordenatesByDeviceId(String device_id) throws MongoDBException;
    
    public String getTokenByIdCropTopic(String idCrop,String token) throws MongoDBException;
}
