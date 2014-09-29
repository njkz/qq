/**
 * Created by student on 29.09.2014.
 */
public class q2 {
    public static void main(String[] args) {
        boolean[][]field1=new boolean[100][100];

        Display d = new Display();

        field1[50][35] = true;
        field1[51][36] = true;
        field1[52][36] = true;
        field1[52][35] = true;
        field1[52][34] = true;

        d.setMask(field1);
        for (int i=1;i>0;i++) {
            boolean[][]field2=new boolean[100][100];

            for (int y=0;y<100;y++){
                for (int x=0;x<100;x++){
                    int count=0;
                    for (int dy=y-1;dy<=y+1;dy++){
                        for (int dx=x-1;dx<=x+1;dx++){
                            if (dx==x && dy==y) continue;
                            if (dx<0&&dy<100&&dy>-1){dx=99;if (field1[dy][dx]==true) count++;dx=-1;}
                            else if (dy<0&&dx<100&&dx>-1){dy=99;if (field1[dy][dx]==true) count++;dy=-1;}
                            else if (dx>99&&dy<100&&dy>-1){dx=0;if (field1[dy][dx]==true) count++;dx=100;}
                            else if (dy>99&&dx<100&&dx>-1){dy=0;if (field1[dy][dx]==true) count++;dy=100;}
                            else if (dy>99&&dx>99){dy=0;dx=0;if (field1[dy][dx]==true) count++;dy=100;dx=100;}
                            else if (dy<0&&dx<0){dy=99;dx=99;if (field1[dy][dx]==true) count++;dy=-1;dx=-1;}
                            else if (dy>99&&dx<0){dy=0;dx=99;if (field1[dy][dx]==true) count++;dy=100;dx=-1;}
                            else if (dy<0&&dx>99){dy=99;dx=0;if (field1[dy][dx]==true) count++;dy=-1;dx=100;}
                            else if (field1[dy][dx]==true) count++;

                        }
                    }
                    if (field1[y][x]==true && (count==2||count==3)) field2[y][x]=true;
                    if (field1[y][x]==true && (count<2||count>3)) field2[y][x]=false;
                    if (field1[y][x]==false && count==3) field2[y][x]=true;
                }
            }

            field1=field2;
            d.setMask(field2);


        }
    }
}
