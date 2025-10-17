public abstract class User  implements UserInterface{
  protected String name;
  protected String email;
  protected String password;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  public User(String name ){
    this.name = name;
  }
  @Override
  public String getName(){
    return name ;
  }
  @Override
  public String getEmail(){
    return email;
  }
  
  @Override
  public String getPassword(){
    return password;
  }
  @Override
  public  String login(String email,String password){
    return "Login successed!" ;
  }
  

  public String toString(){
    return "Name: " + name + ", Email: " + email + ", Password" + password ;
  }

}
