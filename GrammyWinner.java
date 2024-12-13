/**
 * Represents the GrammyWinner depending on year and category
 */
public class GrammyWinner {

  /** instance variables for the different arrays (txts)
  */
  
  private String name;     // name of person
  private int year;        // year award was given
  private String category;  // the category for the award

  /** Constructor:
  assigning values of the objects/ instance variables such as name, year, and category
  */
  public GrammyWinner(String name, int year, String category) {
    this.name = name;
    this.year = year;
    this.category = category;
  }

  /** Accessor Method for name
  */
  
  public String getName() {
    return name;
  }
  
  /** Accessor Method for year */
  public int getYear() {
    return year;
  }

  /** Accessor Method for category */
public String getCategory(){
  return category;
}
  /** toString Method override */
  public String toString() {
    return name + " : got " + category+ " in " + year;
  }  
  
}