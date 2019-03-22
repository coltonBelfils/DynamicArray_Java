public enum DataType {
    DYNAMIC_ARRAY(0), ARRAY(1), LINKED_LIST(2), ARRAY_LIST(3);

    int type;
    DataType(int type) {
        this.type = type;
    }
}
