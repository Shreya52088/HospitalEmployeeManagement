public class Patient extends User{
  private String bloodType;
  public Patient (String name ,String email, String pass,  String bType){
    super(name, email, pass);
    this.bloodType = bType;
  }
  public String getBloodType(){
    return bloodType;
  }

  @Override
  public String toString() {
      return super.toString() + ", Blood Type: " + bloodType + "\n";
  }
}
