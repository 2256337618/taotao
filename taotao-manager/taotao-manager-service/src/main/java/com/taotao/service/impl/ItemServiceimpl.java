package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EuDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemDescExample;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service("itemService")
public class ItemServiceimpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	public TbItem selectByPrimaryKey(long id) {
		TbItem selectBy = itemMapper.selectByPrimaryKey(id);
		return selectBy;
	}

	@Override
	public EuDataGridResult getItemList(int page, int rows) {
		
		//查询商品列表
		TbItemExample  example=new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list=itemMapper.selectByExample(example);
		//创建一个返回值对象
		EuDataGridResult result=new EuDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		
			result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public int deleteByPrimaryKey(long id) {
		
		return itemMapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(TbItem item) {
	
		return itemMapper.updateByPrimaryKeySelective(item);
			

	
	}

}
