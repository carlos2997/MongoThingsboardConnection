/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connection.dao.SpatialFarm;

import com.mongodb.Block;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mycompany.connection.MongoConnectionPOJO;
import com.mycompany.connection.dao.Dao;
import com.mycompany.entities.SpatialCrop;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Sonia
 */
public class MongoDBSpatialCrop extends MongoConnectionPOJO<SpatialCrop> implements Dao<SpatialCrop> {

    @Override
    public MongoCollection<SpatialCrop> getCollectionDependClass() {
        return this.getMongoDatabase().getCollection("Crops", SpatialCrop.class);
    }

    @Override
    public List<SpatialCrop> find() {
        MongoCollection<SpatialCrop> farmCollection = getCollectionDependClass();
        List<SpatialCrop> resultSet = new CopyOnWriteArrayList<>();
        farmCollection.find().forEach((Block<SpatialCrop>) crop -> {
            resultSet.add(crop);
        });
        return resultSet;
    }

    @Override
    public SpatialCrop findById(String id) {
        return getCollectionDependClass().find(eq("_id", id)).first();
    }

    @Override
    public SpatialCrop save(SpatialCrop t){
        try{
            getCollectionDependClass().insertOne(t);
            return t;
        }catch(MongoWriteException ex){
            System.out.println("No fue posible agregar el crop");
            
        }
        return null;
    }

    @Override
    public boolean removeById(String id) {
        DeleteResult deleteResult = getCollectionDependClass().deleteMany(eq("_id", id));
        return deleteResult.wasAcknowledged();
    }

}
