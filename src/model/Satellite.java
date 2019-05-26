package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Satellite implements Comparable<Satellite>, Serializable {
	
	//ATTRIBUTES
	
	private String name;
	
	private Satellite left;
    
    private Satellite right;

    //CONSTRUCTOR
    
	public Satellite(String name) {
		this.name = name;
		left=null;
		right=null;
	}

	//METHODS
	
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
	
    public boolean isSheet( ){
        return left == null && right == null;
    }
    
    public Satellite getMinor( ){
        return ( left == null ) ? this : left.getMinor( );
    }
    
    public Satellite getMajor( ){
        return ( right == null ) ? this : right.getMajor( );
    }
    
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

    public Satellite searchSatellite( String nameNS )
    {
        if( name.compareToIgnoreCase( nameNS ) == 0 )
            return this;
        else if( name.compareToIgnoreCase( nameNS ) > 0 )
            return ( left == null ) ? null : left.searchSatellite( nameNS );
        else
            return ( right == null ) ? null : right.searchSatellite( nameNS );
    }

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
