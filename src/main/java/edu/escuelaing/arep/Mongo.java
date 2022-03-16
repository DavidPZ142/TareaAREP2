package edu.escuelaing.arep;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Mongo {



    private MongoClient mongoClient = MongoClients.create("mongodb+srv://david:holahola@cluster0.xdzgp.mongodb.net/db?retryWrites=true&w=majority");
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("db");
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("db");

    public ArrayList<String> getStrings(){

        int cont = 0;
        int index = 0;
        ArrayList<String> arrayList = new ArrayList<String>();
        FindIterable<Document> iter = mongoCollection.find();
        Iterator<Document> iterD = iter.iterator();
        int countDocuments = (int) mongoCollection.countDocuments();

        while(iterD.hasNext()  && cont <10){
            if (index >= (countDocuments -10)){
                cont++;
                String json = iterD.next().toJson();
                json = "{"+json.substring(json.indexOf("cadena")+1,json.length());
                arrayList.add(json.replaceAll("\"", ""));
                System.out.println(json);

            }else{
                iterD.next();
                index++;
            }
        }

        return arrayList;
    }

    public void addString(String cadena){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        String dateformated = dateFormat.format(date);
        Document document = new Document();
        document.append("cadena", cadena);
        document.append("fecha", dateformated);
        mongoCollection.insertOne(document);
    }
}
