package userInterface;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
 
public class Main extends Application {
	
	public Sphere mercury;
    public Sphere venus;
	public Sphere earth;
    public Sphere moon;
    public Sphere mars;
    public Sphere jupiter;
    public Sphere saturn;
    public Sphere uranus;
    public Sphere neptune;
    public Circle comet;
    public Circle comet2;
    
    @Override
    public void start(Stage primaryStage) {
    	      
    	//SUN
    	final PhongMaterial yellowMaterial = new PhongMaterial();
    	yellowMaterial.setDiffuseColor(Color.GOLD);
    	yellowMaterial.setSpecularColor(Color.LIGHTGOLDENRODYELLOW);
        
    	Sphere sun = new Sphere(45);
        sun.setMaterial(yellowMaterial);
    	
        //MERCURY
        final PhongMaterial darkGreyMaterial = new PhongMaterial();
        darkGreyMaterial.setDiffuseColor(Color.DARKGREY);
        darkGreyMaterial.setSpecularColor(Color.LIGHTGREY);
        
        mercury= new Sphere(7);
        mercury.setMaterial(darkGreyMaterial);
        
        //VENUS
        final PhongMaterial darkGoldenRodMaterial = new PhongMaterial();
        darkGoldenRodMaterial.setDiffuseColor(Color.YELLOW);
        darkGoldenRodMaterial.setSpecularColor(Color.LIGHTYELLOW);
        
        venus= new Sphere(10);
        venus.setMaterial(darkGoldenRodMaterial);
        
        //EARTH
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);
   
        earth = new Sphere(15);
        earth.setMaterial(blueMaterial);
        
