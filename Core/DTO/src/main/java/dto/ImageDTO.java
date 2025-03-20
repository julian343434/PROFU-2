package dto;

public class ImageDTO {
    private byte[] originalImage;
    private byte[] processedImage;
    private String filterName;
    private String statusMessage;

    public ImageDTO(byte[] originalImage) {
        this.originalImage = originalImage;
    }

    public byte[] getOriginalImage() { return originalImage; }
    public void setOriginalImage(byte[] originalImage) { this.originalImage = originalImage; }

    public byte[] getProcessedImage() { return processedImage; }
    public void setProcessedImage(byte[] processedImage) { this.processedImage = processedImage; }

    public String getFilterName() { return filterName; }
    public void setFilterName(String filterName) { this.filterName = filterName; }

    public String getStatusMessage() { return statusMessage; }
    public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }
}
