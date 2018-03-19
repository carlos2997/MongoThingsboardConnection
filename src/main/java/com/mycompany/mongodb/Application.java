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
        MongoDBSpatial mdbs = new MongoDBSpatial();
        
        List<Double> coor1 = new ArrayList<>();
        coor1.add(-74.0464997291565);
        coor1.add(4.784640029781744);

        List<Double> coor2 = new ArrayList<>();
        coor2.add(-74.04680013656616);
        coor2.add(4.7825017366800235);
        
        List<Double> coor3 = new ArrayList<>();
        coor3.add(-74.04188632965088);
        coor3.add(4.781774715504362);
        
        List<Double> coor4 = new ArrayList<>();
        coor4.add(-74.04150009155272);
        coor4.add(4.783870245034454);
        
        List<Double> coor5 = new ArrayList<>();
        coor5.add(-74.0464997291565);
        coor5.add(4.784640029781744);
          
            
        List<List<Double>> lin = new LinkedList<>();
        lin.add(coor1);
        lin.add(coor2);
        lin.add(coor3);
        lin.add(coor4);
        lin.add(coor5);
        
        Polygon pFinca1 = new Polygon(lin,"Polygon");
        
        SpatialFarm sf = new SpatialFarm("ACD-12-SD1", "Escuela Colombiana de Ingenieria", pFinca1);
        
        //Aqui va la finca
        
        List<Double> coorFin1 = new ArrayList<>();
        coorFin1.add(-74.04621809720993);
        coorFin1.add(4.7833196345800735);

        List<Double> coorFin2 = new ArrayList<>();
        coorFin2.add(-74.0459954738617);
        coorFin2.add(4.782515101032638);
        
        List<Double> coorFin3 = new ArrayList<>();
        coorFin3.add(-74.04539197683334);
        coorFin3.add(4.782656763154403);
        
        List<Double> coorFin4 = new ArrayList<>();
        coorFin4.add(-74.04561460018158);
        coorFin4.add(4.783474660869294);
        
        List<Double> coorFin5 = new ArrayList<>();
        coorFin5.add(-74.04621809720993);
        coorFin5.add(4.7833196345800735);
          
            
        List<List<Double>> linCrop1 = new LinkedList<>();
        linCrop1.add(coorFin1);
        linCrop1.add(coorFin2);
        linCrop1.add(coorFin3);
        linCrop1.add(coorFin4);
        linCrop1.add(coorFin5);
        Polygon pCrop1 = new Polygon(linCrop1,"Polygon");

        SpatialCrop sc1 = new SpatialCrop("QWE-QW-121", "ACD-12-SD1", pCrop1);
        
        //Aqui va el crop1
        
        List<Double> coorFin21 = new ArrayList<>();
        coorFin21.add(-74.04540002346039);
        coorFin21.add(4.783381110526558);

        List<Double> coorFin22 = new ArrayList<>();
        coorFin22.add(-74.0452578663826);
        coorFin22.add(4.782910685752169);
        
        List<Double> coorFin23 = new ArrayList<>();
        coorFin23.add(-74.04493868350983);
        coorFin23.add(4.783009581896331);
        
        List<Double> coorFin24 = new ArrayList<>();
        coorFin24.add(-74.04508620500563);
        coorFin24.add(4.783488025202928);
        
        List<Double> coorFin25 = new ArrayList<>();
        coorFin25.add(-74.04540002346039);
        coorFin25.add(4.783381110526558);
          
            
        List<List<Double>> linCrop12 = new LinkedList<>();
        linCrop12.add(coorFin21);
        linCrop12.add(coorFin22);
        linCrop12.add(coorFin23);
        linCrop12.add(coorFin24);
        linCrop12.add(coorFin25);
        Polygon pCrop2 = new Polygon(linCrop12,"Polygon");

        SpatialCrop sc2 = new SpatialCrop("MNB-LKJ-987", "ACD-12-SD1", pCrop2);
        
        //Aqui va el crop 2
        
        List<Double> device11 = new ArrayList<>();
        device11.add(-74.04608398675919);
        device11.add(4.78321004700962);
        
        List<Double> device12 = new ArrayList<>();
        device12.add(-74.04570311307907);
        device12.add(4.783079076475592);
        
        List<Double> device13 = new ArrayList<>();
        device13.add(-74.04579430818558);
        device13.add(4.782710220551225);
        
        Point pd1 = new Point(device11, "Point");
        Point pd2 = new Point(device12, "Point");
        Point pd3 = new Point(device13, "Point");
        
        SpatialDevice sdc11 = new SpatialDevice("14fe1a60-2734-11e8-863e-dbc409f2ab03", "QWE-QW-121", pd1);
        SpatialDevice sdc12 = new SpatialDevice("942fa490-2b92-11e8-b840-dbc409f2ab03", "QWE-QW-121", pd2);
        SpatialDevice sdc13 = new SpatialDevice("adb41540-2b92-11e8-b840-dbc409f2ab03", "QWE-QW-121", pd3);
        
        //Aqui van devices crop1
        
        List<Double> device21 = new ArrayList<>();
        device21.add(-74.04529809951782);
        device21.add(4.783324980314771);
        
        List<Double> device22 = new ArrayList<>();
        device22.add(-74.04513984918594);
        device22.add(4.783274195833484);
        
        List<Double> device23 = new ArrayList<>();
        device23.add(-74.0451130270958);
        device23.add(4.78304700205527);
        
        Point pd21 = new Point(device21, "Point");
        Point pd22 = new Point(device22, "Point");
        Point pd23 = new Point(device23, "Point");
        
        SpatialDevice sdc21 = new SpatialDevice("236b9de0-2737-11e8-80d2-dbc409f2ab03", "MNB-LKJ-987", pd21);
        SpatialDevice sdc22 = new SpatialDevice("2bf14480-27c6-11e8-bb6e-dbc409f2ab03", "MNB-LKJ-987", pd22);
        SpatialDevice sdc23 = new SpatialDevice("d50bcca0-2b92-11e8-b840-dbc409f2ab03", "MNB-LKJ-987", pd23);
        
        mdbs.getMongodbFarm().save(sf);
        
        mdbs.getMongodbcrop().save(sc1);
        mdbs.getMongodbcrop().save(sc2);
        
        mdbs.getMongodbDevice().save(sdc11);
        mdbs.getMongodbDevice().save(sdc12);
        mdbs.getMongodbDevice().save(sdc13);
        mdbs.getMongodbDevice().save(sdc21);
        mdbs.getMongodbDevice().save(sdc22);
        mdbs.getMongodbDevice().save(sdc23);


        System.out.println("este es crop: " + mdbs.findCropsByDeviceId("236b9de0-2737-11e8-80d2-dbc409f2ab03").toString());
        System.out.println("este es farm: " + mdbs.findFarmsByDeviceId("adb41540-2b92-11e8-b840-dbc409f2ab03").toString());

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
