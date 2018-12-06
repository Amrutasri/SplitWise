class OutputDriver {
    Object object;
    public void print(Object object) {
        this.object = object;
        System.out.print(object);
    }

    @Override
    public String toString() {
        return "" + object ;
    }
}
