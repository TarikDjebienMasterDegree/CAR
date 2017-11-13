public class Personne implements java.io.Serializable
{
  protected String nom; protected String email;
  protected String url; protected String info;

  public Personne (String nom, String email, String url, String info)
  {
    this.nom = nom; this.email = email; this.url = url; this.info = info;
  }


  public void modifier (Personne p)
  {
    this.nom=p.nom; this.email=p.email; this.url=p.url; this.info=p.info;
  }

  public String toString (){
   return "[nom=" +nom+ ",email="+ email+",url="+url+",info="+info+"]";
  }


public String getEmail() {
	return email;
}


public String getUrl() {
	return url;
}


public String getInfo() {
	return info;
}


public String getNom() {
	return nom;
}
}
