import java.util.Objects;

public class Nodo
{
    int x;

    int y;
    boolean porto;

    int portoId;

    public Nodo(int x, int y, boolean porto)
    {
        this.x = x;
        this.y = y;
        this.porto = porto;
    }

    public Nodo(int x, int y, boolean porto, int portoId)
    {
        this.x = x;
        this.y = y;
        this.porto = porto;
        this.portoId = portoId;
    }

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
        return "(" + x + ", " + y + ")";
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isPorto()
    {
        return porto;
    }

    public void setPorto(boolean porto)
    {
        this.porto = porto;
    }

    public int getPortoId()
    {
        return portoId;
    }

    public void setPortoId(int portoId)
    {
        this.portoId = portoId;
    }
}
