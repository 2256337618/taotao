package com.taotao.service;

import com.taotao.common.pojo.EuDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem selectByPrimaryKey(long id);
	EuDataGridResult getItemList(int page,int rows);
	int deleteByPrimaryKey(long id);
	
	int updateByPrimaryKeySelective(TbItem item);
}
