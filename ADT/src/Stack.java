public class Stack<T> {
    T[] v;
    int n, start, delta;

    public Stack() {
        this(10, 10);
    }

    public Stack(int start, int delta) {
        this.start = (start <= 0) ? 1 : start;
        this.delta = (delta <= 0) ? 1 : delta;
        n = 0;
        v = (T[]) new Object[start];
    }

    public void push(T x) {
        if (v.length == n) {
            T[] v2 = (T[]) new Object[v.length + delta];
            for (int i=0; i<n; i++) v2[i]=v[i];
            v = v2;
        }
        
        v[n++] = x;
    }

    public T pop(int i) {
        if (n==0) return null;
        return v[--n];
    }   
}