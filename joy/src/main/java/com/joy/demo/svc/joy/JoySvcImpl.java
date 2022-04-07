package com.joy.demo.svc.joy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.advice.RestException;
import com.joy.demo.entity.mongo.joyEntity;

@Service
public class JoySvcImpl implements JoySvc {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public joyEntity getEvent(String _id) {
		// TODO Auto-generated method stub
		joyEntity joy = mongoTemplate.findById(_id, joyEntity.class);
		return Optional.ofNullable(joy).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Not found event"));
	}

	@Override
	public List<joyEntity> getEventList(String extra) {
		// TODO Auto-generated method stub
		Query query = new Query().addCriteria(Criteria.where("extra").is(extra));
		return mongoTemplate.find(query, joyEntity.class);
	}

	@Override
	@Transactional
	public String insertEvent(joyEntity joyto) {
		String result = "ProcessSucess";
		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			joyto.setCreatedon(now.format(formatter));
			mongoTemplate.insert(joyto);
		} catch (Exception e) {
			result = "ProcessFail";
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public List<joyEntity> selectJoyList(joyEntity to) {
		// TODO Auto-generated method stub
		joyEntity joyvo = new joyEntity();
		List<joyEntity> list = new ArrayList<joyEntity>();
//		Query query = new Query().with(new Sort( Direction.DESC, "createdon" ));
		// Query query = new Query().with(new Sort(Direction.DESC, "no"));

		System.out.println("안녕??");
		Query query = new Query().addCriteria(Criteria.where("_id").is(new ObjectId("62459b039d47c06db438dfc5")));
		Document doc = mongoTemplate.findOne(query, Document.class, "joy"); // 데이터를 가져와서

		query = new Query();
		List<Document> doc2 = mongoTemplate.find(query, Document.class, "joy");
		System.out.println("##" + doc);

		for (int i = 0; i < doc2.size(); i++) {
			System.out.println("##" + doc2.get(i));
		}

		return null;
	}
}
