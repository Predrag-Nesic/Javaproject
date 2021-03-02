package models;

import base.Database;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model {
    //protected String table = null;
    protected int id = -1;
    public int getId() {
        return id;
    }
    private String getTable() {
        try {
            Field field = this.getClass().getDeclaredField("table");
            field.setAccessible(true);
            String tabela = field.get(this).toString();
            field.setAccessible(false);
            return tabela;
        } catch(Exception e) {
            return this.getClass().getSimpleName().toLowerCase();
        }
    }
    private Map<String, Object> attributes() {
        Map<String, Object> hm = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        int i = 0;
        for(Field field: fields) {
            String fieldName = field.getName();
            if(fieldName.equals("id") || fieldName.equals("table"))
                continue;
            try {
                field.setAccessible(true);
                hm.put(fieldName, field.get(this));
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hm;
    }
    private int insert() {
        String query = "INSERT INTO " + getTable();
        Field[] fields = this.getClass().getDeclaredFields();

        Map<String, Object> a = attributes();
        if(a.size() == 0)
            return this.id = -1;

        Set<String> attrs = a.keySet();
        ArrayList<Object> params = new ArrayList<Object>();
        String attributes = "(";
        String values = "(";
        int i = 0;
        for(Object attr: attrs) {
            params.add(a.get(attr));
            if(i++ > 0) {
                attributes += "," + attr;
                values += ",?";
            } else {
                attributes += attr;
                values += "?";
            }
        }
        attributes += ")";
        values += ")";
        query += " " + attributes + " VALUES" + values;
        Database db = Database.getInstance();
        return this.id = db.insert(query, params);
    }

    private int update() {
        String query = "UPDATE " + getTable() + " SET ";

        Field[] fields = this.getClass().getDeclaredFields();
        Map<String, Object> a = attributes();
        if(a.size() == 0)
            return this.id = -1;
        Set<String> attrs = a.keySet();
        ArrayList<Object> params = new ArrayList<Object>();
        String attributes = "(";
        String values = "(";
        int i = 0;
        for(Object attr: attrs) {
            params.add(a.get(attr));
            if(i++ > 0) {
                query += ", " + attr + " = ?";
            } else {
                query += attr + " = ?";
            }
        }
        query += " WHERE id = ?";
        params.add(this.id);
        Database db = Database.getInstance();
        return db.update(query, params) ? this.id : -1;
    }
    public Model save() {
        int id = this.id > 0 ? update() : insert();
        return this.find(id);
    }
    public Model find(int id) {
        try {
            String query = "SELECT * " +
                    "FROM " + getTable() + " " +
                    "WHERE id = ?";
            ArrayList<Object> params = new ArrayList<Object>();
            params.add(id);
            Database db = Database.getInstance();
            ResultSet rs = db.select(query, params);
            rs.next();
            Field[] fields = this.getClass().getDeclaredFields();

            this.id = rs.getInt("id");
            for(Field field: fields) {
                if(field.getName().equals("table"))
                    continue;
                field.setAccessible(true);
                field.set(this, rs.getObject(field.getName()));
                field.setAccessible(false);
            }
            return this;
        } catch(Exception e) {
            return null;
        }
    }
    public void delete() {
        String query = "DELETE FROM " + getTable() + " " +
                "WHERE id = ?";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(id);
        Database db = Database.getInstance();
        db.delete(query, params);
        Field[] fields = this.getClass().getDeclaredFields();
        this.id = -1;
        for(Field field: fields) {
            try {
                field.setAccessible(true);
                if(field.getType() == double.class)
                    field.set(this, 0);
                else if(field.getType() == int.class)
                    field.set(this, 0);
                else if(field.getType() == float.class)
                    field.set(this, 0);
                else
                    field.set(this, null);
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Model> all(Class<?> s) {
        ArrayList<Model> models = new ArrayList<Model>();
        try {
            Model instance = (Model)s.newInstance();
           
            String tabela = instance.getTable();
            String query = "SELECT * " +
                    "FROM " + tabela;
            ArrayList<Object> params = new ArrayList<Object>();
            Database db = Database.getInstance();
            ResultSet rs = db.select(query, params);
            while(rs.next()) {
                Model inst = (Model)s.newInstance();
                Field[] fields = inst.getClass().getDeclaredFields();
                inst.id = rs.getInt("id");
                for(Field field: fields) {
                    if(field.getName().equals("table") || field.getName().equals("id"))
                        continue;
                    field.setAccessible(true);
                    field.set(inst, rs.getObject(field.getName()));
                    field.setAccessible(false);
                }
                models.add(inst);
            }
        } catch(Exception e) {
            System.out.println(e.toString());
        }

        return models;
    }
}
