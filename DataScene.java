import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a chosen dataset
 */
public class DataScene extends Scene {

 private GrammyWinner[] grammyWinner;      // new 1D array of GrammyWinner objects
  private String[] names;      // 1D array of nominees
  private int[] years;          // 1D array of years
  private String[] categories; //1D array of the different categories

  /** Constructor 
  - constructor for the DataScene class (assign value to object)
  */
  public DataScene() {
    grammyWinner = createWinner();
  }

  /** Returns a 1D array of nominees objects using the Nominee.txt in this project 
  * Returns a 1D array of categories objects using the Category.txt in this project 
  * Returns a 1D array of years objects using the year.txt in this project 
  */
  public GrammyWinner[] createWinner() {
    String[] namesArray = FileReader.toStringArray("Nominee.txt");
    int[] yearsArray = FileReader.toIntArray("year.txt");
    String[] categoriesArray = FileReader.toStringArray("Category.txt");
    
    GrammyWinner[] grammyWinnerArray = new GrammyWinner[namesArray.length];
    
    for (int i = 0; i < grammyWinnerArray.length; i++) {
      grammyWinnerArray[i] = new GrammyWinner(namesArray[i], yearsArray[i], categoriesArray[i]);
    }

    return grammyWinnerArray;
  }

  /**
   * Top-level method to draw the animation/ scene
   *uses methods that were created after 
   */
  public void drawScene() {

    for (GrammyWinner w: grammyWinner) {
      int year = w.getYear();
      String name = w.getName();
      String category = w.getCategory();
      
    makeDrumRoll();

   makeWaitingPage();


    pause(1.0); 

    clear("gold");

      // Plays background music
    playSound("Video-Project.wav");  
    
    drawBackgroundAndImage(year);

   getInfo(name, year, category);
   
    pause(0.5);

 
  }
  }

  /** Other Methods */

  /**drawing background and image method
  * Depending on the year, the text color, the background color, and the image will all be different (based on range of years)
  */

 public void drawBackgroundAndImage(int year){
        if (year == (1970)){
      /**
      *if it is equal to 1970, then the image will change to an image with a 1970s vibe
      */
      clear(Color.PINK);
      setTextColor("black");
      drawImage("1970.jpeg", 30, 120, 300);
    } else if (year>(1970)){
      /** if it is greater than 1970, then the image will be more clear and be like a modern day picture 
      */
      clear(Color.GOLD);
      setTextColor("black");
      drawImage("grammys.jpg", 30, 120, 300);
      }else{
      /** if it is any other year (which is less than 1970)
      *the image will be black and white (theme) (old days)
      */
      clear(Color.BLACK);
      setTextColor("white");
    drawImage("black.png", 40, 80, 300);
    }
  }

  /** Creates the very first page that introduces the grammy winners
  */

  public void makeDrumRoll(){
     clear("black");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(30);
    setTextColor("white");
    drawText("The Grammy Awards go to...", 2, 100);
    drawImage("Screenshot-2024-12-11-5.57.58-PM.png", 30, 120, 300);
    pause(2.0);
  }

/** Creates the second page that creates more tension with the ...
  */
 public void makeWaitingPage(){
     clear("black");
    drawImage("grammyWinner.jpeg", 0 , 5, 400);
    drawText("...", 20, 300);
  }

   /** gets the information and puts it in the scene
   *gets name, year, and category based on the arguments that are in the drawScene method
  */
  public void getInfo(String name, int year, String category){
     drawText(name, 20, 300);
    drawText("" + year, 20, 340);
    drawText(category, 20, 380);
  }
}

  
