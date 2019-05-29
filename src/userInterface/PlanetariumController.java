package userInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ArtificialSatellite;
import model.ArtificialSatellite.serviceType;
import model.Galaxy;
import model.NaturalSatellite;
import model.Planet;
import model.Planetarium;
import model.Publicity;
import model.Satellite;
import thread.PlanetariumThread;
import java.awt.image.RenderedImage;

/**
 * Controller Class
 */
public class PlanetariumController implements Initializable {

	// ATRIBUTTES

	@FXML
    private ImageView banner;

	/**
     * Label Name
     */
	@FXML
	private Label labelName;

	/**
     * Label Distance
     */
	@FXML
	private Label labelAverageDistanceSun;

	/**
     * Label Eccentricity
     */
	@FXML
	private Label labelEccentricity;

	/**
     * Label Orbital Period
     */
	@FXML
	private Label labelOrbitalPeriod;

	/**
     * Label Orbital Velocity
     */
	@FXML
	private Label labelOrbitalVelocity;

	/**
     * Label Incline Orbital
     */
	@FXML
	private Label labelInclineOrbital;

	/**
     * ImageView 
     */
	@FXML
	private ImageView imageSource;

	/**
	 * Button Back
	 */
	@FXML
	private Button btBack;

	/**
	 * Button Search
	 */
	@FXML
	private Button btSearch;

	/**
	 * Button Forward
	 */
	@FXML
	private Button btForward;
	
	/**
	 * Button Inclination
	 */
	@FXML
    private Button btInclination;

	/**
	 * Button AverageDistanceSun
	 */
    @FXML
    private Button btAverageDistanceSun;
    
    /**
	 * Button Nasa
	 */
    @FXML
    private Button btNasa;
    
    /**
	 * Button Paint Solar System
	 */
    @FXML
    private Button btSolarSystem;
 
    /**
	 * Image Publicity
	 */
    @FXML
    private ImageView imgPublicity;
    	
	 @FXML
	private ListView<Galaxy> listViewGalaxy;
	 
	@FXML
    private ListView listViewNaturalSatellite;
	
	@FXML 
	private ListView listViewArtificialSatellite;
	
	private Planetarium myPlanetarium;
	
	private int numCurrentPlanet;

	private Planet currentPlanet;
	
	private NaturalSatellite naturalS;
	
	private Publicity myPublicity;
	
