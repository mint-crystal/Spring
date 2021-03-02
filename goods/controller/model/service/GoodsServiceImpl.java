package com.mvcproject.goods.controller.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcproject.goods.controller.model.dao.GoodsDAO;
import com.mvcproject.goods.controller.model.vo.Goods;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO goodsDAO;
	
	@Override
	public List<Goods> selectAllGoods() throws Exception {
		return goodsDAO.selectAllGoods();
	}

	@Override
	public Goods selectGoods(String code) throws Exception {
		return goodsDAO.selectGoods(code);
	}

	@Override
	public int insertGoods(Goods goods) throws Exception {
		return goodsDAO.insertGoods(goods);
	}

	@Override
	public int updateGoods(Goods goods) throws Exception {
		return goodsDAO.updateGoods(goods);
	}

	@Override
	public int deleteGoods(String code) throws Exception {
		return goodsDAO.deleteGoods(code);
	}
	
	
}
