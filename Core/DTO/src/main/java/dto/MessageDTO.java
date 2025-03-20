package dto;

/**
 * DTO para almacenar el mensaje del procesamiento del filtro.
 */
public class MessageDTO {
    private String message;

    public MessageDTO() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
