public class Doctor extends User {
  private String specialization;

  public Doctor(String name ,String email, String password ,String spec){
    super(name, email, password);
    this.specialization = spec;
  }

  public String getSpecialization() {
    return specialization;
  }

  @Override
  public String toString() {
      return super.toString() +
        ", Specialization: " + specialization + "\n";
  }
}
