package application;
import java.io.*;
import java.util.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class saveGame1 implements Serializable {
	 int score;
	 double ballY;
	//ArrayList<Double>obstacleY;
	double circleY;
	double triangleY;
	double plusY;
	double squareY ;
	

	
	
	
	ArrayList<Double> starY;
	double colorChangerY;
	static ArrayList<saveGame1> meraWala=new ArrayList<saveGame1>();
	public saveGame1() {
		
	}
	public static void serialize() throws IOException{
        ArrayList<saveGame1> arr = meraWala;;
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(
                    new FileOutputStream("naya.txt"));
            out.writeObject(arr);
        } finally {
            out.close();
        }
    }
public void addGame(saveGame1 a) {
	meraWala.add(a);
}
    public static ArrayList<saveGame1> deserialize() throws IOException, ClassNotFoundException{
        ArrayList<saveGame1> arr = new ArrayList<saveGame1>();
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(
                    new FileInputStream("naya.txt"));
            arr = (ArrayList<saveGame1>)in.readObject();
        } finally {
            in.close();
        }
        return arr;
    }
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}