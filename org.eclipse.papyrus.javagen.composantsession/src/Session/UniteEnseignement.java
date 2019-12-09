// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;

/************************************************************/
/**
 * 
 */
public class UniteEnseignement extends SqlUtils {
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String intitule;
	/**
	 * 
	 */
	private float cours;
	/**
	 * 
	 */
	private float td;
	/**
	 * 
	 */
	private float tp;
	/**
	 * 
	 */
	private float valeur;
	/**
	 * 
	 */
	public Classe[] classe;
	/**
	 * 
	 */
	public Creneau[] creneau;

	/**
	 * 
	 * @param id
	 * @param code
	 * @param intitule
	 * @param cours
	 * @param td
	 * @param tp
	 * @param valeur
	 */
	public UniteEnseignement(String id, String code, String intitule, float cours, float td, float tp, float valeur) {
		this.id = id;
		this.code = code;
		this.intitule = intitule;
		this.cours = cours;
		this.td = td;
		this.tp = tp;
		this.valeur = valeur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public float getCours() {
		return cours;
	}

	public void setCours(float cours) {
		this.cours = cours;
	}

	public float getTd() {
		return td;
	}

	public void setTd(float td) {
		this.td = td;
	}

	public float getTp() {
		return tp;
	}

	public void setTp(float tp) {
		this.tp = tp;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public Classe[] getClasse() {
		return classe;
	}

	public void setClasse(Classe[] classe) {
		this.classe = classe;
	}

	public Creneau[] getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau[] creneau) {
		this.creneau = creneau;
	}

	public void save() {
		this.connect();
 
		this.requestUpdate(String.format("INSERT INTO UniteEnseignement VALUES('%s','%s','%s',%s,%s,%s,%s)", this.id,
				this.code, this.intitule, String.valueOf(this.cours), String.valueOf(this.td), String.valueOf(this.tp),
				String.valueOf(this.valeur)));
		this.disconnect();
		URL url;
		try {
			url = new URL ("http://e0aa4a44.ngrok.io/manipulUniteEnseign/create/newentitenseign/");
			HttpURLConnection con;
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				String jsonInputString = "{ \"id\" : \""+id+"\", \"code\" : \""+code+"\", \"intitule\" : \""+intitule+"\", \"cours\" : \""+cours+"\", \"td\" : \""+td+"\", \"tp\" : \""+tp+"\", \"valeur\" : \""+valeur+"\"}";
				try(OutputStream os = con.getOutputStream()) {
				    byte[] input = jsonInputString.getBytes("utf-8");
				    os.write(input, 0, input.length);           
				}
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(con.getInputStream(), "utf-8"))) {
						    StringBuilder response = new StringBuilder();
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						    System.out.println(response.toString());
						}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		this.connect();
		this.requestUpdate(String.format(
				"UPDATE UniteEnseignement SET code='%s',intitule='%s',cours=%s,td=%s,tp=%s,valeur=%s WHERE id='%s'", this.code,
				this.intitule, String.valueOf(this.cours), String.valueOf(this.td), String.valueOf(this.tp),
				String.valueOf(this.valeur), this.id));
		this.disconnect();
	}

	public void delete() {
		this.connect();
		this.requestUpdate(String.format("DELETE FROM UniteEnseignement WHERE id='%s'", this.id));
		this.disconnect();
		URL url;
		try {
			url = new URL ("http://e0aa4a44.ngrok.io/manipulUniteEnseign/delete/deletentitenseign/");
			HttpURLConnection con;
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("DELETE");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				String jsonInputString = "{ \"UUID\" : \""+id+"\"}";
				try(OutputStream os = con.getOutputStream()) {
				    byte[] input = jsonInputString.getBytes("utf-8");
				    os.write(input, 0, input.length);           
				}
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(con.getInputStream(), "utf-8"))) {
						    StringBuilder response = new StringBuilder();
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						    System.out.println(response.toString());
						}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static UniteEnseignement getById(String id) {
		SqlUtils sql = new SqlUtils();
		sql.connect();
		ResultSet set = sql.requestSelect(String.format("SELECT * FROM UniteEnseignement WHERE id='%s'", id));
		
		URL url;
		try {
			url = new URL ("http://e0aa4a44.ngrok.io/manipulUniteEnseign/get/getEntiteEnseign");
			HttpURLConnection con;
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");

				StringBuilder response = new StringBuilder();
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(con.getInputStream(), "utf-8"))) {
						    
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						}
				JSONArray obj = new JSONArray(response.toString());
				
				for (int i = 0; i < obj.length(); ++i) {
					if (obj.getJSONObject(i).getString("id").equals(id)) {
					UniteEnseignement ue = new UniteEnseignement(obj.getJSONObject(i).getString("id"), obj.getJSONObject(i).getString("code"),
							obj.getJSONObject(i).getString("intitule"), obj.getJSONObject(i).getFloat("cours"), obj.getJSONObject(i).getFloat("td"), obj.getJSONObject(i).getFloat("tp"),
							obj.getJSONObject(i).getFloat("valeur"));

					return ue;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static List<UniteEnseignement> getAll() {
	
		List<UniteEnseignement> result = new ArrayList<UniteEnseignement>();
		URL url;
		try {
			url = new URL ("http://localhost:8080/manipulUniteEnseign/get/getEntiteEnseign");
			HttpURLConnection con;
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");

				StringBuilder response = new StringBuilder();
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(con.getInputStream(), "utf-8"))) {
						    
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						}
				JSONArray obj = new JSONArray(response.toString());
				
				for (int i = 0; i < obj.length(); ++i) {
					UniteEnseignement ue = new UniteEnseignement(obj.getJSONObject(i).getString("id"), obj.getJSONObject(i).getString("code"),
							obj.getJSONObject(i).getString("intitule"), obj.getJSONObject(i).getFloat("cours"), obj.getJSONObject(i).getFloat("td"), obj.getJSONObject(i).getFloat("tp"),
							obj.getJSONObject(i).getFloat("valeur"));
					result.add(ue);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String toString() {
		return "" + id + " ; " + code + " ; " + intitule + " ; " + cours
				+ " ; " + td + " ; " + tp + " ; " + valeur + " \n " ;
	}
	
};
