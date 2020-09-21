package stack;

public class NodeWithMin {
    public int value;
    public int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{value:").append(this.value).append(", ")
        .append("min: ").append(this.min).append("}");

        return sb.toString();
    }

}