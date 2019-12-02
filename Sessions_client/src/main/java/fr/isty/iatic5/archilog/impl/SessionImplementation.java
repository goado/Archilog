package fr.isty.iatic5.archilog.impl;


//--------------------------------------------------------
//Code generated by Papyrus Java
//--------------------------------------------------------


import java.time.LocalDate;
import java.time.LocalTime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/************************************************************/
/**
* 
*/
public class SessionImplementation implements SessionInterface {

	
	@Override
	public String createEU(String JSONEntry) {
		// TODO Auto-generated method stub
		String intitule = null;
		float tp = 0;
		float cours = 0;
		float valeur = 0;
		float td = 0;
		String code = null;
		String id = null;
		JSONObject obj;
		try {
			obj = new JSONObject(JSONEntry);
			try {
				id = obj.getString("id");
				code = obj.getString("code");
				intitule = obj.getString("intitule");
				cours = Float.parseFloat(obj.getString("cours"));
				td = Float.parseFloat(obj.getString("td"));
				tp = Float.parseFloat(obj.getString("tp"));
				valeur = Float.parseFloat(obj.getString("valeur"));

			} catch (JSONException e) {
				System.out.println("Unexpected json file, should be: code,intitule,cours,td,tp,valeur");

			}
			URL url;
			try {
				url = new URL ("\"http://localhost:8080/manipulUniteEnseign/create/newentitenseign/");
				HttpURLConnection con;
				try {
					con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json; utf-8");
					con.setRequestProperty("Accept", "application/json");
					con.setDoOutput(true);
					String jsonInputString = "{ id : "+id+", code : "+code+", intitule : "+intitule+", cours : "+cours+", td : "+td+", tp : "+tp+", valeur :"+valeur+"}";
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
			

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		String ret = "{ \"id\": \"" + id + "\"}";

		return ret;
	}

	@Override
	public String createCreneau(String JSONEntry) {
		// TODO Auto-generated method stub
		// init
		String id = null;
		LocalTime debut = LocalTime.now();
		LocalTime fin = LocalTime.now();
		LocalDate jour = LocalDate.now();
		// parse
		JSONObject obj;
		try {
			obj = new JSONObject(JSONEntry);
			id = obj.getString("id");
			debut = LocalTime.parse(obj.getString("debut"));
			fin = LocalTime.parse(obj.getString("fin"));

			jour = LocalDate.parse(obj.getString("jour"));
			// create json
			URL url;
			try {
				url = new URL ("\"http://localhost:8080/manipulCreneau/create/newcreneau/");
				HttpURLConnection con;
				try {
					con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json; utf-8");
					con.setRequestProperty("Accept", "application/json");
					con.setDoOutput(true);
					String jsonInputString = "{ id : "+id+", debut : "+debut+", fin : "+fin+", jour : "+jour+"}";
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
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String ret = "{ \"id\": \"" + id + "\"}";
		return ret;

	}

	@Override
	public String createClasse(String JSONEntry) {
		// TODO Auto-generated method stub

		int promotion = 0;
		String filiere = null;
		String id = null;
		JSONObject obj;
		try {
			obj = new JSONObject(JSONEntry);
			try {
				id = obj.getString("id");
				promotion = Integer.parseInt(obj.getString("promotion"));
				filiere = obj.getString("filiere");
			} catch (JSONException e) {

				System.out.println("Unexpected json file, should be: promotion,filiere");

			}
			URL url;
			try {
				url = new URL ("\"http://localhost:8080/manipulClasse/create/newClasse/");
				HttpURLConnection con;
				try {
					con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Type", "application/json; utf-8");
					con.setRequestProperty("Accept", "application/json");
					con.setDoOutput(true);
					String jsonInputString = "{ id : "+id+", promotion : "+promotion+", filiere : "+filiere+"}";
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
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		String ret = "{ \"id\": \"" + id + "\"}";
		return ret;

	}


	@Override
	public String createSession(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String changeCreneauSession(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String createSessionCreneau(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteEU(String JSONEntry) {
		// TODO Auto-generated method stub
		String intitule = null;
		String id = null;
		JSONObject obj;
		try {
			obj = new JSONObject(JSONEntry);
			try {
				id = obj.getString("id");
				intitule = obj.getString("intitule");

			} catch (JSONException e) {
				System.out.println("Unexpected json file, should be: code,intitule,cours,td,tp,valeur");

			}
			URL url;
			try {
				url = new URL ("\"http://localhost:8080/manipulUniteEnseign/delete/deletentitenseign/");
				HttpURLConnection con;
				try {
					con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("DELETE");
					con.setRequestProperty("Content-Type", "application/json; utf-8");
					con.setRequestProperty("Accept", "application/json");
					con.setDoOutput(true);
					String jsonInputString = "{ id : "+id+"}";
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
			

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		String ret = "{ \"id\": \"" + id + "\"}";

		return ret;
	
	}


	@Override
	public String deleteCreneau(String JSONEntry) {
		// TODO Auto-generated method stub
				String intitule = null;
				String id = null;
				JSONObject obj;
				try {
					obj = new JSONObject(JSONEntry);
					try {
						id = obj.getString("id");
						intitule = obj.getString("intitule");

					} catch (JSONException e) {
						System.out.println("Unexpected json file, should be: code,intitule,cours,td,tp,valeur");

					}
					URL url;
					try {
						url = new URL ("\"http://localhost:8080/manipulCreneau/delete/deletecreneau/");
						HttpURLConnection con;
						try {
							con = (HttpURLConnection)url.openConnection();
							con.setRequestMethod("DELETE");
							con.setRequestProperty("Content-Type", "application/json; utf-8");
							con.setRequestProperty("Accept", "application/json");
							con.setDoOutput(true);
							String jsonInputString = "{ id : "+id+"}";
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
					

				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				String ret = "{ \"id\": \"" + id + "\"}";

				return ret;
	}


	@Override
	public String deleteSession(String JSONEntry) {
		// TODO Auto-generated method stub
				String intitule = null;
				String id = null;
				JSONObject obj;
				try {
					obj = new JSONObject(JSONEntry);
					try {
						id = obj.getString("id");
						intitule = obj.getString("intitule");

					} catch (JSONException e) {
						System.out.println("Unexpected json file, should be: code,intitule,cours,td,tp,valeur");

					}
					URL url;
					try {
						url = new URL ("\"http://localhost:8080/manipulSession/delete/deletesession/");
						HttpURLConnection con;
						try {
							con = (HttpURLConnection)url.openConnection();
							con.setRequestMethod("DELETE");
							con.setRequestProperty("Content-Type", "application/json; utf-8");
							con.setRequestProperty("Accept", "application/json");
							con.setDoOutput(true);
							String jsonInputString = "{ id : "+id+"}";
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
					

				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				String ret = "{ \"id\": \"" + id + "\"}";

				return ret;
	}


	@Override
	public String deleteClasse(String JSONEntry) {
		// TODO Auto-generated method stub
				String intitule = null;
				String id = null;
				JSONObject obj;
				try {
					obj = new JSONObject(JSONEntry);
					try {
						id = obj.getString("id");
						intitule = obj.getString("intitule");

					} catch (JSONException e) {
						System.out.println("Unexpected json file, should be: code,intitule,cours,td,tp,valeur");

					}
					URL url;
					try {
						url = new URL ("\"http://localhost:8080/manipulClasse/delete/deleteClasse/");
						HttpURLConnection con;
						try {
							con = (HttpURLConnection)url.openConnection();
							con.setRequestMethod("DELETE");
							con.setRequestProperty("Content-Type", "application/json; utf-8");
							con.setRequestProperty("Accept", "application/json");
							con.setDoOutput(true);
							String jsonInputString = "{ id : "+id+"}";
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
					

				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				String ret = "{ \"id\": \"" + id + "\"}";

				return ret;
	}


	@Override
	public String getClasse(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getSession(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCreneau(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUE(String JSONEntry) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String listClasse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String listSession() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String listCreneau() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String listEU() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

};
