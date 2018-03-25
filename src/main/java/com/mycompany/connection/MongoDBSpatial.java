/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connection;

import com.mongodb.Block;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mycompany.connection.dao.SpatialFarm.MongoDBSpatialCrop;
import com.mycompany.connection.dao.SpatialFarm.MongoDBSpatialDevice;
import com.mycompany.connection.dao.SpatialFarm.MongoDBSpatialFarm;
import com.mycompany.connection.dao.SpatialFarm.MongoDBSpatialSpark;
import com.mycompany.entities.SparkDevice;
import com.mycompany.entities.SpatialCrop;
import com.mycompany.entities.SpatialDevice;
import com.mycompany.entities.SpatialFarm;

/**
 *
 * @author Sonia
 */
public class MongoDBSpatial extends MongoConnection implements SpatialIndexes {

    private final MongoDBSpatialCrop mongodbcrop;
    private final MongoDBSpatialFarm mongodbFarm;
    private final MongoDBSpatialDevice mongodbDevice;
    private final MongoDBSpatialSpark mongodbspark;

    public MongoDBSpatial() {
        mongodbcrop = new MongoDBSpatialCrop();
        mongodbFarm = new MongoDBSpatialFarm();
        mongodbDevice = new MongoDBSpatialDevice();
        mongodbspark = new MongoDBSpatialSpark();
    }

    public MongoDBSpatialCrop getMongodbcrop() {
        return mongodbcrop;
    }

    public MongoDBSpatialFarm getMongodbFarm() {
        return mongodbFarm;
    }

    public MongoDBSpatialDevice getMongodbDevice() {
        return mongodbDevice;
    }

    public MongoDBSpatialSpark getMongodbspark() {
        return mongodbspark;
    }

    @Override
    public SpatialFarm findFarmsByDeviceId(String device_id) throws MongoDBException {
        try {
            SpatialDevice sdt = mongodbDevice.findById(device_id);
            SpatialCrop sct = mongodbcrop.findById(sdt.getDevice_Crop_FK());
            return mongodbFarm.findById(sct.getCrop_Farm_FK());
        } catch (NullPointerException ex) {
            throw new MongoDBException("It wasn´t posible to load the farm associated with device!!");
        }
    }

    @Override
    public SpatialCrop findCropsByDeviceId(String device_id) throws MongoDBException {
        try {
            SpatialDevice sdt = mongodbDevice.findById(device_id);
            return mongodbcrop.findById(sdt.getDevice_Crop_FK());
        } catch (NullPointerException ex) {
            throw new MongoDBException("It wasn´t posible to load the crop associated with device!!");
        }
    }

    @Override
    public SpatialDevice getCoordenatesByDeviceId(String device_id) throws MongoDBException {
        return mongodbDevice.findById(device_id);
    }

    @Override
    public String getTokenByIdCropTopic(String idCrop, String topic) throws MongoDBException {
        StringBuilder token = new StringBuilder();
        mongodbspark.getCollectionDependClass().find(and(eq("idCrop",idCrop),eq("topic",topic))).forEach((Block<SparkDevice>) sparkDevice -> {
            token.append(sparkDevice.getId());
        });
        return token.toString();
    }

}
