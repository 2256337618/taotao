package com.taotao.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/rest/item")
public class ItemDelete {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/delete")
	@ResponseBody
	public int itemdelete(long[] ids) {
		int a=0;
		for (long id : ids) {
			 itemService.deleteByPrimaryKey(id);
			 a=a+1;
		}
		return a;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public int itemupdate (TbItem item) {
		int i = itemService.updateByPrimaryKeySelective(item);
		return i;
	}
	
}
