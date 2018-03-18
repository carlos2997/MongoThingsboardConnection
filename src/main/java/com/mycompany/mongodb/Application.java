package com.mycompany.mongodb;


import com.mycompany.connection.MongoDBSpatial;

import com.mycompany.entities.SpatialCrop;
import com.mycompany.entities.SpatialDevice;
import com.mycompany.entities.SpatialFarm;
import com.mycompany.entities.model.Point;
import com.mycompany.entities.model.Polygon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);

        List<Double> coor1 = new ArrayList<>();
        coor1.add(-74.16629791259766);
        coor1.add(4.617491134677797);

        List<Double> coor2 = new ArrayList<>();
        coor2.add(-74.16921615600586);
        coor2.add(4.602177141519673);
        
        List<Double> coor3 = new ArrayList<>();
        coor3.add(-74.1511058807373);
        coor3.add(4.603118234410997);
        
        List<Double> coor4 = new ArrayList<>();
        coor4.add(-74.14896011352539);
        coor4.add(4.61697782181996);
        
        List<Double> coor5 = new ArrayList<>();
        coor5.add(-74.16629791259766);
        coor5.add(4.617491134677797);
          
            
        List<List<Double>> lin = new LinkedList<>();
        lin.add(coor1);
        lin.add(coor2);
        lin.add(coor3);
        lin.add(coor4);
        lin.add(coor5);
        Polygon p = new Polygon(lin,"Polygon");
        Point p1 = new Point(coor1,"Point");
        
        
        SpatialFarm sf = new SpatialFarm("ACD-12-SD13", "LA FINCA DE HOY", p);
        SpatialCrop sc = new SpatialCrop("QWE-QW-1213", "ACD-12-SD13", p);
        SpatialDevice sd = new SpatialDevice("POI-LOI-3213", "QWE-QW-1213", p1);
        
        MongoDBSpatial mdbs = new MongoDBSpatial();
        
        mdbs.getMongodbDevice().save(sd);
        mdbs.getMongodbFarm().save(sf);
        mdbs.getMongodbcrop().save(sc);
       
        List<SpatialCrop> arra = mdbs.getMongodbcrop().find();
        for (SpatialCrop spatialCrop : arra) {
            System.out.println("crop: : "+spatialCrop);
        }
        
        List<SpatialFarm> arra2 = mdbs.getMongodbFarm().find();
        for (SpatialFarm spatialFarm : arra2) {
            System.out.println("farm: "+spatialFarm);
        }
        
        List<SpatialDevice> arra3 = mdbs.getMongodbDevice().find();
        for (SpatialDevice spatialDev : arra3) {
            System.out.println("device: "+spatialDev);
        }
        
        System.out.println("este es crop: "+mdbs.findCropsByDeviceId("POI-LOI-3213").toString());
        System.out.println("este es farm: "+mdbs.findFarmsByDeviceId("POI-LOI-3213").toString());
        
        System.out.println(mdbs.getMongodbDevice().findById("dsad"));
        
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
