package com.abhishek.dojo.design;
import java.util.LinkedList;

// objective is to get count of food that can be eaten
//question- missing from code below- if food is eaten, its not added to 'shake' object
//question- why move history has directions supplied to snake. doest it really make sense?
class DesignSnakeGame {
	class Point{
        int i;
        int j;
        Point(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
	
    int width;
    int height;
    int[][] food;

    int k=0; // actual result
    LinkedList<Point> shake; //move history
    
    // height and width set boundries of board. used for i and j validation
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width=width;
        this.height=height;
        this.food=food;
        
        this.k=0;
        this.shake=new LinkedList<>();
        shake.addFirst(new Point(0,0));
    }
    //steps
    // 1. Get head
    // 2. Create new point from head. Based on direction, adjust i and j
    // 3. if not within boundaries and contain that sort of point return
    // 4. IMPORTANT- add new head to head of points
    // 5. if k is less than total food items and food location matches with head- increment K
    public int move(String direction) {
        // the new head is based on the current head
        // the tail is removed, but can be returned back if food is found
        Point head = shake.getFirst();
        Point newHead = new Point(head.i, head.j);        
        //Point tail = shake.removeLast(); 
        if(direction.equals("U")){
            newHead.i--;
        }else if(direction.equals("D")){
            newHead.i++;
        }else if(direction.equals("L")){
            newHead.j--;
        }else{
            newHead.j++;
        }
        if(newHead.i<0 || newHead.i==height || newHead.j<0 || newHead.j==width || shake.contains(newHead)) return -1;
        shake.addFirst(newHead);
        if(k<food.length && food[k][0]==newHead.i && food[k][1]==newHead.j){            
            //shake.addLast(tail); // return tail back, not needed
            k++;
        }
        return k;
    }
    
    public static void main(String[] args) {
		DesignSnakeGame s = new DesignSnakeGame(3, 2, new int[][] { { 1, 2 }, { 0, 1 } });
		System.out.println(s.move("R"));
		System.out.println(s.move("D"));
		System.out.println(s.move("R"));
		System.out.println(s.move("U"));
		System.out.println(s.move("L"));
		System.out.println(s.move("U"));
	}
}
