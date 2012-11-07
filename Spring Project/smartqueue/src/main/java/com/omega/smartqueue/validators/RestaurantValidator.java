package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.model.Restaurant;

/**
	 * Verifies if the user selected none or more than one restaurant's queue to join.
	 * 
	 * @param restaurantId The ID of the selected queue's restaurant.
	 * @param restaurants Array containing all restaurants with the restaurantId selected.
	 * @return errorMessages Array containing all errors found.
*/
public class RestaurantValidator 
{
	public ArrayList<String> validate(Integer restaurantId, ArrayList<Restaurant> restaurants)
	{
		ArrayList<String> errorMessages = new ArrayList<String>();
		// In case the selected restaurant has no ID.
		if(restaurantId == null)
		{
			errorMessages.add("Restaurante nulo.");
		}
		// In case that no restaurant on database has the requested ID.
		if(restaurants.size() == 0)
		{
			errorMessages.add("Restaurante inexistente.");
		}
		// In case there are multiple restaurants with the requested ID.
		if(restaurants.size() > 1)
		{
			errorMessages.add("Um erro fatal ocorreu. Contate o SAC imediatamente. <b>Erro: Entrada múltipla de restaurantes</b>");
		}
		
		return errorMessages;
	}

}
