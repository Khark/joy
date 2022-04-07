package com.joy.demo.svc.joy;

import java.util.List;

import com.joy.demo.entity.mongo.joyEntity;

public interface JoySvc {

	public joyEntity getEvent(String _id);

	public List<joyEntity> getEventList(String extra);

	public String insertEvent(joyEntity joy);

	List<joyEntity> selectJoyList(joyEntity to);
}
