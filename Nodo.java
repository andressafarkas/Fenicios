import java.util.Objects;

public record Nodo(int x, int y, boolean porto)
{
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return x == nodo.x && y == nodo.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    public String toString()
    {
        return "(" + this.x() + ", " + this.y() + ")";
    }
}
