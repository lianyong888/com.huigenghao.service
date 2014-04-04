package test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;

public class TestMongo {
	    /**
	     * @param args
	     */
	    public static void main(String[] args) throws Exception {
	    	TestMongo mt = new TestMongo();
	    	mt.getDBCollection(null);
	        //mt.insertMemo();
	        //mt.query();
	        //mt.delete();
	    }

	    public static DBCollection getDBCollection(String collectionName)
	            throws Exception {
	        Mongo m = new Mongo("118.244.179.252", 27017);
	        
	        System.out.println(m.getDatabaseNames());  
	        DB db = m.getDB("hgh");
	        if(db.authenticate("hgh", "hgh-zylwj".toCharArray())){
	            System.out.println("auth success");;
	        }
	        return null;
	    }
}
