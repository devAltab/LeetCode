class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            return 1.0 / pow(x, -n);
        }
        return pow(x, n);
        }
    
    public double pow(double x,int n){
        if(n == 0) return 1.0;
        double d = pow(x, n/2);
        if(n % 2 == 0) return(d * d);
        else return (x*d*d);
    }
}