package ws_tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import models.Pokemon;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebServiceTest {

	public static void main(String[] args) throws IOException {
		
//		MyGETRequest();
		pokemonAPI_getRequest();
		
	}
	
	public static void pokemonAPI_getRequest() {
		try {

			URL url = new URL("https://pokeapi.co/api/v2/pokemon/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro HTTP, codigo: "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			JsonFactory factory = new JsonFactory();
			JsonParser parser = factory.createParser(br);
			ObjectMapper mapper = new ObjectMapper();
			Map obj = mapper.readValue(parser,Map.class);
			
			ArrayList<Map> mapa = (ArrayList<Map>) obj.get("results");
			
			ArrayList<Pokemon> resultados_array = new ArrayList<Pokemon>();
			
			for (Map<Object,String> pkm : mapa) {
				Pokemon resultados = new Pokemon();
				resultados.setName(pkm.get("name"));
				resultados.setSurl(pkm.get("url"));
				resultados_array.add(resultados);
			}
			System.out.println("\nImprimindo o resultados_array:\n");
			for (Pokemon re:resultados_array) {
				if (re.getName().contains("char")) {
					System.out.println(re.getName());
				}
				
			}
			

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	}
	
}
