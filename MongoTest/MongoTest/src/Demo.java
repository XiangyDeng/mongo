import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static MongoCollection collection = null;
    //连接数据库
    public static void getConnect(int port,String dbName) {
        //不通过认证连接MongoDB服务,默认端口号27017
        //只可以在从节点仅读取不可写入
        MongoClient mongoClient = new MongoClient("localhost",port);

        //复制集最好不要直连primary
/*        MongoClientURI connectionString = new MongoClientURI("mongodb:" +
                "//127.0.0.1[:27020][,127.0.0.1[:27021]]]");
        MongoClient mongoClient = new MongoClient(connectionString);*/

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        //形参表示集合的名字，若指定集合不存在，MongoDB将会在第一次插入文档时，插入集合
        collection = mongoDatabase.getCollection(dbName);
    }
    public static MongoDatabase getConnectByPW(){
        List<ServerAddress> adds = new ArrayList<>();
        ServerAddress serverAddress = new ServerAddress("localhost",27021);
        adds.add(serverAddress);

        List<MongoCredential> credentials = new ArrayList<>();
        //createMongoCRCredential三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential("username",
                "databaseName","password".toCharArray());
        credentials.add(mongoCredential);
        //通过认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(adds,credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }
    //插入文档
    public static void insertOneTest(){
        //要插入的数据
        Document document = new Document("name","43")
                            .append("sex","boy")
                            .append("age",90);
        collection.insertOne(document);
    }
    //插入文档
    public static void insertOneData(String unm,String pwd){

        //要插入的数据
        Document document = new Document("username",unm)
                .append("pwd",pwd);
        collection.insertOne(document);
    }
    //查询所有数据
    public static void findAll(){
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    public static boolean login(String unm,String pwd){
        boolean flag = false;
        //获取集合
        //MongoCollection collection = getConnect(port).getCollection("users");
        Document document = new Document();
        document.put("username",unm);
        document.put("pwd",pwd);
        FindIterable<Document> iterable = collection.find(document)
                                            .projection(document);
        for(Document doc:iterable){
            System.out.println(doc.toJson());
            flag = true;
        }
        return flag;
    }
    public static boolean register(String unm,String pwd){
        boolean flag = false;
        //MongoCollection collection = getConnect().getCollection("users");
        BasicDBObject obj = new BasicDBObject();
        obj.put("username",unm);//key-value
        MongoCursor<Document> docs = collection.find(obj).iterator();
        if (docs.hasNext()){
            System.out.println(docs.next().toString());
            flag = true;
            return flag;
        }else{
            insertOneData(unm,pwd);
        }
        docs.close();
        return flag;
    }

}

