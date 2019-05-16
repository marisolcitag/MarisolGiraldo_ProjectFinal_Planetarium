package userInterface;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ArtificialSatellite;
import model.Galaxy;
import model.NaturalSatellite;
import model.Planet;
import model.Planetarium;
import model.Publicity;
import thread.PlanetariumThread;

/**
 * Clase que representa el Controlador
 * 
 */
public class PlanetariumController implements Initializable {

	// ATRIBUTOS

	@FXML
    private ImageView banner;

	/**
     * Es la Etiqueta Nombre 
     */
	@FXML
	private Label labelNombre;

	/**
     * Es la Etiqueta correspondiente a la Distancia Media al Sol
     */
	@FXML
	private Label labelDistancia;

	/**
     * Es la Etiqueta correspondiente al Excentricidad
     */
	@FXML
	private Label labelExcentricidad;

	/**
     * Es la Etiqueta correspondiente al Periodo Orbital
     */
	@FXML
	private Label labelPeriodo;

	/**
     * Es la Etiqueta correspondiente al Periodo Orbital
     */
	@FXML
	private Label labelVelocidad;

	/**
     * Es la Etiqueta correspondiente a la Inclinacion
     */
	@FXML
	private Label labelInclinacion;

	/**
     * Es el ImageView correspondiente a la Imagen
     */
	@FXML
	private ImageView imgPlaneta;

	/**
	 * Es el botón Atras
	 */
	@FXML
	private Button btAtras;

	/**
	 * Es el botón Buscar
	 */
	@FXML
	private Button bBuscar;

	/**
	 * Es el botón Avanzar
	 */
	@FXML
	private Button btAvanzar;
	
	/**
	 * Es el botón Opcion1
	 */
	@FXML
    private Button btOpcion1;

	/**
	 * Es el botón Opcion2
	 */
    @FXML
    private Button btOpcion2;
    
    @FXML
    private Button btNasa;
    
    @FXML
    private Button btSolarSystem;
 
    @FXML
    private ImageView imgPublicity;
    
    private Galaxy myGalaxy;
    
    /**
	 * Objeto de la Clase Principal del Mundo - Planetario.
	 */
	private Planetarium miPlanetario;

	/**
	 * indice Planeta
	 */
	private int numeroPlanetaActual;

	/**
	 * Atributo tipo Planeta 
	 */	
	private Planet planetaActual;
	
	 @FXML
	private ListView<Galaxy> listViewGalaxy;
	 
	@FXML
    private ListView listViewNaturalSatellite;
	
	private NaturalSatellite naturalS;
	
	private Publicity myPublicity;
	