	// METHODS
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myPlanetarium = new Planetarium();
		ArrayList<Galaxy> galaxies = myPlanetarium.getGalaxies();
		ObservableList<Galaxy> items =FXCollections.observableArrayList (
		    galaxies.get(0), galaxies.get(1));
		listViewGalaxy.setItems(items);
		listViewGalaxy.getSelectionModel().select(0);
		listViewGalaxy.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				loadData();
			}
		});
		loadData();
		
		PlanetariumThread publicityThread = new PlanetariumThread(this);
		publicityThread.start();		
	}
	
	public void loadData() {
		Planet miPlanet = myPlanetarium.getMyFirstPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName());
		currentPlanet= miPlanet;
		myPublicity = myPlanetarium.getPublicity();
		
		labelName.setText(miPlanet.getName().toString());
		labelAverageDistanceSun.setText(String.valueOf(miPlanet.getAverageDistanceSun() + "UA"));
		labelEccentricity.setText(String.valueOf(miPlanet.getEccentricity()));
		labelOrbitalPeriod.setText(String.valueOf(miPlanet.getOrbitalPeriod() + " días"));
		labelOrbitalVelocity.setText(String.valueOf(miPlanet.getOrbitalVelocity() + " km/s"));
		labelInclineOrbital.setText(String.valueOf(miPlanet.getInclineOrbital() + " °"));
		File path = new File(miPlanet.getImage());
		imageSource.setImage(new Image(path.toURI().toString()));
		numCurrentPlanet = 0;
		btBack.setDisable(true);
	}
	
	public Label getLabelName() {
		return labelName;
	}
	
	public void setLabelName(Label labelName) {
		this.labelName = labelName;
	}

	public Label getLabelAverageDistanceSun() {
		return labelAverageDistanceSun;
	}

	public void setLabelAverageDistanceSun(Label labelDistance) {
		this.labelAverageDistanceSun = labelDistance;
	}

	public Label getLabelEccentricity() {
		return labelEccentricity;
	}

	public void setLabelEccentricity(Label labelExcentricidad) {
		this.labelEccentricity = labelExcentricidad;
	}

	public Label getLabelOrbitalPeriod() {
		return labelOrbitalPeriod;
	}

	public void setLabelOrbitalPeriod(Label labelOrbitalPeriod) {
		this.labelOrbitalPeriod = labelOrbitalPeriod;
	}

	public Label getLabelOrbitalVelocity() {
		return labelOrbitalVelocity;
	}

	public void setLabelOrbitalVelocity(Label labelOrbitalVelocity) {
		this.labelOrbitalVelocity = labelOrbitalVelocity;
	}

	public Label getLabelInclineOrbital() {
		return labelInclineOrbital;
	}

	public void setLabelInclineOrbital(Label labelInclineOrbital) {
		this.labelInclineOrbital = labelInclineOrbital;
	}

	public Planetarium getMyPlanetarium() {
		return myPlanetarium;
	}

	public void setMyPlanetarium(Planetarium myPlanetarium) {
		this.myPlanetarium = myPlanetarium;
	}

	@FXML
	void btSearch(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Buscar Planeta");
		dialog.setHeaderText("Ingrese el Nombre del Planeta a Buscar:");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";

		if (result.isPresent()) {
			entered = result.get();
			Planet myPlanet = myPlanetarium.searchPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName(),entered);
			if (myPlanet == null) {
				String message = "El Planeta con Nombre " + entered + " no fue posible encontrarlo en este Sistema Solar";
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(message);
				alert.showAndWait();
			} else {
				labelName.setText(myPlanet.getName().toString());
				labelAverageDistanceSun.setText(String.valueOf(myPlanet.getAverageDistanceSun() + "UA"));
				labelEccentricity.setText(String.valueOf(myPlanet.getEccentricity()));
				labelOrbitalPeriod.setText(String.valueOf(myPlanet.getOrbitalPeriod() + " días"));
				labelOrbitalVelocity.setText(String.valueOf(myPlanet.getOrbitalVelocity() + " km/s"));
				labelInclineOrbital.setText(String.valueOf(myPlanet.getInclineOrbital() + " °"));
				File path = new File(myPlanet.getImage());
				imageSource.setImage(new Image(path.toURI().toString()));
			}
		}
	}
	
	public void update() {
		labelName.setText(currentPlanet.getName().toString());
		labelAverageDistanceSun.setText(String.valueOf(currentPlanet.getAverageDistanceSun() + "UA"));
		labelEccentricity.setText(String.valueOf(currentPlanet.getEccentricity()));
		labelOrbitalPeriod.setText(String.valueOf(currentPlanet.getOrbitalPeriod() + " días"));
		labelOrbitalVelocity.setText(String.valueOf(currentPlanet.getOrbitalVelocity() + " km/s"));
		labelInclineOrbital.setText(String.valueOf(currentPlanet.getInclineOrbital() + " °"));
		File ruta = new File(currentPlanet.getImage());
		imageSource.setImage(new Image(ruta.toURI().toString()));		
	}
	
	@FXML
	void btBack(ActionEvent event) {
		numCurrentPlanet--;
		
		if( currentPlanet.getPrevious()==null )
		{
			btBack.setDisable(true);
			update();
			
		}
		else {
			currentPlanet=currentPlanet.getPrevious();
			update();		
			btForward.setDisable(false);
		}
	}
	
	@FXML
	void btForward(ActionEvent event) {
		numCurrentPlanet++;
		
		if( currentPlanet.getNext()==null)
		{
			btForward.setDisable(true);
			update();
		}
		else {
			currentPlanet=currentPlanet.getNext();
				update();
		btBack.setDisable(false);
		}
	}
		
	@FXML
	void btAverageDistanceSun(ActionEvent event) {
		
		Planet miPlanet = myPlanetarium.planetHigherInclination(listViewGalaxy.getSelectionModel().getSelectedItem().getName());
		
		String message = "El Planeta " + miPlanet.getName()+ " tiene una inclinación de: " +miPlanet.getInclineOrbital();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Planeta con Mayor Inclinación");
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	@FXML
	void btInclination(ActionEvent event) {
		
		Planet miPlanetaX = myPlanetarium.searchPlanet(listViewGalaxy.getSelectionModel().getSelectedItem().getName(),labelName.getText());		
			
		//double distanciaTierra = miPlanetaTierra.getAverageDistanceSun();		
		double distanciaX = miPlanetaX.getAverageDistanceSun();		
		//double distancia = Math.abs(distanciaTierra - distanciaX);
		
		//String mensaje = "La distancia entre " + miPlanetaX.darNombre()+ " a la Tierra es de : " +distancia+ "UA.";
		String message = "La distancia entre " + miPlanetaX.getName()+ " al Sol es de : " +distanciaX+ "UA.";

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Distancia a la Tierra");
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	@FXML
	void btNasa(ActionEvent event) {
		
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
    void btPaint(ActionEvent event) {
		
		/* ----------STAGE & SCENE---------- */
        BorderPane pane = new BorderPane();      
        Scene scene = new Scene(pane, 600, 400);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Dibuja Tu Sistema Solar");
        primaryStage.setScene(scene);
        primaryStage.show();
    
		/* BOTONES */
        ToggleButton drowbtn = new ToggleButton("Dibuja");
        ToggleButton rubberbtn = new ToggleButton("Borra");
        ToggleButton linebtn = new ToggleButton("Linea");
        ToggleButton circlebtn = new ToggleButton("Circulo");
        ToggleButton elpslebtn = new ToggleButton("Elipse");
        
        ToggleButton[] toolsArr = {drowbtn, rubberbtn, linebtn, circlebtn, elpslebtn};
        
        ToggleGroup tools = new ToggleGroup();
        
        for (ToggleButton tool : toolsArr) {
            tool.setMinWidth(90);
            tool.setToggleGroup(tools);
            tool.setCursor(Cursor.HAND);
        }
        
        ColorPicker cpLine = new ColorPicker(Color.BLACK);
        ColorPicker cpFill = new ColorPicker(Color.TRANSPARENT);
        
        Label line_color = new Label("Color Linea");
        Label fill_color = new Label("Color Relleno");
        
        Button save = new Button("Guardar Archivo");
        Button open = new Button("Abrir Archivo");
        
        Button[] basicArr = {save, open};
        
        for(Button btn : basicArr) {
            btn.setMinWidth(90);
            btn.setCursor(Cursor.HAND);
            btn.setTextFill(Color.WHITE);
            btn.setStyle("-fx-background-color: #666;");
        }
        save.setStyle("-fx-background-color: #80334d;");
        open.setStyle("-fx-background-color: #80334d;");
        
        VBox btns = new VBox(10);
        btns.getChildren().addAll(drowbtn, rubberbtn, linebtn,circlebtn, elpslebtn,
                line_color, cpLine, fill_color, cpFill, open, save);
        btns.setPadding(new Insets(5));
        btns.setStyle("-fx-background-color: #999");
        btns.setPrefWidth(100);
        
        /* CANVAS */
        Canvas canvas = new Canvas(1080, 790);
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        
        Line line = new Line();
        Circle circ = new Circle();
        Ellipse elps = new Ellipse();
        
        canvas.setOnMousePressed(e->{
            if(drowbtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.beginPath();
                gc.lineTo(e.getX(), e.getY());
            }
            else if(rubberbtn.isSelected()) {
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
            else if(linebtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                line.setStartX(e.getX());
                line.setStartY(e.getY());
            }	            
            else if(circlebtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.setFill(cpFill.getValue());
                circ.setCenterX(e.getX());
                circ.setCenterY(e.getY());
            }
            else if(elpslebtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.setFill(cpFill.getValue());
                elps.setCenterX(e.getX());
                elps.setCenterY(e.getY());
            }
        });
        
        canvas.setOnMouseDragged(e->{
            if(drowbtn.isSelected()) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
            else if(rubberbtn.isSelected()){
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
        });
        
        canvas.setOnMouseReleased(e->{
            if(drowbtn.isSelected()) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
                gc.closePath();
            }
            else if(rubberbtn.isSelected()) {
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
            else if(linebtn.isSelected()) {
                line.setEndX(e.getX());
                line.setEndY(e.getY());
                gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());	                
            }
            else if(circlebtn.isSelected()) {
                circ.setRadius((Math.abs(e.getX() - circ.getCenterX()) + Math.abs(e.getY() - circ.getCenterY())) / 2);
                
                if(circ.getCenterX() > e.getX()) {
                    circ.setCenterX(e.getX());
                }
                if(circ.getCenterY() > e.getY()) {
                    circ.setCenterY(e.getY());
                }          
                gc.fillOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());
                gc.strokeOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());                
            }
            else if(elpslebtn.isSelected()) {
                elps.setRadiusX(Math.abs(e.getX() - elps.getCenterX()));
                elps.setRadiusY(Math.abs(e.getY() - elps.getCenterY()));
                
                if(elps.getCenterX() > e.getX()) {
                    elps.setCenterX(e.getX());
                }
                if(elps.getCenterY() > e.getY()) {
                    elps.setCenterY(e.getY());
                }
                gc.strokeOval(elps.getCenterX(), elps.getCenterY(), elps.getRadiusX(), elps.getRadiusY());
                gc.fillOval(elps.getCenterX(), elps.getCenterY(), elps.getRadiusX(), elps.getRadiusY());         
            }   
        });
        
        pane.setLeft(btns);
        pane.setCenter(canvas);
        
        /* COLOR PICKER*/
        cpLine.setOnAction(e->{
                gc.setStroke(cpLine.getValue());
        });
        cpFill.setOnAction(e->{
                gc.setFill(cpFill.getValue());
        });
        
        /* OPEN BUTTON*/
        open.setOnAction((e)->{
            FileChooser openFile = new FileChooser();
            openFile.setTitle("Abrir Archivo");
            File file = openFile.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    InputStream io = new FileInputStream(file);
                    Image img = new Image(io);
                    gc.drawImage(img, 0, 0);
                } catch (IOException ex) {
                    System.out.println("Error al Abrir el Archivo!");
                }
            }
        });

        /* SAVE BOTON */
        save.setOnAction((e)->{
        	FileChooser savefile = new FileChooser();
        	savefile.setTitle("Guardar Archivo");
    
        	File file = savefile.showSaveDialog(primaryStage);
        	if (file != null) {
        		try {
        			WritableImage writableImage = new WritableImage(1080, 790);
        			canvas.snapshot(null, writableImage);
        			RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
        			ImageIO.write(renderedImage, "png", file);
        		} catch (IOException ex) {
        			System.out.println("Error al Guardar el Archivo!");
        		}
        	}
        });
    }
	
	@FXML
    void btConstellations(ActionEvent event) {
		
		/* CANVAS*/ 
        final int CANVAS_WIDTH = 800;
        final int CANVAS_HEIGHT = 600;
        final int POINT_WIDTH = 6;
        final int POINT_HEIGHT = POINT_WIDTH;
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(800, 600); 
        Stage stage = new Stage();
        stage.setTitle("Constelaciones"); 
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        /* STARS*/ 
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        Scanner input = new Scanner(System.in);
 
        // Ask user for the x,y coordinates for the start of the line
        System.out.print("Ingrese la coordenada x y la coordenada y para el punto 1: ");
        int x1 = input.nextInt();
        int y1 = input.nextInt();

        // Ask the user for the x, y coordinates for the end of the line
        System.out.print("Ingrese la coordenada x y la coordenada y para el punto 2: ");
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        // Ask the user for the x, y coordinates for the end of the line
        System.out.print("Ingrese la coordenada x y la coordenada y para el punto 3: ");
        int x3 = input.nextInt();
        int y3 = input.nextInt();

        // Ask the user for the x, y coordinates for the end of the line
        System.out.print("Ingrese la coordenada x y la coordenada y para el punto 4: ");
        int x4 = input.nextInt();
        int y4 = input.nextInt();

        // Ask the user for the x, y coordinates for the end of the line
        System.out.print("Ingrese la coordenada x y la coordenada y para el punto 5: ");
        int x5 = input.nextInt();
        int y5 = input.nextInt();
      
        //Create the canvas background by creating a rectangle that fills the
        // whole screen with black color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // Create a small circle that shows the start of a line
        gc.setFill(Color.RED);
        gc.fillOval(x1, y1, POINT_WIDTH, POINT_HEIGHT);
        
        // Create a circle that shows the end of the line
        gc.fillOval(x2, y2, POINT_WIDTH, POINT_HEIGHT);        
        
        // Create a circle that shows the end of the line
        gc.fillOval(x3, y3, POINT_WIDTH, POINT_HEIGHT);
        
       // Create a circle that shows the end of the line
        gc.fillOval(x4, y4, POINT_WIDTH, POINT_HEIGHT);
        
        // Create a circle that shows the end of the line
        gc.fillOval(x5, y5, POINT_WIDTH, POINT_HEIGHT);
        
        gc.setStroke(Color.BLUE);
        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x4, y4);
        gc.strokeLine(x4, y4, x5, y5);
        gc.strokeLine(x5, y5, x1, y1);

        gc.setFill(Color.WHITE);
        gc.fillOval(50, 50, 100, 100);

        double x = Math.random() * CANVAS_WIDTH;
        double y = Math.random() * CANVAS_HEIGHT;
        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, 1, 1);
        stage.show();
	}
		
	
	// Ordener Galaxies
	@FXML
    void orderGByName(ActionEvent event) {
		ArrayList<Galaxy> galaxiesToOrder= myPlanetarium.getGalaxies();
		ObservableList<Galaxy> itemsGalaxy =FXCollections.observableArrayList ();
		 for (int i=0; i<galaxiesToOrder.size();i++) {
			 Galaxy g = new Galaxy(galaxiesToOrder.get(i).getName(),galaxiesToOrder.get(i).getNumPlanets());
			 myPlanetarium.orderGalaxyByName();
			 
			 System.out.println(g.getName());
			 
			 
		 }
		listViewGalaxy.setItems(itemsGalaxy);
		
		listViewGalaxy.getSelectionModel().select(0);
		listViewGalaxy.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				loadData();
			}
		});
		loadData();
   	 }
		
	@FXML
    void orderByNumPlanets(ActionEvent event) {

    }

	
	// Order Natural Satellites
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
	
	//ACTION BUTTONS GALAXY - ADD 
	
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
		        	 ArrayList<Galaxy> galaxies = myPlanetarium.getGalaxies();
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
		    				loadData();
		    			}
		    		});
		    		loadData();
		        	 }
		        	 catch (NumberFormatException e) {
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

	//ACTION BUTTONS NATURAL SATELLITE - ADD 
	
	@FXML
    void addNSatellite(ActionEvent event) {
		
		Dialog<NaturalSatellite> dialog = new Dialog<>();
		dialog.setTitle("Agregar Satelite Natural");
		dialog.setHeaderText("Ingrese la Información del Satelite Natural");
		dialog.setResizable(true);
		  
		Label label1 = new Label("Nombre del Satelite Natural: ");
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
		        	try {
		        		String sName= text1.getText();
		        		String sStatus= text2.getText();
		        		int sArea = Integer.parseInt(text3.getText());
		        		String nameG = listViewGalaxy.getSelectionModel().getSelectedItem().getName();
		        		String nameP=  labelName.getText();
		        		myPlanetarium.addNaturalSatelite(nameG, nameP, sName, sStatus, sArea);
		        		ArrayList<Satellite> satellites = myPlanetarium.getSatellitesNatural(nameG, nameP).getListSatellites(new ArrayList<Satellite>());
			        	ObservableList<String> itemsSatellites =FXCollections.observableArrayList ();
			     		 for (int i=0; i<satellites.size();i++) {
			     			 System.out.println(satellites.get(i));
			     			 itemsSatellites.add(satellites.get(i).getName());
			     		 }
			     		listViewNaturalSatellite.setItems(itemsSatellites);
			    		listViewNaturalSatellite.getSelectionModel().select(0);
			    		listViewNaturalSatellite.setOnMouseClicked(new EventHandler<Event>() {
			    			@Override
			    			public void handle(Event event) {
			    				loadData();
			    			}
			    		});
		        	}
		        	 catch (NumberFormatException e) {
		        		 JOptionPane.showMessageDialog(null, "Por Favor Ingrese en el campo NUMERO DE PLANETAS EN LA GALAXIA un NUMERO ENTERO");
					}
		         }
		        else if (b==buttonTypeCancel) {
		       	 dialog.close();
		        }
		  
		        return null;
		    }
		});
		          
		Optional<NaturalSatellite> result = dialog.showAndWait(); 
    }

    
  //ACTION BUTTONS ARTIFICIAL SATELLITE - ADD  
	
  	@FXML
      void addASatellite(ActionEvent event) {
  		
  		Dialog<ArtificialSatellite> dialog = new Dialog<>();
		dialog.setTitle("Agregar Satelite Artificial");
		dialog.setHeaderText("Ingrese la Información del Satelite Artificial");
		dialog.setResizable(true);
		  
		Label label1 = new Label("Nombre del Satelite Artificial: ");
		Label label2 = new Label("Pais: ");
		Label label3 = new Label("Tipo de Servicio: ");
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
		        	try {
		        		String sName= text1.getText();
		        		String sCountry= text2.getText();		        		
		        		ArtificialSatellite.serviceType sServiceType =  comboBox.getValue().equals("MILITAR")? serviceType.MILITAR:
		        			comboBox.getValue().equals("COMUNICACION")? serviceType.COMUNICACION:serviceType.METEOROLOGICO;
		        		String nameG = listViewGalaxy.getSelectionModel().getSelectedItem().getName();
		        		String nameP=  labelName.getText();
		        		myPlanetarium.addArtificialSatellite(nameG, nameP, sName, sCountry, sServiceType);
		        		ArrayList<Satellite> satellites = myPlanetarium.getSatellitesArtificial(nameG, nameP).getListSatellites(new ArrayList<Satellite>());
		        		ObservableList<String> itemsSatellites =FXCollections.observableArrayList ();
		        		for (int i=0; i<satellites.size();i++) {
		        			System.out.println(satellites.get(i));
		        			itemsSatellites.add(satellites.get(i).getName());
		        		}
		        		listViewArtificialSatellite.setItems(itemsSatellites);
		        		listViewArtificialSatellite.getSelectionModel().select(0);
		        		listViewArtificialSatellite.setOnMouseClicked(new EventHandler<Event>() {
		    			@Override
		    			public void handle(Event event) {
		    				loadData();
		    			}
		        		});
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
	          
	Optional<ArtificialSatellite> result = dialog.showAndWait(); 
  	}	
  	  
}
