package sliding.window;

public class WidestVerticalArea
{
    public static void main(String[] args) {
        //{8,7},{9,9},{7,4},{9,7}
        //
        int[][] input=new int[][]{{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        WidestVerticalArea wv=new WidestVerticalArea();
        int ans=wv.findWidestArea(input);
        System.out.println(ans);
    }
    public int findWidestArea(int[][] array)
    {
        Widest w=null;
        for (int i = 0; i < array.length-1; i++) {
            int x1=array[i][0];
            int j=i+1;
            int x2=array[j][0];
            if(x1>x2)
            {
                int temp=x1;
                x1=x2;
                x2=temp;
            }
            int width=Math.abs(x1-x2);

                if(w== null)
                {
                    w=new Widest(x1,x2,width);
                }
                else if(width>w.getWidth())
                {
                    if(!checkIntersects(w,x1,x2))
                    {
                        w=new Widest(x1,x2,width);
                    }
                    else {
                        checkCurrentCoordinates(w,x1,x2);
                    }
                }
                else if(width<w.getWidth())
                {
                    if(checkIntersects(w,x1,x2))
                    {
                        w=null;
                    }
                }


        }
        if(w==null)
            return 0;
        return w.getWidth();
    }
    private boolean checkCurrentCoordinates(Widest widest, int x1, int x2)
    {
        int wideX1= widest.getX1();
        int wideX2= widest.getX2();
        if((x1>=wideX1 && x2<=wideX2))
        {
            return true;
        }
        return  false;
    }

    private boolean checkIntersects(Widest widest, int x1, int x2)
    {
        int wideX1= widest.getX1();
        int wideX2= widest.getX2();
        if((x1>=wideX1 && x1<=wideX2) ||(x2>=wideX1 && x2<=wideX2))
            return true;
        return false;
    }

}
class Widest {
    private int x1;
    private int x2;
    private int width;

    public Widest(int x1, int x2, int width) {
        this.x1 = x1;
        this.x2 = x2;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }
}

