package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EuDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class Itcontroller {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{id}")
	@ResponseBody
	public TbItem saveitem(@PathVariable long id) {
		return itemService.selectByPrimaryKey(id);
	}
	
	
	@ResponseBody
	@RequestMapping("/list")
	public EuDataGridResult selectitem(Integer page,Integer rows) {
		return itemService.getItemList(page, rows);
	}
	
}
