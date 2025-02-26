public class FactorialAddition {
    /**
     * 计算1!+2!+......+N!
     * */
    public static void main(String[] args) {
        System.out.println(calculate(3));
    }
    public static int calculate(int n){
        int cur = 1;
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            cur = cur*i;//在上一步的基础上再乘一个n
            ans += cur;
        }
        return ans;
    }
}
