package m;


public class Calculator implements ICalculator {

    @Override
    public int add(int x,int y){
        return x+y;
    }
    @Override
    public float divide(int x, int y) throws RuntimeException{
          	if (y==0)
          		throw new RuntimeException("division by zero");
          	if(x==0)
          		return 0;
          	float z=0;
          	z= (float)x/y;
            return z;
    }
}


