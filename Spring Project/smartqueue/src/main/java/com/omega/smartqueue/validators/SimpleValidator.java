package com.omega.smartqueue.validators;

import java.util.ArrayList;

/**
 * As classes de valida��o s�o respons�veis por validar
 * uma string. Para que a string seja v�lida, ela precisa
 * atender �s especifica��es e aos padr�es presentes no m�dulo.
 */ 

public interface SimpleValidator
{
	/**
	 * M�todo que efetivamente valida o valor da string passada como par�metro
	 * 
	 * @param stringToValidate string que ser� validada
	 * @return Lista de erros encontrados durante a valida��o
	 */
	public ArrayList<String> validate(String stringToValidate);
}
