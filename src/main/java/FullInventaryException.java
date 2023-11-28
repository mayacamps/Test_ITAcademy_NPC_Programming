public class FullInventaryException extends Exception{
    public FullInventaryException() {
        super("[Inventario lleno!- El vendedor no puede comprar el ítem]");
    }
    public FullInventaryException(String message) {
        super(message);
    }
}
