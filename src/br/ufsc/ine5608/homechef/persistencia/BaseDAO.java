package br.ufsc.ine5608.homechef.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * 
 * @author Flávio
 * @param <V> Tipo da entidade
 */
public abstract class BaseDAO<V> {
    
    protected HashMap<Integer, V> cache;
    private final String fileName;
    private int nextId;
    
    protected BaseDAO() {
        this.cache = new HashMap<>();
        this.fileName = this.getFileName();
        load();
    }
    
    protected abstract String getFileName();
    
    public V get(Integer id) {
        return this.cache.get(id);
    }
    
    public void put(Integer id, V value) {
        if (id != null && value != null) {
            this.cache.put(id, value);
            persist();
        } else {
            throw new RuntimeException("A chave e o valor devem ser diferentes de null!");
        }
    }
    
    private void prepareNextId() {
        Integer[] ids = this.cache.keySet().toArray(new Integer[0]);
        this.nextId = 1;
        if (ids.length > 0)
            this.nextId = ids[ids.length - 1] + 1;
    }
    
    public int getNextId() {
        return this.nextId++;
    }
    
    public void load() {
        
        try {
            FileInputStream fi = new FileInputStream(fileName);
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            this.cache = (HashMap<Integer, V>) oi.readObject();
            
            oi.close();
            fi.close();
            
            prepareNextId();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void remove(Integer id) {
        this.cache.remove(id);
        persist();
    }
    
    public void persist() {
        
        try {
            FileOutputStream fo = new FileOutputStream(this.fileName);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            
            oo.writeObject(this.cache);

            oo.flush();
            fo.flush();

            oo.close();
            fo.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Collection<V> getList() {
        return this.cache.values();
    }
    
}
