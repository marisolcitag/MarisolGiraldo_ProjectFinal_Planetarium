package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Satellite implements Comparable<Satellite>, Serializable {
	
	private String name;
	
	private Satellite left;
    
    private Satellite right;

	public Satellite(String name) {
		this.name = name;
		left=null;
		right=null;
	}

	public Satellite getLeft() {
		return left;
	}

	public void setLeft(Satellite left) {
		this.left = left;
	}

	public Satellite getRight() {
		return right;
	}

	public void setRight(Satellite right) {
		this.right = right;
	}

	public String getName() {
		return name;
	}
	
	/**
     * Indica si este nodo es una hoja
     * @return true si este nodo es una hoja y false en caso contrario
     */
    public boolean isSheet( ){
        return left == null && right == null;
    }
    
    /**
     * Retorna el satelite que alfabéticamente corresponde al menor satelite del árbol que parte de este nodo
     * @return satelite con menor nombre
     */
    public Satellite getMinor( ){
        return ( left == null ) ? this : left.getMinor( );
    }
    
    /**
     * Retorna el satelite que alfabéticamente corresponde al mayor satelite del árbol que parte de este nodo
     * @return satelite con mayor nombre
     */
    public Satellite getMajor( ){
        return ( right == null ) ? this : right.getMajor( );
    }
    
	/**
     * Retorna la altura del árbol de satelites que comienza en este nodo
     * @return altura del árbol que comienza en este nodo
     */
    public int getHeight( )
    {
        if( isSheet( ) )
            return 1;
        else
        {
            int a1 = ( left == null ) ? 0 : left.getHeight( );
            int a2 = ( right == null ) ? 0 : right.getHeight( );
            return 1 + Math.max( a1, a2 );
        }
    }
    
    /**
     * Retorna el número de hojas que hay en el árbol que comienza en este nodo
     * @return número de hojas que hay en el árbol que comienza en este nodo
     */
    public int countSheet( )
    {
        if( isSheet()) 
            return 1;
        else
        {
            int h1 = ( left == null ) ? 0 : left.countSheet( );
            int h2 = ( right == null ) ? 0 : right.countSheet( );
            return h1 + h2;
        }
    }
    
    /**
     * Inserta un nuevo satelite al árbol que comienza en este nodo.
     * @param nuevo el  nuevo satelite que se va a insertar - nuevo != null
     * @throws AlreadyExistSatelliteException se lanza esta excepción si el satelite que se quiere agregar ya está en el planeta
     */
    public void insertSatellite( Satellite newNS ) throws AlreadyExistSatelliteException
    {
        if( compareTo( newNS ) == 0 )
            throw new AlreadyExistSatelliteException( newNS.name );

        if( compareTo( newNS ) > 0 )
        {
            // Debe agregar el nuevo satelite por el subárbol izquierdo
            if( left == null )
                left = newNS;
            else
                left.insertSatellite( newNS );
        }
        else
        {
            // Debe agregar el nuevo satelite por el subárbol derecho
            if( right == null )
            	right = newNS;
            else
            	right.insertSatellite( newNS );
        }
    }

	/**
     * Implementación recursiva para localizar un satelite en el árbol que comienza en este nodo
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return satelite asociado al nombre. Si no lo encuentra retorna null;
     */
    public Satellite searchSatellite( String nameNS )
    {
        if( name.compareToIgnoreCase( nameNS ) == 0 )
            return this;
        else if( name.compareToIgnoreCase( nameNS ) > 0 )
            return ( left == null ) ? null : left.searchSatellite( nameNS );
        else
            return ( right == null ) ? null : right.searchSatellite( nameNS );
    }

    /**
     * Elimina un satelite del árbol que comienza en este nodo.
     * @param unNombre nombre del satelite que se va a eliminar - hay un satelite en el árbol que se llama unNombre
     * @return el árbol de satelites después de eliminar el satelite indicado
     */
    public Satellite deleteSatellite( String nameNS )
    {
        if( isSheet())
            // Tiene que ser el elemento que estamos buscando
            return null;
        if( name.compareToIgnoreCase( nameNS ) == 0 )
        {
            if( left == null )
                return right;
            if( right == null )
                return left;
            // Localiza el menor satelite del subárbol derecho
            Satellite sucesor = right.getMinor();
            // Elimina del subárbol derecho el elemento que acaba de localizar
            right = right.deleteSatellite( sucesor.getName( ) );
            // Deja el elemento localizado en la raíz del árbol de respuesta
            sucesor.left= left;
            sucesor.right = right;
            return sucesor;
        }
        else if( name.compareToIgnoreCase( nameNS ) > 0 )
        	left = left.deleteSatellite( nameNS );
        else
        	right = right.deleteSatellite( nameNS );
        return this;
    }

    /**
     * Retorna una colección con los nombres de todos los satelites, ordenados alfabéticamente en orden ascendente
     * @param s colección donde se van agregando los nombres de los satelites ordenadamente
     */
   /* public void inordenByName( Collection s )
    {
        // Recorre en inorden el subárbol izquierdo
        if( left != null )
            left.inordenByName( s );
        // Incluye en el recorrido el contacto de la raíz
        s.add( name );
        // Recorre en inorden el subárbol derecho
        if( right != null )
            right.inordenByName( s );
    }*/
    
    //PREORDER
    public void preorder(ArrayList<Satellite> s) {
		s.add(this);
		if(left != null) {
			left.preorder(s);
		}
		if(right != null) {
			right.preorder(s);
		}
	}
    
    //INORDER
    public void inorder(ArrayList<Satellite> s) {
		if(left != null) {
			left.inorder(s);
		}
		s.add(this);
		if(right != null) {
			right.inorder(s);
		}
	}
    
    //POSTORDER
    public void postorder(ArrayList<Satellite> s) {
		if(left != null) {
			left.postorder(s);
		}
		if(right != null) {
			right.postorder(s);
		}
		s.add(this);
	}
    
    
    /**
     * Indica si el árbol que comienza en este nodo es ordenado
     * @return true si el árbol que comienza en este nodo es ordenado
     */
    public boolean isOrdered( )
    {
        if( isSheet( ) )
            return true;

        else if( left == null )
            return right.isOrdered( ) && name.compareTo( right.getMinor( ).getName( ) ) < 0;

        else if( right == null )
            return left.isOrdered( ) && name.compareTo( left.getMajor( ).getName( ) ) > 0;

        else
            return right.isOrdered( ) && name.compareTo( right.getMinor( ).getName( ) ) < 0 && left.isOrdered( ) && name.compareTo( left.getMajor().getName( ) ) > 0;
    }

    /**
     * Cuenta el número de veces que aparece un satelite con un nombre que se recibe como parámetro
     * @param nombreP nombre del satelite que se está buscando - nombreP != null
     * @return número de satelites con un nombre dado
     */
    public int countOccurrences( String nameNS )
    {
        int howmany = 0;
        if( name.equals( nameNS ) )
            howmany++;
        howmany += ( left == null ) ? 0 : left.countOccurrences( nameNS );
        howmany += ( right == null ) ? 0 : right.countOccurrences( nameNS );
        return howmany;
    } 
    
    public ArrayList<Satellite> getListSatellites(ArrayList<Satellite> arrayS){
    	    	
    	if( isSheet( ) ) {
    		arrayS.add(this);
    		return arrayS;
    	}

        else if( left != null ) {
        	arrayS.add(left);
        	left.getListSatellites(arrayS);
            
        }
        else if( right != null ) {
        	arrayS.add(right);
        	right.getListSatellites(arrayS);
            
        }        	
    	return arrayS;
    }
}
