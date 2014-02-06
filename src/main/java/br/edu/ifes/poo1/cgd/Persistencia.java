package br.edu.ifes.poo1.cgd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
	
	String nomeArq = "contatos.dat";
	
	File arq = new File(nomeArq);
	
	{
	
	if(!arq.exists()){
		try {
			arq.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	}
	
	public void gravarArquivo(Object object){
		try{
			ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(arq)));              
			objectOut.writeObject(object);  
			objectOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Object recuperarArquivo(){

		Object object;  
		
		try{  
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(arq)));  
            object = in.readObject();  
            in.close();  
            return object;  
        }
        catch (Exception e){  
        	return null;  
        }
		
	}
	
}
