package com.omega.smartqueue.validators;

import java.util.ArrayList;
import com.omega.smartqueue.model.Restaurant;

/**
 * Esta classe é responsável por validar os restaurantes
 */

public class RestaurantValidator 
{
	/**
	 * Método que efetivamente valida os restaurantes passados como parâmetro
	 * 
	 * @param restaurantID ID do restaurante que será validado
	 * @param restaurants Lista de restaurantes que serão validados
	 * @return Lista de erros encontrados durante a validação
	 */
	
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
