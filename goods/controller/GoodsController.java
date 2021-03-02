package com.mvcproject.goods.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.goods.controller.model.service.GoodsService;
import com.mvcproject.goods.controller.model.vo.Goods;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="goodsList.do", method=RequestMethod.GET)
	public ModelAndView selectAllGoods(ModelAndView mav) throws Exception{		
		List<Goods> goodsList = goodsService.selectAllGoods();
		mav.addObject("goodsList", goodsList);
		mav.setViewName("goods/goodsList");
		return mav;
	}
	
	@RequestMapping(value="goodsView.do", method=RequestMethod.GET)
	public ModelAndView selectGoods(ModelAndView mav, String code) throws Exception{
		Goods goods = goodsService.selectGoods(code);
		mav.addObject("goods", goods);
		mav.setViewName("goods/goodsView");
		return mav;
	}
	
	@RequestMapping(value="goodsIns.do", method=RequestMethod.GET)
	public ModelAndView insertGoodsForm(ModelAndView mav) {
		mav.setViewName("goods/goodsInsForm");
		return mav;
	}
	
	@RequestMapping(value="goodsIns.do", method=RequestMethod.POST)
	public ModelAndView insertGoods(ModelAndView mav, Goods goods) throws Exception{
		int result = goodsService.insertGoods(goods);
		mav.addObject("result", result);
		mav.setViewName("goods/goodsInsComplete");
		return mav;
	}
	
	@RequestMapping(value="goodsUpt.do", method=RequestMethod.GET)
	public ModelAndView updateGoodsForm(ModelAndView mav, String code) throws Exception{
		Goods goods = goodsService.selectGoods(code);
		mav.addObject("goods", goods);
		mav.setViewName("goods/goodsUptForm");
		return mav;
	}
	
	@RequestMapping(value="goodsUpt.do", method=RequestMethod.POST)
	public ModelAndView updateGoods(ModelAndView mav, Goods goods) throws Exception{
		int result = goodsService.updateGoods(goods);
		mav.addObject("result", result);
		mav.setViewName("goods/goodsUptComplete");
		return mav;
	}
	
	@RequestMapping(value="goodsDel.do", method=RequestMethod.GET)
	public ModelAndView deleteGoods(ModelAndView mav, String code) throws Exception{
		int result = goodsService.deleteGoods(code);
		mav.addObject("result", result);
		mav.setViewName("goods/goodsDel");
		return mav;
	}
	
	@RequestMapping(value="goodsData.do", method=RequestMethod.GET)
	@ResponseBody
	public String goodsAjax(ModelAndView mav, @RequestParam("code")String code) throws Exception{
		Goods goods = goodsService.selectGoods(code);
		
		JSONObject jsonData = new JSONObject();
		if(goods == null)
			jsonData.put("codeDup","");
		else
			jsonData.put("codeDup","dup");
		
		return jsonData.toJSONString();
	}
}
