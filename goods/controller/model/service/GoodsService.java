package com.mvcproject.goods.controller.model.service;

import java.util.List;

import com.mvcproject.goods.controller.model.vo.Goods;

public interface GoodsService {
	public List<Goods> selectAllGoods() throws Exception;
	public Goods selectGoods(String code) throws Exception;
	public int insertGoods(Goods goods) throws Exception;
	public int updateGoods(Goods goods) throws Exception;
	public int deleteGoods(String string) throws Exception;
}
