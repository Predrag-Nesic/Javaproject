 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dusan
 */
public class Database {
    private static Database bp;

    /**
     * Dohvatanje objekta klase Database.
     * @return Database
     */
    public static Database getInstance() {
        if(bp == null)
            bp = new Database("com.mysql.jdbc.Driver",
                    "jdbc:mysql://127.0.0.1/javaproject",
                    "root",
                    "");
        return bp;
    }

    /**
     * Dohvatanje objekta klase Database.
     * @param driver String
     * @param url String
     * @param user String
     * @param pass String
     * @return Database
     */
    public static Database getInstance(String driver, String url, String user, String pass) {
        if(bp == null)
            bp = new Database(driver, url, user, pass);
        return bp;
    }

    private Connection con;

    /**
     * Privatni konstruktor koji se poziva iz staticke metode getInstance().
     * @param driver String
     * @param url String
     * @param user String
     * @param pass String
     */
    private Database(String driver, String url, String user, String pass) {
        try {
            Class.forName(driver); // Ucitavanje drivera
            con = DriverManager.getConnection(url, user, pass);
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
    }

    /**
     * Select upotrebom klase Statement.
     * @param query
     * @return
     */
	/*public ResultSet select(String query) {
		try {
			Statement st = con.createStatement();
			return st.executeQuery(query);
		} catch(SQLException se) {
			System.out.println("SQL Greska: " + se);
		} catch(NullPointerException ne) {
			System.out.println("Ne postoji konekcija ka bazi!");
		} catch(Exception e) {
			System.out.println("Greska: " + e);
		}
		return null;
	}*/

    private String oldQuery = "";
    private PreparedStatement ps = null;

    /**
     * Select bez ulaznih parametara koriscenjem klase PreparedStatement.
     * @param query - npr. query = "SELECT * FROM naziv_tabele"
     * @return ResultSet
     */
    public ResultSet select(String query) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query);
            return ps.executeQuery(query);
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return null;
    }

    /**
     * Select s jednim ulaznim parametrom tipa double.
     * @param query - npr. query = "SELECT * FROM naziv_tabele WHERE kolona = ?"
     * @param p - parametar tipa double
     * @return ResultSet
     */
    public ResultSet select(String query, double p) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query);
            ps.setDouble(1, p);
            return ps.executeQuery();
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return null;
    }

    /**
     * Select s jednim ulaznim parametrom tipa String.
     * @param query - npr. query = "SELECT * FROM naziv_tabele WHERE kolona = ?"
     * @param st - parametar tipa String
     * @return ResultSet
     */
    public ResultSet select(String query, String st) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query);
            ps.setString(1, st);
            return ps.executeQuery();
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return null;
    }

    /**
     * Select s proizvoljnim brojem i tipom ulaznih parametara.
     * @param query - npr. query = "SELECT * " +
     * 							   "FROM naziv_tabele " +
     * 							   "WHERE kolona1 = ? " +
     * 							   "AND kolona2 = ?";
     * @param p - ArrayList
     * @return ResultSet
     */
    // Umesto prethodne dve metode, omogucava prosledjivanje proizvoljnog
    // broja parametara za objekat PreparedStatement.
    public ResultSet select(String query, ArrayList p) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query);

            int i = 1;
            for(Object ob: p)
                if(ob instanceof Integer) // Integer je omotacka klasa za int
                    ps.setInt(i++, (int)ob);
                else if(ob instanceof Double) // Double je omotacka klasa za double
                    ps.setDouble(i++, (double)ob);
                else if(ob instanceof String)
                    ps.setString(i++, (String)ob);
                else
                    ps.setObject(i++, ob);
            // NAPOMENA: moglo je da stoji samo ps.setObject(i++, ob)
            // umesto svih provera u naredbama grananja.

            return ps.executeQuery();
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return null;
    }

    /**
     * Insert s proizvoljnim tipom i brojem ulaznih parametara.
     * @param query String
     * @param p ArrayList<Object>
     * @return int
     */
    public int insert(String query, ArrayList<Object> p) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query, Statement.RETURN_GENERATED_KEYS);

            int i = 1;
            for(Object ob: p)
                ps.setObject(i++, ob);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return -1;
    }

    /**
     * Update s proizvoljnim tipom i brojem ulaznih parametara.
     * @param query - upit
     * @param p - parametri
     * @return boolean
     */
    public boolean update(String query, ArrayList p) {
        try {
            if(!oldQuery.equals(query))
                ps = con.prepareStatement(oldQuery = query);

            int i = 1;
            for(Object ob: p)
                ps.setObject(i++, ob);

            ps.executeUpdate();
            return true;
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
        return false;
    }

    /**
     * Delete s proizvoljnim tipom i brojem ulaznih parametara.
     * @param query - upit
     * @param p - parametri
     * @return boolean
     */
    public boolean delete(String query, ArrayList<Object> p) {
        return update(query, p);
    }

    /**
     * Postavlja automatsku transakciju na zadati rezim. Ukoliko je postavimo
     * na true, svi SQL upiti, izvrsavace se kao posebne transakcije.
     * U suprotnom, ako postavimo na false, svi SQL upiti ce biti grupisani
     * i izvrsice se istovremeno onog trenutka kada pozovemo metodu
     * commit, ili ce se od svih njih odustati pozivom metode
     * rollback.
     * @param on_off
     */
    public void setAutoCommit(boolean on_off) {
        try {
            con.setAutoCommit(on_off);
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
    }

    /**
     * Ukoliko je automatskaTransakcija postavljena na false, pozivom ove metode
     * izvrsavaju se svi upiti koji su pre toga pozvani na izvrsavanje.
     */
    public void commit() {
        try {
            con.commit();
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
    }

    /**
     * Ukoliko je automatskaTransakcija postavljena na false, pozivom ove metode
     * odustaje se od izvrsavanja svih upita koji su pre toga pozvani.
     */
    public void rollback() {
        try {
            con.rollback();
        } catch(NullPointerException ne) {
            System.err.println("Ne postoji konekcija ka bazi!");
        } catch(Exception e) {
            System.err.println("Greska: " + e);
        }
    }
}
