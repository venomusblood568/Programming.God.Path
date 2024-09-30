import java.util.Collection;

class solution{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer>union = new ArrayList<>();
        for(int i = 0; i < n; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < m; i++){
            set.add(arr2[i]);
        }
        union.add(set);
        Collection.sort(union);
        return union;
    {
}