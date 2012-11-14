package com.omega.smartqueue.webservices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.omega.smartqueue.exceptions.ConnectionAuthenticationException;
import com.omega.smartqueue.exceptions.MessageSizeException;
import com.omega.smartqueue.exceptions.NotEnoughCreditsException;

/**
 * The SMSBRService class represents a SMS module that is capable of sending SMSs using http://smsbr.com.br services.
 * @version 1.0, October 2012
 */
public class SMSBRService
{
	
	/**
	 * requestURL is the URL used to request the action to send a SMS.
	 */
	final String requestURL = "http://smsbr.com.br/enviosms.php";
	
	/**
	 * apiKey is the id used to access the correct API.
	 */
	final String apiKey = "1697080177";

	/**
	 * accountUsername is the username used to access the correct SMS BR account.
	 */
	final String accountUsername = "IanSilva";
	
	public SMSBRService()
	{
		
	}
	
	/**
	 * Sends a SMS message given a telepohoneNumber and a message to send.
	 * 
	 * CAUTION!
	 * Messages sent will be charged on the SMS BR account. (R$ 0.15 per message).
	 * 
	 * @param telephoneNumber The telephone number to send the message to.
	 * @param message The message to send.
	 * 
	 * @throws IOException if it wasn't possible to establish a connection with the SMS server.
	 * @throws MessageSizeException if the message is too large to be sent (maximum length allowed: 150 characters).
	 * @throws ConnectionAuthenticationException if there was an error authenticating accounts and id's.
	 * @throws NotEnoughCreditsException if the SMS BR account hasn't enough credits.
	 */
	public void sendSMS(String telephoneNumber, String message) throws IOException, MessageSizeException, ConnectionAuthenticationException, NotEnoughCreditsException
	{
		String urlParameters;
		try 
		{
			urlParameters = "chaveAPI=" + URLEncoder.encode(apiKey, "UTF-8") + 
							"&usuarioNome=" + URLEncoder.encode(accountUsername, "UTF-8") + 
							"&numeroTel=" + URLEncoder.encode(telephoneNumber, "UTF-8") +
							"&mensTexto=" + URLEncoder.encode(message, "UTF-8");
			
			URL url;
			HttpURLConnection connection = null;
			
			try
			{
				url = new URL(requestURL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
					
				connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
				connection.setRequestProperty("Content-Language", "pt-BR");  
					
				connection.setUseCaches (false);
				connection.setDoInput(true);
				connection.setDoOutput(true);
			
				//Send request
				DataOutputStream connectionStreamWriter = new DataOutputStream (connection.getOutputStream());
				connectionStreamWriter.writeBytes(urlParameters);
				connectionStreamWriter.flush ();
				connectionStreamWriter.close ();
			  
				//Receive response
				InputStream inputStream = connection.getInputStream();
				BufferedReader connectionStreamReader = new BufferedReader(new InputStreamReader(inputStream));
				String line;
				StringBuffer response = new StringBuffer();
				
				while((line = connectionStreamReader.readLine()) != null)
				{
					response.append(line);
				}
				
				connectionStreamReader.close();
				
				String statusMessage = response.toString();
				
				if(statusMessage.equals("Er001"))
				{
					throw new MessageSizeException();
				}
				else if(statusMessage.equals("Er002"))
				{
					throw new ConnectionAuthenticationException();
				}
				else if(statusMessage.equals("Er003"))
				{
					throw new NotEnoughCreditsException();
				}
	
				if(connection != null)
				{
					connection.disconnect();
				}
			} 
			catch (IOException ioException)
			{
				throw ioException;
			}
		} 
		catch (UnsupportedEncodingException unsupportedEncodingException) 
		{
			throw unsupportedEncodingException;
		}
	}
}
