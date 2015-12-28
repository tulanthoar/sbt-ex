public class Company {
  private String name;

  @Override
  public String toString() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean sameCompany(Company other) {
    return this.name == other.toString();
  }
}