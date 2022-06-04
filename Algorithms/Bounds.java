package Algorithms;

/**
 *  Lower Bound returns the first index of the element if present else present the next highest index in the arrary
 *  Upper Bound returns the index of next higher element that is present in the array.
 */
public interface Bounds {

    static int lowerBound(long a[], long x) { // x is the target value or key
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x) r = m;
            else l = m;
        }
        return r;
    }

    static int upperBound(long a[], long x) {// x is the key or target value
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1L;
            if (a[m] <= x) l = m;
            else r = m;
        }
        return l + 1;
    }

    static int upperBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < N && arr[start] <= k) {
            start++;
        }
        return start;
    }

    static long lowerBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (start < N && arr[start] < k) {
            start++;
        }
        return start;
    }
}