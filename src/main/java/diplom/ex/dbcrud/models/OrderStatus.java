package diplom.ex.dbcrud.models;

public enum OrderStatus {
    В_ОБРАБОТКЕ("В обработке"),
    ГОТОВ("Готов"),
    ЗАВЕРШЕН("Завершен"),
    ОТМЕНЕН("Отменен");

    private final String status;
    OrderStatus(String status){
        this.status=status.toUpperCase();
    }

    public String getStatus(){
        return status;
    }

    public static OrderStatus getUpperStatus(String name){
        return OrderStatus.valueOf(name.toUpperCase());
    }
}
