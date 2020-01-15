package com.simplyshop.service;

import java.util.List;

import com.simplyshop.dao.ItemDao;
import com.simplyshop.dao.ItemDaoImpl;
import com.simplyshop.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;

	public ItemServiceImpl() {
		this.itemDao = new ItemDaoImpl();
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

}
