package com.mrkj.ygl.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkj.ygl.dao.sys.DictionaryMapper;
import com.mrkj.ygl.entity.sys.Dictionary;
import com.mrkj.ygl.service.sys.DictionaryService;

@Service
public class DictonaryServiceImpl implements DictionaryService {

	@Resource
	DictionaryMapper dictm;

	@Override
	public int deleteByPrimaryKey(Integer dictId) {
		// TODO Auto-generated method stub
		return dictm.deleteByPrimaryKey(dictId);
	}

	@Override
	public int insert(Dictionary record) {
		// TODO Auto-generated method stub
		return dictm.insert(record);
	}

	@Override
	public int insertSelective(Dictionary record) {
		// TODO Auto-generated method stub
		return dictm.insertSelective(record);
	}

	@Override
	public Dictionary selectByPrimaryKey(Integer dictId) {
		// TODO Auto-generated method stub
		return dictm.selectByPrimaryKey(dictId);
	}

	@Override
	public int updateByPrimaryKeySelective(Dictionary record) {
		// TODO Auto-generated method stub
		return dictm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dictionary record) {
		// TODO Auto-generated method stub
		return dictm.updateByPrimaryKey(record);
	}

	@Override
	public List<Dictionary> selectByGroup(String dictGroup) {
		// TODO Auto-generated method stub
		return dictm.selectByGroup(dictGroup);
	}

	
	
}
