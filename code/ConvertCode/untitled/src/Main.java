import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            ArrayList<StructAuteur> l = getAutorNameOnly("SELECT distinct t.Auteur FROM t_ouvrages t left join t_personne a on t.Auteur=a.nom_prenom where Num_personne is Null ORDER BY `a`.`Num_personne` ASC");
            //ArrayList<StructAuteur> l = getAutor("SELECT `Num_personne`,`nom_prenom` FROM `t_personne`");
            //uploadAutor(l);
            uploadAutorNoId(l);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList getAutorNameOnly(String sql) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdjimenes","root","");
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ArrayList l = new ArrayList<>();
        while(rs.next()){
            StructAuteur sa=new StructAuteur(rs.getString(1));
            System.out.println(sa);
            l.add(sa);
        }
        return l;
    }

    public static void uploadAutor(ArrayList<StructAuteur> l) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fprojectcolmar","root","");

        for (StructAuteur sa:l) {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO `auteurs`(`idAuteur`, `nom`, `prenom`) VALUES (?,?,?)");

            System.out.println(sa);
            stmt.setInt(1,sa.nb);
            stmt.setString(2, sa.nom);
            stmt.setString(3,sa.prenom);
            stmt.execute();
        }

    }
    public static void uploadAutorNoId(ArrayList<StructAuteur> l) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fprojectcolmar","root","");

        for (StructAuteur sa:l) {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO `auteurs`( `nom`, `prenom`) VALUES (?,?)");

            System.out.println(sa);
            stmt.setString(1,sa.nom);
            stmt.setString(2, sa.prenom);
            stmt.execute();
        }

    }

    public static ArrayList getAutor(String sql) throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdjimenes","root","");
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ArrayList l = new ArrayList<>();
        while(rs.next()){
            StructAuteur sa=new StructAuteur(rs.getInt(1),rs.getString(2));
            l.add(sa);
        }
        return l;
    }
}