	// METODOS
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		miPlanetario = new Planetarium();
		ArrayList<Galaxy> galaxies = miPlanetario.getGalaxies();
		ObservableList<Galaxy> items =FXCollections.observableArrayList (
		    galaxies.get(0), galaxies.get(1));
		listViewGalaxy.setItems(items);
		listViewGalaxy.getSelectionModel().select(0);
		listViewGalaxy.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				loadData();
			}
		});
		loadData();
		
		PlanetariumThread publicityThread = new PlanetariumThread(this);
		publicityThread.start();
		
	}
	
	public void loadData() {
		Planet miPlaneta = miPlanetario.getMyFirstPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName());
		planetaActual= miPlaneta;
		myPublicity = miPlanetario.getPublicity();
		
		labelNombre.setText(miPlaneta.getName().toString());
		labelDistancia.setText(String.valueOf(miPlaneta.getAverageDistanceSun() + "UA"));
		labelExcentricidad.setText(String.valueOf(miPlaneta.getEccentricity()));
		labelPeriodo.setText(String.valueOf(miPlaneta.getOrbitalPeriod() + " días"));
		labelVelocidad.setText(String.valueOf(miPlaneta.getOrbitalVelocity() + " km/s"));
		labelInclinacion.setText(String.valueOf(miPlaneta.getInclineOrbital() + " °"));
		File ruta = new File(miPlaneta.getImage());
		imgPlaneta.setImage(new Image(ruta.toURI().toString()));
		numeroPlanetaActual = 0;
		btAtras.setDisable(true);
	}
	
	/**
     * Metodo: getLabelNombre()
     * Descripcion: Este Metodo se encarga de Retornar el Nombre del Planeta
     * @return nombre - Retorna el nombre del deportista.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelNombre() {
		return labelNombre;
	}
	
	/**
     * Metodo: setLabelNombre
     * Descripcion: Este Metodo se encarga de Modificar  el Nombre del Planeta
     * @param nombre Nuevo nombre.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setLabelNombre(Label labelNombre) {
		this.labelNombre = labelNombre;
	}

	/**
     * Metodo: getLabelDistancia()
     * Descripcion: Este Metodo se encarga de Retornar la distancia del Planeta
     * @return nombre - Retorna el nombre del deportista.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelDistancia() {
		return labelDistancia;
	}

	public void setLabelDistancia(Label labelDistancia) {
		this.labelDistancia = labelDistancia;
	}

	/**
     * Metodo: getLabelExcentricidad()
     * Descripcion: Este Metodo se encarga de Retornar el Label de la Excentricidad del Planeta
     * @return excentricidad - Retorna el valor del Label de la excentricididad del Planeta
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelExcentricidad() {
		return labelExcentricidad;
	}

	/**
     * Metodo: setLabelExcentricidad()
     * Descripcion: Este Metodo se encarga de Modificar el Label de la Excentricidad del Planeta
     * @param excentricidadP Nueva Excentricidad.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setLabelExcentricidad(Label labelExcentricidad) {
		this.labelExcentricidad = labelExcentricidad;
	}

	/**
     * Metodo: getLabelPeriodo()
     * Descripcion: Este Metodo se encarga de Retornar el Label de Periodo Orbital
     * @return periodoOrbital - Retorna el valor del Label Periodo Orbital (Sinódico)
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelPeriodo() {
		return labelPeriodo;
	}

	/**
     * Metodo: setLabelPeriodo()
     * Descripcion: Este Metodo se encarga de Modificar el valor del Label del Periodo Orbital
     * @param periodoOrbitalSinodico -  Nuevo Periodo Orbital Sinodial.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setLabelPeriodo(Label labelPeriodo) {
		this.labelPeriodo = labelPeriodo;
	}

	/**
     * Metodo: getLabelVelocidad()
     * Descripcion: Este Metodo se encarga de Retornar el Label de la Velocidad Orbital
     * @return valocidadOrbitalP - Retorna el valor del Label de la Velocidad Orbital (Sinódico)
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelVelocidad() {
		return labelVelocidad;
	}

	/**
     * Metodo: setLabelVelocidad()
     * Descripcion: Este Metodo se encarga de Modificar el valor del Label de la Velocidad Orbital Media
     * @param velocidadOrbitalMediaP -  Nueva Velocidad Orbital Media.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setLabelVelocidad(Label labelVelocidad) {
		this.labelVelocidad = labelVelocidad;
	}

	/**
     * Metodo: getLabelInclinacion()
     * Descripcion: Este Metodo se encarga de Retornar el Label de la Inclinacion Orbital
     * @return inclinacion - Retorna el valor del Label de la Inclinacion
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Label getLabelInclinacion() {
		return labelInclinacion;
	}

	/**
     * Metodo: setLabelInclinacion()
     * Descripcion: Este Metodo se encarga de Modificar el valor del Label de la Inclinacion
     * @param inclinacionP - Nueva Inclinacion
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setLabelInclinacion(Label labelInclinacion) {
		this.labelInclinacion = labelInclinacion;
	}

	/**
     * Metodo: getMiPlanetario()
     * Descripcion: Este Metodo se encarga de retornar el Planetario
     * @return miPlanetario - Retorna el Planetario
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public Planetarium getMiPlanetario() {
		return miPlanetario;
	}

	/**
     * Metodo: setMiPlanetario()
     * Descripcion: Este Metodo se encarga de Modificar el Planetario
     * @param miPlanetario - Nuevo Planetario
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setMiPlanetario(Planetarium miPlanetario) {
		this.miPlanetario = miPlanetario;
	}

	/**
	 * Nombre:miBotonBuscar() Descripción: Método para el Botón Buscar- Busca el Planeta que le Pida por Cuadro de Texto
	 * 	 * @param nombreP - Nombre del Planeta a Buscar
	 * @return resultado - Despliega la Información de Planeta que le Solicite
	 * @linecode : 10 Lineas
	 * @devtime : 15 Minutos
	 */
	public void miBotonBuscar(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Buscar Planeta");
		dialog.setHeaderText("Ingrese el Nombre del Planeta a Buscar:");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();
			Planet miPlaneta = miPlanetario.searchPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName(),entered);
			if (miPlaneta == null) {
				String mensaje = "El Planeta con Nombre " + entered + " no fue posible encontrarlo en este Sistema Solar";
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setContentText(mensaje);
				alerta.showAndWait();
			} else {
				labelNombre.setText(miPlaneta.getName().toString());
				labelDistancia.setText(String.valueOf(miPlaneta.getAverageDistanceSun() + "UA"));
				labelExcentricidad.setText(String.valueOf(miPlaneta.getEccentricity()));
				labelPeriodo.setText(String.valueOf(miPlaneta.getOrbitalPeriod() + " días"));
				labelVelocidad.setText(String.valueOf(miPlaneta.getOrbitalVelocity() + " km/s"));
				labelInclinacion.setText(String.valueOf(miPlaneta.getInclineOrbital() + " °"));
				File ruta = new File(miPlaneta.getImage());
				imgPlaneta.setImage(new Image(ruta.toURI().toString()));
			}
		}
	}
	
	/**Metodo: actualizar()
	 * Descripción: Actualiza la información del Planeta despues de Avanzar o Retroceder.
	 * <b>post:</b> - Actualiza la Información del Planeta
	 * @linecode : 14 Lineas
	 * @devtime : 20 Minutos
	 */
	public void actualizar() {
		//planetaActual=miPlanetario.darPlanetas()[posicion];
		labelNombre.setText(planetaActual.getName().toString());
		labelDistancia.setText(String.valueOf(planetaActual.getAverageDistanceSun() + "UA"));
		labelExcentricidad.setText(String.valueOf(planetaActual.getEccentricity()));
		labelPeriodo.setText(String.valueOf(planetaActual.getOrbitalPeriod() + " días"));
		labelVelocidad.setText(String.valueOf(planetaActual.getOrbitalVelocity() + " km/s"));
		labelInclinacion.setText(String.valueOf(planetaActual.getInclineOrbital() + " °"));
		File ruta = new File(planetaActual.getImage());
		imgPlaneta.setImage(new Image(ruta.toURI().toString()));		
	}
	
	/**Metodo: anteriorPlaneta()
	 * Descripción: Muestra el Planeta Anterior al que tengo en Pantalla
	 * <b>post:</b> - Despliega la Información de Planeta Anterior al que tengo en Pantalla
	 * @linecode : 4 Lineas
	 * @devtime : 10 Minutos
	 */
	public void anteriorPlaneta(ActionEvent event) {
		numeroPlanetaActual--;
		
		if( planetaActual.getPrevious()==null )
		{
			btAtras.setDisable(true);
			actualizar();
			
		}
		else {
			planetaActual=planetaActual.getPrevious();
			actualizar();		
			btAvanzar.setDisable(false);
		}
	}
	
	/**Metodo: siguientePlaneta()
	 * Descripción: Muestra el Planeta Siguiente al que tengo en Pantalla
	 * <b>post:</b> - Despliega la Información de Planeta siguiente al que tengo en Pantalla
	 * @linecode : 4 Lineas
	 * @devtime : 10 Minutos
	 */
	public void siguientePlaneta(ActionEvent event) {
		numeroPlanetaActual++;
		
		if( planetaActual.getNext()==null)
		{
			btAvanzar.setDisable(true);
			actualizar();
		}
		else {
			planetaActual=planetaActual.getNext();
				actualizar();
		btAtras.setDisable(false);
		}
	}
	
	/**
	 * Nombre:miBotonOpcion1()
	 * Descripción: Método para el Botón Opcion 1 - Informa el Planeta de Mayor Inclinacion
	 * @return resultado - un mensaje informando el Planeta de Mayor Inclinacion
	 * @linecode : 5 Lineas
	 * @devtime : 15 Minutos
	 */
	public void miBotonOpcion1(ActionEvent event) {
		
		Planet miPlaneta = miPlanetario.planetHigherInclination(listViewGalaxy.getSelectionModel().getSelectedItem().getName());
		
		String mensaje = "El Planeta " + miPlaneta.getName()+ " tiene una inclinación de: " +miPlaneta.getInclineOrbital();
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Planeta con Mayor Inclinación");
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}
	
	/**Nombre:miBotonOpcion2()
	 * Descripción: Método para el Botón Buscar- Busca el Planeta que le Pida por Cuadro de Texto
	 * <b>post:</b> - Despliega la Información de Planeta que le Solicite
	 * @linecode : 7 Lineas
	 * @devtime : 15 Minutos
	 */	
	public void miBotonOpcion2(ActionEvent event) {
		
		//Planet miPlanetaTierra = miPlanetario.searchPlanet((String)listViewGalaxy.getSelectionModel().getSelectedItem(),Galaxy.NOMBRE_TIERRA);		
		Planet miPlanetaX = miPlanetario.searchPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName(),labelNombre.getText());		
			
		//double distanciaTierra = miPlanetaTierra.getAverageDistanceSun();		
		double distanciaX = miPlanetaX.getAverageDistanceSun();		
		//double distancia = Math.abs(distanciaTierra - distanciaX);
		
		//String mensaje = "La distancia entre " + miPlanetaX.darNombre()+ " a la Tierra es de : " +distancia+ "UA.";
		String mensaje = "La distancia entre " + miPlanetaX.getName()+ " al Sol es de : " +distanciaX+ "UA.";

		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Distancia a la Tierra");
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}
	
	/**Nombre:botonNasa()
	 * Descripción: Método que implementa el Botón Nasa 
	 * <b>post:</b> - Despliega la ventana de un navegador en www.nasa.gov
	 * @linecode : 7 Lineas
	 * @devtime : 15 Minutos
	 */	

	public void botonNasa(ActionEvent event) {
		
		Stage stageNasa = new Stage();
		// Create the WebView
        WebView webView = new WebView();
         
        // Create the WebEngine
        final WebEngine webEngine = webView.getEngine();
 
        // LOad the Start-Page
        webEngine.load("https://www.nasa.gov/");
         
        // Update the stage title when a new web page title is available
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() 
        {
            public void changed(ObservableValue<? extends State> ov, State oldState, State newState) 
            {
                if (newState == State.SUCCEEDED) 
                {
                    //stage.setTitle(webEngine.getLocation());
                    stageNasa.setTitle(webEngine.getTitle());
                }
            }
        });
 
        // Create the VBox
        VBox root = new VBox();
        // Add the WebView to the VBox
        root.getChildren().add(webView);
 
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Add  the Scene to the Stage
        stageNasa.setScene(scene);
        // Display the Stage
        stageNasa.show();
    }
	
	
	@FXML
    void botonSimulation(ActionEvent event) {

    }
	
	// Ordenamiento Galaxias
	@FXML
    void orderGByName(ActionEvent event) {
		
		

    }
		
	@FXML
    void orderByNumPlanets(ActionEvent event) {

    }

	
	// Ordenamiento Satelites Natural
	@FXML
    void orderSByName(ActionEvent event) {
		

    }
		
	@FXML
    void orderByEccentricity(ActionEvent event) {

    }

    @FXML
    void orderByIOrbital(ActionEvent event) {

    }

    

	public void setImage(Image a) {
		// TODO Auto-generated method stub
		  imgPublicity.setImage(a);	
	}
	
	//ACTION BUTTONS GALAXY - ADD , DELETE
	
	 @FXML
	 public void addGalaxy(ActionEvent event) {
		 Dialog<Galaxy> dialog = new Dialog<>();
		 dialog.setTitle("Agregar Galaxia");
		 dialog.setHeaderText("Ingrese la Información de la Galaxia");
		 dialog.setResizable(true);
		  
		 Label label1 = new Label("Nombre de la Galaxia: ");
		 Label label2 = new Label("Numero de Planetas en la Galaxia: ");
		 TextField text1 = new TextField();
		 TextField text2 = new TextField();
		          
		 GridPane grid = new GridPane();
		 grid.add(label1, 1, 1);
		 grid.add(text1, 2, 1);
		 grid.add(label2, 1, 2);
		 grid.add(text2, 2, 2);
		 dialog.getDialogPane().setContent(grid);
		          
		 ButtonType buttonTypeOk = new ButtonType("Aceptar", ButtonData.OK_DONE);
		 ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		 
		 dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		 dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
		  
		 dialog.setResultConverter(new Callback<ButtonType, Galaxy>() {
		     @Override
		     public Galaxy call(ButtonType b) {
		  
		         if (b == buttonTypeOk) {
		        	 try {
		        	 String gName= text1.getText();
		        	 String gNum= text2.getText();
		        	 Galaxy g = new Galaxy(gName,Integer.parseInt(gNum));
		        	 ArrayList<Galaxy> galaxies = miPlanetario.getGalaxies();
		        	 galaxies.add(g);
		     		 ObservableList<Galaxy> itemsGalaxy =FXCollections.observableArrayList ();
		     		 for (int i=0; i<galaxies.size();i++) {
		     			 System.out.println(galaxies.get(i));
		     			 itemsGalaxy.add(galaxies.get(i));
		     		 }
		     		listViewGalaxy.setItems(itemsGalaxy);
		    		listViewGalaxy.getSelectionModel().select(0);
		    		listViewGalaxy.setOnMouseClicked(new EventHandler<Event>() {
		    			@Override
		    			public void handle(Event event) {
		    				itemsGalaxy.setAll(galaxies);
		    				galaxies.clear();
		    			}
		    		});
		    		//listViewGalaxy.refresh();
		    		loadData();
			        // System.out.print("Name"+gName+"NumP"+gNum); 
		        	 }
		        	 catch (NumberFormatException e) {
						// TODO: handle exception
		        		 JOptionPane.showMessageDialog(null, "Por Favor Ingrese en el campo NUMERO DE PLANETAS EN LA GALAXIA un NUMERO ENTERO");
					}
		         }
		         else if (b==buttonTypeCancel) {
		        	 dialog.close();
		         }
		  
		         return null;
		     }
		 });
		          
		 Optional<Galaxy> result = dialog.showAndWait();         
	 }
	
	 @FXML
	 void deleteGalaxy(ActionEvent event) {
		 Dialog<Galaxy> dialog = new Dialog<>();
		 dialog.setTitle("Eliminar Galaxia");
		 dialog.setHeaderText("Ingrese la Información de la Galaxia");
		 dialog.setResizable(true);
		  
		 Label label1 = new Label("Nombre de la Galaxia: ");
		 Label label2 = new Label("Numero de Planetas en la Galaxia: ");
		 TextField text1 = new TextField();
		 TextField text2 = new TextField();
		          
		 GridPane grid = new GridPane();
		 grid.add(label1, 1, 1);
		 grid.add(text1, 2, 1);
		 grid.add(label2, 1, 2);
		 grid.add(text2, 2, 2);
		 dialog.getDialogPane().setContent(grid);
		          
		 ButtonType buttonTypeOk = new ButtonType("Aceptar", ButtonData.OK_DONE);
		 ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		 
		 dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		 dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
		  
		 dialog.setResultConverter(new Callback<ButtonType, Galaxy>() {
		     @Override
		     public Galaxy call(ButtonType b) {
		  
		         if (b == buttonTypeOk) {
		        	 try {
		        	 String gName= text1.getText();
		        	 String gNum= text2.getText();
		        	 Galaxy g = new Galaxy(gName,Integer.parseInt(gNum));
		        	 ArrayList<Galaxy> galaxies = miPlanetario.getGalaxies();
		        	 galaxies.remove(g);
		     		 ObservableList items =FXCollections.observableArrayList ();
		     		 for (int i=0; i<galaxies.size();i++) {
		     			 items.remove(galaxies.get(i).getName());
		     		 }
		     		listViewNaturalSatellite.setItems(items);
		    		listViewNaturalSatellite.getSelectionModel().select(0);
		    		listViewNaturalSatellite.setOnMouseClicked(new EventHandler<Event>() {
		    			@Override
		    			public void handle(Event event) {
		    				items.setAll(galaxies);
		    				galaxies.clear();
		    			}
		    		});
		    		loadData();
			         System.out.print("Name"+gName+"NumP"+gNum); 
		        	 }
		        	 catch (NumberFormatException e) {
						// TODO: handle exception
		        		 JOptionPane.showMessageDialog(null, "Por Favor Ingrese en el campo NUMERO DE PLANETAS EN LA GALAXIA un NUMERO ENTERO");
					}
		         }
		         else if (b==buttonTypeCancel) {
		        	 dialog.close();
		         }
		  
		         return null;
		     }
		 });
		          
		 Optional<Galaxy> result = dialog.showAndWait();  
	 }
	 	

	//ACTION BUTTONS NATURAL SATELLITE - ADD , DELETE
	
	@FXML
    void addNSatellite(ActionEvent event) {
		
		Dialog<NaturalSatellite> dialog = new Dialog<>();
		dialog.setTitle("Agregar Satelite Natural");
		dialog.setHeaderText("Ingrese la Información del Satelite Natural");
		dialog.setResizable(true);
		  
		Label label1 = new Label("Nombre del Satelite: ");
		Label label2 = new Label("Estado: ");
		Label label3 = new Label("Area: ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		TextField text3 = new TextField();
		          
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2, 2, 2);
		grid.add(label3, 1, 3);
		grid.add(text3, 2, 3);
		
		dialog.getDialogPane().setContent(grid);
		          
		ButtonType buttonTypeOk = new ButtonType("Aceptar", ButtonData.OK_DONE);
		ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		 
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
		 
		dialog.setResultConverter(new Callback<ButtonType, NaturalSatellite>() {
		    @Override
		    public NaturalSatellite call(ButtonType b) {
		  
		        if (b == buttonTypeOk) {	
		        	 String sName= text1.getText();
		        	 String sStatus= text2.getText();
		        	 int sArea = Integer.parseInt(text3.getText());
		        	 
		        	 NaturalSatellite s = new NaturalSatellite(sName, sStatus,sArea);
		        	 
		        }
		        else if (b==buttonTypeCancel) {
		       	 dialog.close();
		        }
		  
		        return null;
		    }
		});
		          
		Optional<NaturalSatellite> result = dialog.showAndWait(); 
    }
	
    
    @FXML
    void deleteNSatellite(ActionEvent event) {

    }
    
  //ACTION BUTTONS ARTIFICIAL SATELLITE - ADD  DELETE
	
  	@FXML
      void addASatellite(ActionEvent event) {
  		
  		Dialog<ArtificialSatellite> dialog = new Dialog<>();
		dialog.setTitle("Agregar Satelite Artificial");
		dialog.setHeaderText("Ingrese la Información del Satelite Artificial");
		dialog.setResizable(true);
		  
		Label label1 = new Label("Nombre del Satelite: ");
		Label label2 = new Label("Estado: ");
		Label label3 = new Label("Area: ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		
		//ComboBox ServiceType
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "MILITAR",
			        "COMUNICACIÓN",
			        "METEOROLÓGICO"
			    );
		final ComboBox comboBox = new ComboBox(options);
		//Final ComboBox ServiceType
		
		          
		GridPane grid = new GridPane();
		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2, 2, 2);
		grid.add(label3, 1, 3);
		grid.add(comboBox, 2, 3);
		
		dialog.getDialogPane().setContent(grid);
		          
		ButtonType buttonTypeOk = new ButtonType("Aceptar", ButtonData.OK_DONE);
		ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		 
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
		 
		dialog.setResultConverter(new Callback<ButtonType, ArtificialSatellite>() {
		    @Override
		    public ArtificialSatellite call(ButtonType b) {
		  
		        if (b == buttonTypeOk) {		  
		           
		            
		        }
		        else if (b==buttonTypeCancel) {
		       	 dialog.close();
		        }
		  
		        return null;
		    }
		});
		          
		Optional<ArtificialSatellite> result = dialog.showAndWait(); 
  	}
  	  
    @FXML
    void deleteASatellite(ActionEvent event) {

    }
 
}
