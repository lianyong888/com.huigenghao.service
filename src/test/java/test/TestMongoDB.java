package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.Flow.FileObj;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-mongo-database.xml" })
public class TestMongoDB {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void add(){
		 List<String> files = new ArrayList<String>();
		List<FileObj> fileObjs = new ArrayList<FileObj>();
		Update update = new Update();
        FileObj fileObj1 = new FileObj();
        fileObj1.setFileName("nodepad");
        fileObj1.setFileType("txt");//("nodepad");
        fileObjs.add(fileObj1);
        
        update.set("files", files);
        update.set("fileObjs", fileObjs);
        
        mongoTemplate.insert(fileObjs, Flow.class);
	}
	
	@Test
	public void testQuery(){
		List<Flow> list = getAllObjects();
		updateObject(list.get(0));
		System.out.println(list.get(0));
	}
	
    public void updateObject(Flow flow) {
        Query query = new Query(Criteria.where("id").is(flow.getId()));
        Update update = new Update();
        
        List<String> files = new ArrayList<String>();
        files.add("3");
        files.add("4");
        files.add("8");
        
        List<FileObj> fileObjs = new ArrayList<FileObj>();
        
        FileObj fileObj1 = new FileObj();
        fileObj1.setFileName("nodepad");
        fileObj1.setFileType("txt");//("nodepad");
        fileObjs.add(fileObj1);
        
        update.set("files", files);
        update.set("fileObjs", fileObjs);
        
        
        mongoTemplate.updateFirst(query, update, Flow.class);
    }
    
    
    public List<Flow> getAllObjects() {
        return mongoTemplate.find(new Query(), Flow.class);
    }
	
}
