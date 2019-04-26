/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4;

/**
 *
 * @author jelmu
 */
import beroepsproductblok4.View.BuurthuisAanpassenView;
import beroepsproductblok4.View.BuurthuisToevoegenView;
import beroepsproductblok4.View.BuurthuisVerwijderenView;
import beroepsproductblok4.View.CursistVerwijderenView;
import beroepsproductblok4.View.LesAanpassenView;
import beroepsproductblok4.View.LesToevoegenView;
import beroepsproductblok4.View.LesVerwijderenView;
import beroepsproductblok4.View.VrijwilligerAanpassenView;
import beroepsproductblok4.View.VrijwilligerToevoegenView;
import beroepsproductblok4.View.VrijwilligerVerwijderenView;
import beroepsproductblok4.View.CursistAanpassenView;
import beroepsproductblok4.View.CursistToevoegenView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class BeroepsProductMenuBar extends MenuBar {
	Menu mCursist;
	Menu mVrijwilliger;
	Menu mBuurthuis;
        Menu mLes;
        Menu mOverzicht;
	
	MenuItem miCursistToevoegen;
        MenuItem miCursistAanpassen;
        MenuItem miCursistVerwijderen;
        
        MenuItem miVrijwilligerToevoegen;
        MenuItem miVrijwilligerAanpassen;
        MenuItem miVrijwilligerVerwijderen;
        
	MenuItem miBuurthuisToevoegen;
        MenuItem miBuurthuisAanpassen;
        MenuItem miBuurthuisVerwijderen;
        
        MenuItem miLesToevoegen;
        MenuItem miLesAanpassen;
        MenuItem miLesVerwijderen;
	
	public BeroepsProductMenuBar(Pane mainPane) {
	mCursist = new Menu("Cursist");
        mVrijwilliger = new Menu("Vrijwilliger");
        mBuurthuis = new Menu("Buurthuis");
        mLes = new Menu("Les");
        mOverzicht = new Menu("Overzicht");
        
        miCursistToevoegen = new MenuItem("Toevoegen");
        miCursistAanpassen = new MenuItem("Aanpassen");
        miCursistVerwijderen = new MenuItem("Verwijderen");
        
        miVrijwilligerToevoegen = new MenuItem("Toevoegen");
        miVrijwilligerAanpassen = new MenuItem("Aanpassen");
        miVrijwilligerVerwijderen = new MenuItem("Verwijderen");
        
        miBuurthuisToevoegen = new MenuItem("Toevoegen");
        miBuurthuisAanpassen = new MenuItem("Aanpassen");
        miBuurthuisVerwijderen = new MenuItem("Verwijderen");
        
        miLesToevoegen = new MenuItem("Toevoegen");
        miLesAanpassen = new MenuItem("Aanpassen");
        miLesVerwijderen = new MenuItem("Verwijderen");
        
        miCursistToevoegen.setOnAction(event->{
            mainPane.getChildren().clear();
            new CursistToevoegenView(mainPane);
        });
        miCursistAanpassen.setOnAction(event->{
            new CursistAanpassenView();
        });
        miCursistVerwijderen.setOnAction(event-> {
            new CursistVerwijderenView();
        });
        miVrijwilligerToevoegen.setOnAction(event->{
            mainPane.getChildren().clear();
            new VrijwilligerToevoegenView(mainPane);
        });
        miVrijwilligerAanpassen.setOnAction(event->{
            mainPane.getChildren().clear();
            new VrijwilligerAanpassenView();
        });
        miVrijwilligerVerwijderen.setOnAction(event->{
            mainPane.getChildren().clear();
            new VrijwilligerVerwijderenView();
        });
        miBuurthuisToevoegen.setOnAction(event->{
            mainPane.getChildren().clear();
            new BuurthuisToevoegenView();
        });
        miBuurthuisAanpassen.setOnAction(event->{
            mainPane.getChildren().clear();
            new BuurthuisAanpassenView();
        });
        miBuurthuisVerwijderen.setOnAction(event->{
            mainPane.getChildren().clear();
            new BuurthuisVerwijderenView();
        });
        miLesToevoegen.setOnAction(event->{
            mainPane.getChildren().clear();
            new LesToevoegenView();
        });
        miLesAanpassen.setOnAction(event->{
            mainPane.getChildren().clear();
            new LesAanpassenView();
        });
        miLesVerwijderen.setOnAction(event ->{
            mainPane.getChildren().clear();
            new LesVerwijderenView();
        });
        
        
        
        
        
        mCursist.getItems().addAll(miCursistToevoegen,miCursistAanpassen,miCursistVerwijderen);
        mVrijwilliger.getItems().addAll(miVrijwilligerToevoegen,miVrijwilligerAanpassen,miVrijwilligerVerwijderen);
        mBuurthuis.getItems().addAll(miBuurthuisToevoegen,miBuurthuisAanpassen,miBuurthuisVerwijderen);
        mLes.getItems().addAll(miLesToevoegen,miLesAanpassen,miLesVerwijderen);
            
            
//	mMap = new Menu("Map");
//	mActivities = new Menu("Vliegactiviteit");
//	
////	mAdd = new Menu("Toevoegen");
//	
//	miMap = new MenuItem("Bekijk kaart");
//	miActivities = new MenuItem("Bekijk activiteit");
//		
//	mMap.getItems().add(miMap);
//	mActivities.getItems().add(miActivities);
//	
//	miActivities.setOnAction(event->{
//		mainPane.getChildren().clear();
//		
//	});
//	
//	miMap.setOnAction(event->{
//		mainPane.getChildren().clear();
//		new MapView(mainPane);
//	});
//	
//	this.getMenus().addAll(mMap,mActivities);

        this.getMenus().addAll(mCursist,mVrijwilliger,mBuurthuis,mLes,mOverzicht);
	}
	
	
		
}