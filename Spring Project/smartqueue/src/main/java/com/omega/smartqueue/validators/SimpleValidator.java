package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * As classes de validação são responsáveis por validar
 * uma string. Para que a string seja válida, ela precisa
 * atender às especificações e aos padrões presentes no módulo.
 */ 

public interface SimpleValidator
{
	/**
	 * Método que efetivamente valida o valor da string passada como parâmetro
	 * 
	 * @param stringToValidate string que será validada
	 * @return Lista de erros encontrados durante a validação
	 */
	public ArrayList<String> validate(String stringToValidate);
}
