package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;

import javafx.event.ActionEvent;


public class ChoicesController {
	
	@FXML
	private Button btnMale;
	
	@FXML
	
	private Button btnFemale;
	
	@FXML
	
	private String gender;
	
	@FXML
	
	private Button btnClean;
	
	@FXML
	
	public void onActionMale(ActionEvent event) throws IOException{
		
		
		if(event.getSource() == btnMale) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/metnow?serverTimezone=UTC","root","");
				
				String query = "insert into customers(gender)values(?)";
				
				PreparedStatement pst = con.prepareStatement(query);
				Statement pst2 = con.createStatement();
				
				ResultSet rs = pst2.executeQuery("Select * FROM customers");  
							
				pst.setString(1, "Male");
				pst.execute();		
				
				if (rs.next() == false) {
					
					Alert a = new Alert(AlertType.NONE,"Tables are empty, you can sit where ever you want.", ButtonType.FINISH);
					a.setTitle("Metnow");
					a.show();
					
				} else {
					
				  do {
					  
					  Statement st = con.createStatement();
					  ResultSet rs2 = st.executeQuery("Select * from customers where gender = 'Female' ");
					  
					  if (rs2.next() == false) {
						  
						  
						  Alert b = new Alert(AlertType.NONE, "Currently there is no women sitting on the table, you can sit and wait for them", ButtonType.FINISH);
						  b.setTitle("Metnow");
						  b.show();
						  
						  
					  } else {
						  
						  do {
							  
							  Alert c = new Alert(AlertType.NONE, "There is a woman sitting on table 1, you can meet her.", ButtonType.FINISH);
							  c.setTitle("MetNow");
							  c.show();
							  
							  
							  
						  } while (rs2.next());
						  
						  break;
						  
						  
					  }
					  
				  } while (rs.next());
					
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
  
			
			
			
		}			
	}
	@FXML
	void onActionFemale(ActionEvent event) throws IOException, SQLException{
		
		if(event.getSource() == btnFemale) {
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/metnow?serverTimezone=UTC","root","");
				
				String query = "Insert into customers(gender)values(?)";
				PreparedStatement pst = con.prepareStatement(query);
				
				pst.setString(1, "Female");
				pst.execute();
				
				Statement stm = con.createStatement();
				
				ResultSet query2 = stm.executeQuery("Select * FROM customers");
				
				
				if (query2.next() == false) {
					
					
					Alert a = new Alert(AlertType.NONE, "Currently all tables are empty, you can sit where ever you want.", ButtonType.FINISH);
					a.setTitle("MetNow");
					a.show();
					
				} else {
					
					do {
						
						
						Statement stm2 = con.createStatement();
						ResultSet query3 = stm2.executeQuery("Select * From customers where gender = 'Male' ");
						
						if (query3.next() == false) {
							
							
							Alert b = new Alert(AlertType.NONE, "There is no man sitting on the table currently, you can sit where ever you like.", ButtonType.FINISH);
							b.setTitle("MetNow");
							b.show();
							
						} else {
							
							do {
								
								Alert c = new Alert(AlertType.NONE, "There is a man sitting on table 1, you can join him.", ButtonType.FINISH);
								c.setTitle("MetNow");
								c.show();
								
							} while (query3.next());
							
							break;
						}
					
	
						
						
						
						
						
					} while (query2.next());
					
				}
						
						
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
	
			
		}
	}
	@FXML
	void onActionClear(ActionEvent event) throws IOException, InterruptedException, SQLException{
		
		if(event.getSource() == btnClean) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/metnow?serverTimezone=UTC","root","");
				
				String query = "DELETE FROM customers where gender = 'Male' ";
				String query2 = "DELETE FROM customers where gender = 'Female' ";
				
				PreparedStatement ps = con.prepareStatement(query);
				PreparedStatement ps2 = con.prepareStatement(query2);
				
				ps.execute();
				ps2.execute();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Alert a = new Alert(AlertType.NONE, "All tables are cleared and empty", ButtonType.FINISH);
			
			a.setTitle("MetNow");
			a.show();
			
			
			
			
		}
	}
		
	}

