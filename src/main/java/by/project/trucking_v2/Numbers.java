package by.project.trucking_v2;

public class Numbers {
    public int sum(int n) {
        int rez = 0;
        for (int i = 1; i <= n; i++) {
            rez += i;
        }
        return rez;
    }
}
