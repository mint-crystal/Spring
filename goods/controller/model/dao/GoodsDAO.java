package com.mvcproject.goods.controller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.goods.controller.model.vo.Goods;

@Repository
public class GoodsDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public GoodsDAO() {}
	
	public List<Goods> selectAllGoods() throws Exception{
		List<Goods> goodsList = sqlSession.selectList("Goods.selectAllGoods");
		return goodsList;
	}
	
	public Goods selectGoods(String code) throws Exception{
		Goods goods = sqlSession.selectOne("Goods.selectGoods", code);
		return goods;
	}
	
	public int insertGoods(Goods goods) throws Exception{
		int result = sqlSession.insert("Goods.insertGoods", goods);
		return result;
	}
	
	public int updateGoods(Goods goods) throws Exception{
		int result = sqlSession.update("Goods.updateGoods", goods);
		return result;
	}
	
	public int deleteGoods(String code) throws Exception{
		int result = sqlSession.delete("Goods.deleteGoods", code);
		return result;
	}
}
