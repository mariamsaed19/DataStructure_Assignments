package m;


import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class PlayersFinder implements IPlayersFinder {
	/**
	* Search for players locations at the given photo
	* @param photo
	* Two dimension array of photo contents
	* Will contain between 1 and 50 elements, inclusive
	* @param team
	* Identifier of the team
	* @param threshold
	* Minimum area for an element
	* Will be between 1 and 10000, inclusive
	* @return
	* Array of players locations of the given team
	*/
	private int counter,
	width_start,width_end,
	len_start,len_end,maxRow,maxCol;
	private java.awt.Point[] u =new Point[50];
	public void check (char Array[][],int row,int col,boolean visited[][],int team) {
	     int rowN[] = new int[] {1,-1,0,0}; 
	     int colN[] = new int[] {0,0,1,-1}; 
	     visited[row][col]=true;
	     counter++;
	     if(width_start>col)
	    	 width_start =col;
	     if(width_end<col)
	    	 width_end=col;
	     if(len_start>row)
	    	 len_start=row;
	     if(len_end<row)
	    	 len_end=row;
	     for(int k=0;k<4;k++) {
	    	 if((row+rowN[k] >= 0) && (row+rowN[k] < maxRow) && 
             (col+colN[k] >= 0) && (col+colN[k] < maxCol) && 
             Array[row+rowN[k]][col+colN[k]]==(char)(team+'0')&& !visited[row+rowN[k]][col+colN[k]]) {
	    		 check(Array,row+rowN[k],col+colN[k],visited,team);
	    		 
	    	 }
	     }

	}
	public class Sorter implements Comparator {
	  public int compare(Object o1, Object o2)
	  {
	    Point pointOne = (Point)o1;
	    Point pointTwo = (Point)o2;
	    return ((pointOne.getX()+pointOne.getY())+"").compareTo(((pointTwo.getX()+pointTwo.getY())+""));
	  }
	}
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		
		char[][]image = new char[photo.length][photo[0].length()];
		
		maxRow=photo.length;
		maxCol=photo[0].length();
		boolean[][] visited = new boolean[maxRow][maxCol];
		int z=0;
	
		for(int i=0;i<photo.length;i++) {
			char[] temp=photo[i].toCharArray();
			for(int j=0;j<photo[0].length();j++) {
				image[i][j] = temp[j];
			}
		}
		for(int i=0;i<maxRow;i++) {
			for(int j=0;j<maxCol;j++) {
				if(image[i][j]==(char)(team+'0')&&!visited[i][j]) {
					counter=0;
					width_start=width_end=j;
					len_start=len_end=i;
					check(image,i,j,visited,team);
					if(counter*4>=threshold) {
					u[z]=new Point();
					int x=width_start+width_end+1;
					int y=len_start+len_end+1;
					u[z].setLocation(x, y);
					z++;
					}
				}
			}
		}
		// sort
	       for (int i = 0; i < 50&&u[i]!=null; i++) 
	            for (int j = 0; j < 49-i&&u[j]!=null; j++) {
	                if (u[j+1]!=null && u[j].x > u[j+1].x) 
	                { 
	                    // swap arr[j+1] and arr[i] 
	                    Point temp = u[j]; 
	                    u[j]= u[j+1]; 
	                    u[j+1] = temp; 
	                } 
	                else if( u[j+1]!=null &&u[j].x==u[j+1].x) {
		                if (u[j].y > u[j+1].y) 
		                { 
		                    // swap arr[j+1] and arr[i] 
		                    Point temp = u[j]; 
		                    u[j] = u[j+1]; 
		                    u[j+1] = temp; 
		                } 
	                }
	            }
		
		return u;
		
	}


	}



