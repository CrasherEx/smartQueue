package com.omega.smartqueue.daos;

import java.util.List;

import com.omega.smartqueue.model.Restaurant;


/**
 * @author Luccas
 *
 */
public interface RestaurantDAO 
{
	public void create(Restaurant restaurant);
	public List<Restaurant> selectByEmail(String email);
	public List<Restaurant> selectByName(String name);
	public List<Restaurant> selectByNameSearch(String nameSearch);
	public List<Restaurant> selectAll();
}
