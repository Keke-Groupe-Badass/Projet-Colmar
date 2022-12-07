import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            ArrayList<StructAuteur> l = getAutor();
            System.out.println(l.get(0));
            //uploadAutor(l);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public static ArrayList getAutor() throws ClassNotFoundException, SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdjimenes","root","");
        Statement stmt = con.createStatement();
        String sql ="SELECT `Num_personne`,`nom_prenom` FROM `t_personne`";
        ResultSet rs=stmt.executeQuery(sql);
        ArrayList l = new ArrayList<>();
        while(rs.next()){
            StructAuteur sa=new StructAuteur(rs.getInt(1),rs.getString(2));
            l.add(sa);
        }
        return l;
    }
}