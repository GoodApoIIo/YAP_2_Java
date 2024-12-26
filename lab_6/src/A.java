class A {
    String stringField;

    public A(String str) {
        stringField = str;
    }

    public int cacheTest () {
        System.out.println("Original method");
        return 42;
    }
}
