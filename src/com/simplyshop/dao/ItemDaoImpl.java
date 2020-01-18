package com.simplyshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplyshop.dao.util.DbUtil;
import com.simplyshop.model.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		String GET_ITEM = "SELECT * FROM SS_ITEM";
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(GET_ITEM)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getString("ID"), rs.getString("NAME"), rs.getInt("PRICE"));
				item.setDiscount(rs.getDouble("DISCOUNT"));
				item.setDescription(rs.getString("DESCRIPTION"));
				item.setImageUrl(rs.getString("IMAGE_URL"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item getItem(String id) {
		Item item = null;
		String GET_ITEM = "SELECT * FROM SS_ITEM  WHERE ID = ?";
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(GET_ITEM)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			item = new Item(rs.getString("ID"), rs.getString("NAME"), rs.getInt("PRICE"));
			item.setDiscount(rs.getDouble("DISCOUNT"));
			item.setDescription(rs.getString("DESCRIPTION"));
			item.setImageUrl(rs.getString("IMAGE_URL"));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
}