        //MOON
        final PhongMaterial greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.GAINSBORO);
        greyMaterial.setSpecularColor(Color.LIGHTBLUE);
        
        moon = new Sphere(8);
        moon.setMaterial(greyMaterial);
        
        //MARS
        final PhongMaterial coralMaterial = new PhongMaterial();
        coralMaterial.setDiffuseColor(Color.CRIMSON);
        coralMaterial.setSpecularColor(Color.LIGHTCORAL);
   
        mars = new Sphere(15);
        mars.setMaterial(coralMaterial);
        
        //JUPITER
        final PhongMaterial darkSalmonMaterial = new PhongMaterial();
        darkSalmonMaterial.setDiffuseColor(Color.DARKSALMON);
        darkSalmonMaterial.setSpecularColor(Color.LIGHTSALMON);
   
        jupiter = new Sphere(30);
        jupiter.setMaterial(darkSalmonMaterial);
 
        //SATURN
        final PhongMaterial darkOrangeMaterial = new PhongMaterial();
        darkOrangeMaterial.setDiffuseColor(Color.DARKORANGE);
        darkOrangeMaterial.setSpecularColor(Color.LIGHTCORAL);
   
        saturn = new Sphere(20);
        saturn.setMaterial(darkOrangeMaterial);
        
        Ellipse elipticSaturn = new Ellipse();
        elipticSaturn.setFill(Color.RED);
        
        //URANUS
        final PhongMaterial aquamarineMaterial = new PhongMaterial();
        aquamarineMaterial.setDiffuseColor(Color.AQUAMARINE);
        aquamarineMaterial.setSpecularColor(Color.LIGHTCYAN);
   
        uranus = new Sphere(18);
        uranus.setMaterial(aquamarineMaterial);
        
        //NEPTUNE
        final PhongMaterial turquoiseMaterial = new PhongMaterial();
        turquoiseMaterial.setDiffuseColor(Color.DEEPSKYBLUE);
        turquoiseMaterial.setSpecularColor(Color.LIGHTBLUE);
   
        neptune = new Sphere(14);
        neptune.setMaterial(turquoiseMaterial);
        
        //COMET
        comet = new Circle(10,Color.CHOCOLATE);
        comet2 = new Circle(5,Color.BISQUE);
        
        //SATELLITE
        Canvas canvas = new Canvas(); 
        canvas.setHeight(400); 
        canvas.setWidth(400); 
  
        GraphicsContext graphics_context = canvas.getGraphicsContext2D(); 
        graphics_context.setFill(Color.PINK); 
        graphics_context.fillRect(40, 40, 40, 40); 
  
        graphics_context.setFill(Color.RED); 
        graphics_context.fillRect(20, 20, 40, 40); 
  
        graphics_context.setFill(Color.BLUE); 
        graphics_context.fillOval(30, 30, 40, 40); 
  
        Group group = new Group(canvas); 
        
        //MERCURY ELLIPSE
        Ellipse ellipseMercury = new Ellipse();
        ellipseMercury.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 20);
        ellipseMercury.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 20);
        ellipseMercury.setFill(Color.TRANSPARENT);
        ellipseMercury.setStroke(Color.WHITE);
        
        PathTransition transitionMercury = new PathTransition();        
        transitionMercury.setPath(ellipseMercury);
        transitionMercury.setNode(mercury);
        transitionMercury.setInterpolator(Interpolator.LINEAR);
        transitionMercury.setDuration(Duration.seconds(10.000017421));
        transitionMercury.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionMercury.setCycleCount(Timeline.INDEFINITE);
        transitionMercury.play();
        
        //VENUS ELLIPSE
        Ellipse ellipseVenus = new Ellipse();
        ellipseVenus.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 60);
        ellipseVenus.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 60);
        ellipseVenus.setFill(Color.TRANSPARENT);
        ellipseVenus.setStroke(Color.WHITE);
        
        PathTransition transitionVenus = new PathTransition();
        transitionVenus.setPath(ellipseVenus);
        transitionVenus.setNode(venus);
        transitionVenus.setInterpolator(Interpolator.LINEAR);
        transitionVenus.setDuration(Duration.seconds(9.000017421));
        transitionVenus.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionVenus.setCycleCount(Timeline.INDEFINITE); 
        transitionVenus.play();
        
        //EARTH ELLIPSE
        Ellipse ellipseEarth = new Ellipse();
        ellipseEarth.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 100);
        ellipseEarth.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 100);
        ellipseEarth.setFill(Color.TRANSPARENT);
        ellipseEarth.setStroke(Color.WHITE);
        
        PathTransition transitionEarth = new PathTransition();
        transitionEarth.setPath(ellipseEarth);
        transitionEarth.setNode(earth);
        transitionEarth.setInterpolator(Interpolator.LINEAR);
        transitionEarth.setDuration(Duration.seconds(10.800017421));
        transitionEarth.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionEarth.setCycleCount(Timeline.INDEFINITE); 
        transitionEarth.play();
 
        //MOON ELLIPSE
        Ellipse ellipseMoon = new Ellipse();
        ellipseMoon.setRadiusX(earth.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 30);
        ellipseMoon.setRadiusY(earth.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 30);
        ellipseMoon.setFill(Color.TRANSPARENT);
        ellipseMoon.setStroke(Color.WHITE);

        PathTransition transitionMoon = new PathTransition();
        transitionMoon.setPath(ellipseMoon);
        transitionMoon.setNode(moon);
        transitionMoon.setInterpolator(Interpolator.LINEAR);
        transitionMoon.setDuration(Duration.seconds(1.000017421));
        transitionMoon.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionMoon.setCycleCount(Timeline.INDEFINITE);
        transitionMoon.play();
        
        //MARS ELLIPSE
        Ellipse ellipseMars = new Ellipse();
        ellipseMars.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 140);
        ellipseMars.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 140);
        ellipseMars.setFill(Color.TRANSPARENT);
        ellipseMars.setStroke(Color.WHITE);
        
        PathTransition transitionMars = new PathTransition();
        transitionMars.setPath(ellipseMars);
        transitionMars.setNode(mars);
        transitionMars.setInterpolator(Interpolator.LINEAR);
        transitionMars.setDuration(Duration.seconds(10.000017421));
        transitionMars.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionMars.setCycleCount(Timeline.INDEFINITE);
        transitionMars.play();
        
        //JUPITER ELLIPSE
        Ellipse ellipseJupiter = new Ellipse();
        ellipseJupiter.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 200);
        ellipseJupiter.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 200);
        ellipseJupiter.setFill(Color.TRANSPARENT);
        ellipseJupiter.setStroke(Color.WHITE);
        
        PathTransition transitionJupiter = new PathTransition();
        transitionJupiter.setPath(ellipseJupiter);
        transitionJupiter.setNode(jupiter);
        transitionJupiter.setInterpolator(Interpolator.LINEAR);
        transitionJupiter.setDuration(Duration.seconds(9.800017421));
        transitionJupiter.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionJupiter.setCycleCount(Timeline.INDEFINITE);
        transitionJupiter.play();
        
        //SATURN ELLIPSE
        Ellipse ellipseSaturn = new Ellipse();
        ellipseSaturn.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 260);
        ellipseSaturn.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 260);
        ellipseSaturn.setFill(Color.TRANSPARENT);
        ellipseSaturn.setStroke(Color.WHITE);
        
        PathTransition transitionSaturn = new PathTransition();
        transitionSaturn.setPath(ellipseSaturn);
        transitionSaturn.setNode(saturn);
        transitionSaturn.setInterpolator(Interpolator.LINEAR);
        transitionSaturn.setDuration(Duration.seconds(10.200017421));
        transitionSaturn.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionSaturn.setCycleCount(Timeline.INDEFINITE);
        transitionSaturn.play();
        
        //URANUS ELLIPSE
        Ellipse ellipseUranus = new Ellipse();
        ellipseUranus.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 300);
        ellipseUranus.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 300);
        ellipseUranus.setFill(Color.TRANSPARENT);
        ellipseUranus.setStroke(Color.WHITE);
        
        PathTransition transitionUranus = new PathTransition();
        transitionUranus.setPath(ellipseUranus);
        transitionUranus.setNode(uranus);
        transitionUranus.setInterpolator(Interpolator.LINEAR);
        transitionUranus.setDuration(Duration.seconds(9.500017421));
        transitionUranus.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionUranus.setCycleCount(Timeline.INDEFINITE);
        transitionUranus.play();
        
        //NEPTUNE ELLIPSE
        Ellipse ellipseNeptune = new Ellipse();
        ellipseNeptune.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 340);
        ellipseNeptune.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 340);
        ellipseNeptune.setFill(Color.TRANSPARENT);
        ellipseNeptune.setStroke(Color.WHITE);
        
        PathTransition transitionNeptune = new PathTransition();
        transitionNeptune.setPath(ellipseNeptune);
        transitionNeptune.setNode(neptune);
        transitionNeptune.setInterpolator(Interpolator.LINEAR);
        transitionNeptune.setDuration(Duration.seconds(9.200017421));
        transitionNeptune.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionNeptune.setCycleCount(Timeline.INDEFINITE);
        transitionNeptune.play();
        
        //COMET TRAYECTORY
        Line lineComet = new Line(-700,-300,900,700); 
        
        PathTransition transitionComet = new PathTransition();
        transitionComet.setPath(lineComet);
        transitionComet.setNode(comet);
        transitionComet.setInterpolator(Interpolator.LINEAR);
        transitionComet.setDuration(Duration.seconds(12.000017421));
        transitionComet.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionComet.setCycleCount(Timeline.INDEFINITE);
        transitionComet.play();
        
        Line lineComet2 = new Line(-400,-900,900,700); 
        
        PathTransition transitionComet2 = new PathTransition();
        transitionComet2.setPath(lineComet2);
        transitionComet2.setNode(comet2);
        transitionComet2.setInterpolator(Interpolator.LINEAR);
        transitionComet2.setDuration(Duration.seconds(12.000017421));
        transitionComet2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionComet2.setCycleCount(Timeline.INDEFINITE);
        transitionComet2.play();
        
        //SATELITE TRAYECTORY        
        Circle circle= new Circle(100, 100, 70);
        
        PathTransition transitionSatellite = new PathTransition();
        transitionSatellite.setNode(group);
        transitionSatellite.setPath(circle);
        transitionSatellite.setInterpolator(Interpolator.LINEAR);
        transitionSatellite.setDuration(Duration.seconds(12.000017421));
        transitionSatellite.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionSatellite.setCycleCount(Timeline.INDEFINITE);
        transitionSatellite.play();
        
        //STAR                 
        final int n = 100; // length and width of scene
        final int centerX = n / 6; // x-coordinate of center of stage
        final int centerY = n / 6; // y-coordinate of center of stage
        final int radius = 10;
        // Vertices of first triangle are 90°, 210°, and 330° about the center.
        double x1 = centerX + radius * Math.cos(Math.toRadians(90)); 
        double y1 = centerY - radius * Math.sin(Math.toRadians(90));
        double x2 = centerX + radius * Math.cos(Math.toRadians(210)); 
        double y2 = centerY - radius * Math.sin(Math.toRadians(210));
        double x3 = centerX + radius * Math.cos(Math.toRadians(330));
        double y3 = centerY - radius * Math.sin(Math.toRadians(330));
        Polygon triangle1 = new Polygon(x1, y1, x2, y2, x3, y3);
       
        // The second triangle is initialized to the same state as the first and then 
        // rotated and shifted so that the two triangles form a six-pointed star.
        Polygon triangle2 = new Polygon(x1, y1, x2, y2, x3, y3);
        triangle2.setRotate(180);
        triangle2.setTranslateY(radius / 2);        
        
        triangle1.setFill(Color.DARKGOLDENROD);
        triangle2.setFill(Color.DARKGOLDENROD); 
               
        /*
         * Hide the ellipse shadows
         */
        ellipseMercury.setVisible(true);
        ellipseVenus.setVisible(true);
        ellipseMoon.setVisible(true);
        ellipseEarth.setVisible(true);
        ellipseMars.setVisible(true);
        ellipseJupiter.setVisible(true);
        ellipseSaturn.setVisible(true);
        ellipseUranus.setVisible(true);
        ellipseNeptune.setVisible(true);
        lineComet.setVisible(false);
        lineComet2.setVisible(false);
        circle.setVisible(false);
          
        /* here we create a new pane which we bind to earths location, add moon 
         * into it and then add the pane to the root pane
         */
        StackPane root = new StackPane();
        StackPane moonPane = new StackPane();
        moonPane.translateXProperty().bind(earth.translateXProperty());
        moonPane.translateYProperty().bind(earth.translateYProperty());
        moonPane.setMaxSize(100, 100);
 
        root.getChildren().add(sun);
        root.getChildren().add(ellipseMercury);
        root.getChildren().add(mercury);
        root.getChildren().add(ellipseVenus);
        root.getChildren().add(venus);
        moonPane.getChildren().add(moon);
        root.getChildren().add(moonPane);
        root.getChildren().add(ellipseEarth);
        root.getChildren().add(earth);
        root.getChildren().add(ellipseMars);
        root.getChildren().add(mars);
        root.getChildren().add(ellipseJupiter);
        root.getChildren().add(jupiter);
        root.getChildren().add(ellipseSaturn);
        root.getChildren().add(saturn);
        root.getChildren().add(ellipseUranus);
        root.getChildren().add(uranus);
        root.getChildren().add(ellipseNeptune);
        root.getChildren().add(neptune);
        root.getChildren().add(lineComet);
        root.getChildren().add(comet);
        root.getChildren().add(lineComet2);
        root.getChildren().add(comet2);
        root.getChildren().add(circle);
        root.getChildren().add(group);
        root.getChildren().add(triangle1);
        root.getChildren().add(triangle2);
       
        //Button Iniciar
        Button btChange= new Button();
        btChange.setText("Iniciar");
        btChange.setTranslateX(300);
        btChange.setTranslateY(300);
        btChange.setOnMousePressed(new EventHandler<Event>() {
			public void handle(Event arg0) {
					// TODO Auto-generated method stub
				try {
					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
					Scene scene = new Scene(root,681,632);
					primaryStage.setTitle("PLANETARIUM");
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
        btChange.setTextFill(Color.WHITE);
        btChange.setStyle("-fx-background-color: #000000");
        root.getChildren().add(btChange);
        root.setStyle("-fx-background-color: #000000");
        
        Scene scene = new Scene(root, 900, 700, Color.BLACK);
        primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
            	primaryStage.close();
            }
        }));
        primaryStage.setTitle("Solar System Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
	public static void main(String[] args) {
        launch(args);
    } 
}