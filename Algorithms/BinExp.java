package Algorithms;

/**
 * Binary Exponention calculates base^exp in log(n) time
 * For more infomation : https://cp-algorithms.com/algebra/binary-exp.html
 */
public interface BinExp {
    public static long FastExp(long base, long exp) {
        long ans=1;
        long mod=998244353;
        while (exp>0) {
            if (exp%2==1) ans*=base;
            exp/=2;
            base*=base;
            base%=mod;
            ans%=mod;
        }
        return ans;
    }
}