package Interface.Comparable;

class A implements Comparable<A> {
    private int marks;

    public A(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(A other) {
        if (this.marks > other.marks) {
            return 1; // Marks are higher
        } else if (this.marks < other.marks) {
            return -1; // Marks are less
        } else {
            return 0; // Marks are equal
        }
    }
}
